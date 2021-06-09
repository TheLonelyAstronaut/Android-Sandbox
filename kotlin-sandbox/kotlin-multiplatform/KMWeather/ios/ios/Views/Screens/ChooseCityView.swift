//
//  ChooseCityView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct ChooseCityView: View {
    @State var searchCallback: (_ city: String) -> Void
    @State private var typedCity: String = ""
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        ZStack {
            BackgroundView()
            VStack {
                ZStack(alignment: .leading) {
                    if typedCity.isEmpty { Text("Enter location...").foregroundColor(.white) }
                    TextField("", text: $typedCity)
                        .font(.system(size: 16, weight: .regular, design: .default))
                        .foregroundColor(.white)
                }.padding(30)
                AppButtonView(text: "Select") {
                        onButtonPress()
                    }
            }
        }
    }
    
    func onButtonPress() {
        searchCallback(typedCity)
        presentationMode.wrappedValue.dismiss()
    }
}
