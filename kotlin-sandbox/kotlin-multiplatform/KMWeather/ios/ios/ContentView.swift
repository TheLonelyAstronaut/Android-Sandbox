import SwiftUI
import shared

let viewModel = DIContainerIOS().getWeatherForecastViewModel();

struct ContentView: View {
    @State var text = "Well"
    
	var body: some View {
        Text(text).onTapGesture (perform: {
            viewModel.subscribe(observable: viewModel.forecast, onSubscribe: nil, onError: nil, onComplete: nil) { data in text = data.debugDescription }

            viewModel.getWeatherByCityName(city: "Minsk")
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
