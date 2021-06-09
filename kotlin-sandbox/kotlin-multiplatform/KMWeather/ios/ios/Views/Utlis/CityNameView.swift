//
//  CityNameView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct CityNameView: View {
    @Binding var city: String
    
    var body: some View {
        Text(city)
            .bold()
            .foregroundColor(.white)
            .font(.system(size: 24, design: .default))
    }
}

