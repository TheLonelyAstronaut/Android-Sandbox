import com.thelonelyastronaut.kmweather.DIContainerJS
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    console.log(DIContainerJS.fetchWeather())

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
