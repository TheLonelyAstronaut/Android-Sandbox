import com.thelonelyastronaut.kmweather.declarations.Weather
import com.thelonelyastronaut.kmweather.presentation.WeatherForecastViewModel
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv
import styled.styledInput

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
            setState({ WeatherScreenState(it.city, weather, it.isLoading) })
        }

        props.viewModel.subscribe(props.viewModel.isLoading) { isLoading ->
            setState({ WeatherScreenState(it.city, it.weatherList, isLoading) })
        }
    }

    override fun componentDidMount() {
        search()
    }

    fun search() {
        props.viewModel.getWeatherByCityName(state.city)
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +WelcomeStyles.textContainer
            }
            +"Hello, ${state.name}"
        }
        styledInput {
            css {
                +WelcomeStyles.textInput
            }
            attrs {
                type = InputType.text
                value = state.name
                onChangeFunction = { event ->
                    setState(
                        WelcomeState(name = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }
    }
}
