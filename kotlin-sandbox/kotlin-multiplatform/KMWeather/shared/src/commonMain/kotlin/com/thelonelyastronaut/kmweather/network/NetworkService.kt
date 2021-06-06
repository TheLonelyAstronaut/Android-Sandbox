import com.thelonelyastronaut.kmweather.network.INetworkProvider

class NetworkService: INetworkProvider {
    override fun fetchData() = "TEST DI"
}
