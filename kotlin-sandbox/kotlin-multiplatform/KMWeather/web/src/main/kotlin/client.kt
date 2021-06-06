import com.thelonelyastronaut.kmweather.KodeinMP
import com.thelonelyastronaut.kmweather.KodeinMPJS
import com.thelonelyastronaut.kmweather.di.mainModule
import com.thelonelyastronaut.kmweather.di.network.testModule
import com.thelonelyastronaut.kmweather.network.INetworkProvider
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import org.kodein.di.*

fun main() {
    val kodein = KodeinMPJS()
    console.log(kodein.fetchWeather())

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
