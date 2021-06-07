import SwiftUI
import shared

let viewModel = DIContainerIOS().getWeatherForecastViewModel();

struct ContentView: View {
    @State var text = "Well"
    @State var counter = 0
    @State var weatherData: Array<Weather>? = nil
    
	var body: some View {
        Text(text).onTapGesture (perform: {
            counter += 1
            text = "HEHEHEHEHEHEHE + " + String(counter)
        }).onAppear(perform: {
            viewModel.subscribe(observable: viewModel.forecast, onSubscribe: nil, onError: nil, onComplete: nil) { data in
                weatherData = data as? NSArray as? [Weather]
                
                text = weatherData?.debugDescription ?? "Oh, nil"
            }

            viewModel.getWeatherByCityName(city: "Minsk")
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
