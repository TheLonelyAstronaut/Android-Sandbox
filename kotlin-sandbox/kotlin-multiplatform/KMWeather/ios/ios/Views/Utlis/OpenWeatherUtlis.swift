//
//  OpenWeatherUtlis.swift
//  ios
//
//  Created by Vadzim Filipovich on 6/8/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

func getWeatherImageByID(id: Int) -> String {
    let firstDigit = Int(id / 100)
    
    switch firstDigit {
    case 2:
        return "cloud.bolt.rain"
    case 3:
        return "cloud.drizzle"
    case 5:
        return "cloud.rain"
    case 6:
        return "cloud.snow"
    case 7:
        return "smoke"
    case 8:
        return "sun.max"
    default:
        return "questionmark.square"
    }
}
