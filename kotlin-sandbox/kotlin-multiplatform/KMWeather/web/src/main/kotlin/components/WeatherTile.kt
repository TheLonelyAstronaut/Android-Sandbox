package components

import com.thelonelyastronaut.kmweather.declarations.Weather
import react.dom.img
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.p
import react.dom.div
import utils.getWeatherImageByID
import kotlin.js.Date

external interface WeatherTileProps : RProps {
    var weather: Weather
    var index: Int
}

data class WeatherTileState(var icon: String, val date: Date) : RState

@JsExport
class WeatherTile(props: WeatherTileProps) :
    RComponent<WeatherTileProps, WeatherTileState>(props) {
        init {
            val currentDate = Date()

            state = WeatherTileState(
                getWeatherImageByID(
                    if(props.weather.weather.isNotEmpty()) props.weather.weather[0].id
                    else 0
                ),
                Date(
                    currentDate.getFullYear(),
                    currentDate.getMonth(),
                    currentDate.getDate() + props.index
                )
            )
        }

        override fun RBuilder.render() {
            div("weather-container") {
                p("temperature") {
                    +"${state.date.getDate()}.${state.date.getMonth() + 1}.${state.date.getFullYear()}"
                }
                img(
                    src = getWeatherImageByID(
                        if(props.weather.weather.isNotEmpty()) props.weather.weather[0].id
                        else 0
                    ),
                    classes = "weather-logo"
                ) { }
                p("temperature") {
                    +"${props.weather.temperature.max} °C"
                }
            }
        }
}