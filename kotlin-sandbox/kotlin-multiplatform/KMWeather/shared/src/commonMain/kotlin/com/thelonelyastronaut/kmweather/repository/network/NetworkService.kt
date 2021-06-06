import com.thelonelyastronaut.kmweather.repository.network.INetworkProvider
import com.thelonelyastronaut.kmweather.utils.ILogger

class NetworkService(private val _logger: ILogger): INetworkProvider {
    override fun fetchData(): String {
        _logger.log("Well, nice")
        return "TEST DI"
    }
}
