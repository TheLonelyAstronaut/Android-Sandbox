//
//  ContentView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI
import shared

struct ContentView: View {
    private let viewModel = DIContainerIOS().getWeatherForecastViewModel();
    
    private let mainImageSize: Int = 100
    private let mainTextSize: Int = 20
    
    private let otherImageSize: Int = 50
    private let otherTextSize: Int = 12
    
    private let date = Date()
    private let formatter = DateFormatter()
    private let calendar = Calendar.current
    
    @State private var city: String = "Minsk"
    @State private var day: String = "Tuesday"
    
    @State private var isLoading: Bool = true
    @State private var showingSheet = false
    
    @State var weatherData: Array<Weather>? = nil
    
    var body: some View {
        ZStack {
            BackgroundView()
            VStack {
                if !isLoading && weatherData != nil && weatherData?.count != 0 {
                    Group {
                        CityNameView(city: $city)
                        WeatherTileView(textSize: mainTextSize,
                                        imageSize: mainImageSize,
                                        day: formatter.string(from: date),
                                        temperature: Double(truncating: weatherData![0].temperature.max ?? 0),
                                        weatherCode: self.getWeatherID(weather: weatherData![0]))
                            .padding(25)
                        HStack {
                            ForEach(weatherData!, id: \.dt) { _weather in
                                let currentIndex = weatherData!.firstIndex(where: { $0 === _weather }) ?? 0
                                
                                if currentIndex != 0 {
                                    WeatherTileView(textSize: otherTextSize,
                                                    imageSize: otherImageSize,
                                                    day: formatter.string(from: calendar.date(byAdding: .day, value: currentIndex, to: date) ?? date),
                                                    temperature: Double(truncating: _weather.temperature.max ?? 0),
                                                    weatherCode: self.getWeatherID(weather: _weather))
                                }
                            }
                        }
                        AppButtonView(text: "Choose city") {
                                    showingSheet = true
                                }
                                .sheet(isPresented: $showingSheet) {
                                    ChooseCityView(searchCallback: self.search)
                                }
                        
                    }
                } else if !isLoading {
                    Group {
                        CityNameView(city: $city)
                        DayTextView(day: "Incorrect city name", size: mainTextSize)
                        AppButtonView(text: "Choose city") {
                                    showingSheet = true
                                }
                                .sheet(isPresented: $showingSheet) {
                                    ChooseCityView(searchCallback: self.search)
                                }
                    }
                } else {
                    Group {
                        ProgressView()
                            .progressViewStyle(CircularProgressViewStyle(tint: Color.white))
                    }
                }
            }
        }.onAppear { self.bindListeners() }
    }
    
    func bindListeners() {
        formatter.setLocalizedDateFormatFromTemplate("dd MMMM")
        
        viewModel.subscribe(observable: viewModel.forecast, onSubscribe: nil, onError: nil, onComplete: nil) { data in
            weatherData = data as? NSArray as? [Weather]
        }
        
        viewModel.subscribe(observable: viewModel.isLoading, onSubscribe: nil, onError: nil, onComplete: nil) { data in
            isLoading = data as? Bool ?? false
        }

        viewModel.getWeatherByCityName(city: city)
    }
    
    func search(city: String) {
        self.city = city
        
        viewModel.getWeatherByCityName(city: city)
    }
    
    func getWeatherID(weather: Weather) -> Int {
        if weather.weather.count == 0 {
            return 0
        }
        
        return Int(weather.weather[0].id)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            ContentView()
                .previewDevice("iPhone 12")
        }
    }
}
