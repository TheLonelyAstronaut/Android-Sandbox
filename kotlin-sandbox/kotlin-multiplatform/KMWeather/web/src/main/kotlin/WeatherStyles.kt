import kotlinx.css.*
import styled.StyleSheet

object WeatherStyles : StyleSheet("WelcomeStyles", isStatic = true) {
    val textInput by css {
        margin(vertical = 30.px)

        fontSize = 14.px
    }

    val backgroundComponent by css {
        height = LinearDimension.fillAvailable
        width = LinearDimension.fillAvailable
        display = Display.flex
        flexDirection = FlexDirection.column
        justifyContent = JustifyContent.center
        alignItems = Align.center

        background = "linear-gradient(#a4b0be, #747d8c, #57606f, #2f3542);"
    }

    val weatherContainer by css {
        display = Display.flex
        flexDirection = FlexDirection.row
        width = LinearDimension.fillAvailable
        height = 200.px
        justifyContent = JustifyContent.spaceAround
        alignItems = Align.center

        margin(horizontal = 50.px)
    }
} 
