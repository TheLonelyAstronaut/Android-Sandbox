import SwiftUI
import shared

struct ContentView: View {
    let weather = KodeinMPiOS()
    
	var body: some View {
        Text(weather.fetchWeather())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
