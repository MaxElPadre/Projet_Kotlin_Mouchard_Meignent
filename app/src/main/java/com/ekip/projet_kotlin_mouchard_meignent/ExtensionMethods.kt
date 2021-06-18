package com.ekip.projet_kotlin_mouchard_meignent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ekip.network.QuestionsNetwork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

const val excellentMessage = "Excellent score !"
const val greatMessage =  "Bon score !"
const val mediumMessage = "Tu peux mieux faire"
const val badMessage = "Franchement pas ouf ..."
const val veryBadMessage = "Nul daniel, Nul !"

enum class Scoring { EXCELLENT, GREAT, MEDIUM, BAD, VERYBAD }

fun Scoring.displayScoreResult(): String = when(this) {
    Scoring.EXCELLENT -> excellentMessage
    Scoring.GREAT -> greatMessage
    Scoring.MEDIUM -> mediumMessage
    Scoring.BAD -> badMessage
    Scoring.VERYBAD -> veryBadMessage
}

fun Int.displayScoreResult(totalQuestion: Int): String = "Ton score est de $this/$totalQuestion"
