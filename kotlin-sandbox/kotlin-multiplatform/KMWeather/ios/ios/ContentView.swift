import SwiftUI
import shared

struct ContentView: View {
    let weather = DIContainerIOS().fetchWeather();
    
	var body: some View {
        Text(weather)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
