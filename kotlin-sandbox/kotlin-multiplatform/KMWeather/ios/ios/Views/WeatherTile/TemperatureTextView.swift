//
//  TemperatureTextView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct TemperatureTextView: View {
    @State var temperature: Double
    @State var size: Int
    
    var body: some View {
        Text("\(String(format: "%.1f", temperature)) °C")
            .bold()
            .foregroundColor(.white)
            .font(.system(size: CGFloat(size), design: .rounded))
    }
}
