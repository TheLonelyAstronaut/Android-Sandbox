//
//  BackgroundView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct BackgroundView: View {
    var body: some View {
        LinearGradient(gradient: Gradient(
                        colors: [Color(red: 52 / 255, green: 73 / 255, blue: 94 / 255),
                                 Color(red: 44 / 255, green: 62 / 255, blue: 88 / 255)]),
                       startPoint: .top,
                       endPoint: .bottom)
            .ignoresSafeArea()
    }
}
