import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModel
import components.WeatherTile
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import styled.css
import styled.styledDiv
import styled.styledInput
import kotlin.js.Date

external interface WeatherScreenProps : RProps {
    var viewModel: WeatherForecastViewModel
}

data class WeatherScreenState(
    var city: String,
    var weatherList: List<Weather>,
    var isLoading: Boolean
) : RState

@JsExport
class WeatherScreen(props: WeatherScreenProps) :
    RComponent<WeatherScreenProps, WeatherScreenState>(props) {

    init {
        state = WeatherScreenState(
            city = "Minsk",
            weatherList = listOf(),
            isLoading = false
        )

        props.viewModel.subscribe(props.viewModel.forecast) { weather ->
            console.log(weather)
            setState({ WeatherScreenState(it.city, weather, it.isLoading) })
        }

        props.viewModel.subscribe(props.viewModel.isLoading) { isLoading ->
            setState({ WeatherScreenState(it.city, it.weatherList, isLoading) })
        }
    }

    override fun componentDidMount() {
        search(state.city)
    }

    private fun search(city: String) {
        setState({ WeatherScreenState(it.city, it.weatherList, true) })
        props.viewModel.getWeatherByCityName(city)
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +WeatherStyles.backgroundComponent
            }
            styledInput {
                css {
                    +WeatherStyles.textInput
                }
                attrs {
                    type = InputType.text
                    value = state.city
                    onChangeFunction = { event ->
                        val value = (event.target as HTMLInputElement).value

                        setState({
                            WeatherScreenState(value, it.weatherList, true)
                        })

                        search(value)
                    }
                }

            }
            styledDiv {
                css {
                    +WeatherStyles.weatherContainer
                }

                if(state.isLoading) {
                    div("loader") {

                    }
                } else {
                    state.weatherList.map {
                        child(WeatherTile::class) {
                            attrs {
                                weather = it
                                index = state.weatherList.indexOf(it)
                            }
                        }
                    }
                }
            }
        }
    }
}
