import com.thelonelyastronaut.kmweather.DIContainerJS
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    val viewModel = DIContainerJS.getWeatherForecastViewModel()

    viewModel.subscribe(viewModel.forecast, onNext = {
        console.log("RESULT", it)
    })

    viewModel.subscribe(viewModel.isLoading, onNext = {
        console.log("LOADING", it)
    })

    viewModel.getWeatherByCityName("Minsk")

    window.onload = {
        render(document.getElementById("root")) {
            child(Welcome::class) {
                attrs {
                    name = "Kotlin/JS"
                }
            }
        }
    }
}
