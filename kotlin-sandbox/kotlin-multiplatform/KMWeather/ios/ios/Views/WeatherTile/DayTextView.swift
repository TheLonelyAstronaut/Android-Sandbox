//
//  DayTextView.swift
//  TestSwiftUI
//
//  Created by Vadzim Filipovich on 6/8/21.
//

import SwiftUI

struct DayTextView: View {
    @State var day: String
    @State var size: Int
    
    var body: some View {
        Text(day)
            .bold()
            .foregroundColor(.white)
            .font(.system(size: CGFloat(size), design: .rounded))
    }
}
