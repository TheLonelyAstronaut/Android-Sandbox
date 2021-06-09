import com.thelonelyastronaut.kmweather.DIContainerJS
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

fun main() {

    CoroutineScope(Dispatchers.Main).async {
        DIContainerJS.initDB()
    }

    window.onload = {
        render(document.getElementById("root")) {
            child(WeatherScreen::class) {
                attrs {
                    viewModel = DIContainerJS.getWeatherForecastViewModel()
                }
            }
        }
    }
}
