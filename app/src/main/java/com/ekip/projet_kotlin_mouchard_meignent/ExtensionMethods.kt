package com.ekip.projet_kotlin_mouchard_meignent

fun Scoring.displayScoreResult(): String = when(this) {
    Scoring.EXCELLENT -> excellentMessage
    Scoring.GREAT -> greatMessage
    Scoring.MEDIUM -> mediumMessage
    Scoring.BAD -> badMessage
    Scoring.VERYBAD -> veryBadMessage
}

fun Int.displayScoreResult(totalQuestion: Int): String = "Ton score est de $this/$totalQuestion"
