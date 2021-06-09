//
//  WeatherImageView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct WeatherImageView: View {
    @State var size: Int
    @State var imageName: String
    
    var body: some View {
        Image(systemName: imageName)
            .resizable()
            .colorInvert()
            .aspectRatio(contentMode: .fit)
            .frame(width: CGFloat(size), height: CGFloat(size))
            .padding()
    }
}
