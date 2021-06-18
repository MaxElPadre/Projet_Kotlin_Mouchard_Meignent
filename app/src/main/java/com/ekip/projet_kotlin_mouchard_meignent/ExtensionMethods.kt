package com.ekip.projet_kotlin_mouchard_meignent

fun Scoring.displayScoreResult(): String = when(this) {
    Scoring.EXCELLENT -> excellentMessage
    Scoring.BAD -> badMessage
    Scoring.WTFBRO -> wtfMessage
}

fun Int.displayScoreResult(totalQuestion: Int): String = "Ton score est de $this/$totalQuestion"
