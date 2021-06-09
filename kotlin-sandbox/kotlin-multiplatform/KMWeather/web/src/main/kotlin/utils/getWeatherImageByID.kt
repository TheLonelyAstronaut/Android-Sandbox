package utils

fun getWeatherImageByID(id: Int): String = when(id / 100) {
    2 -> "https://img.icons8.com/ios/452/heavy-rain.png"
    3 -> "https://img.icons8.com/ios/452/heavy-rain.png"
    5 -> "https://img.icons8.com/ios/452/heavy-rain.png"
    6 -> "https://findicons.com/files/icons/2770/ios_7_icons/512/storm.png"
    7 -> "https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-cloud-outline-512.png"
    8 -> "https://pics.freeicons.io/uploads/icons/png/7326596361553239397-512.png"
    else -> "https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-cloud-outline-512.png"
}