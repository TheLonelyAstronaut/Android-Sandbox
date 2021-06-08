//
//  WeatherTileView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct WeatherTileView: View {
    @State var textSize: Int
    @State var imageSize: Int
    @State var day: String
    @State var temperature: Double
    @State var weatherCode: Int
    
    var body: some View {
        VStack {
            DayTextView(day: day, size: textSize)
            WeatherImageView(size: imageSize, imageName: getWeatherImageByID(id: weatherCode))
            TemperatureTextView(temperature: temperature, size: textSize)
        }
    }
}
