package com.github.devlusk.navigationsample.navigation

object Routes {
    const val FIRST_SCREEN = "first_screen"
    const val SECOND_SCREEN = "second_screen"

    fun secondScreenWithArg(userName: String): String {
        return "$SECOND_SCREEN/$userName"
    }
}
