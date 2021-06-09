//
//  AppButtonView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct AppButtonView: View {
    @State var text: String
    @State var onButtonPress: () -> Void
    
    var body: some View {
        Button(text) { onPress() }
            .padding(30)
            .foregroundColor(.white)
    }
    
    func onPress() {
        onButtonPress()
    }
}
