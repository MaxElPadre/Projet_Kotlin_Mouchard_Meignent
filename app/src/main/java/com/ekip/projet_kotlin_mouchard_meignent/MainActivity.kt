package com.ekip.projet_kotlin_mouchard_meignent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var userName: String

    /* Block d'Implementation futur d'un easter egg by lazy (maybe we can instance a service in a future) */
    val easterEggFirstSentence: String by lazy {
        "Bravo, c'est ici que l'histoire commence, cherche dans notre application pour découvrir ce qu'elle cache"
    }

    val easterEggSecondSentence: String by lazy {
        "Yes ! tu as atteind la second étape, il ne te reste plus grand chose, encore quelque effort"
    }
    /* Block d'Implementation futur d'un easter egg by lazy */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

const val excellent = "Excellent score !"
const val great =  "Bon score !"
const val medium = "Tu peux mieux faire"
const val bad = "Franchement pas ouf ..."

enum class Scoring { EXCELLENT, GREAT, MEDIUM, BAD }

class ExtensionMethods {

    fun Scoring.displayScoreResult(): String = when(this) {
        Scoring.EXCELLENT -> excellent
        Scoring.GREAT -> great
        Scoring.MEDIUM -> medium
        Scoring.BAD -> bad
    }

    fun Int.displayScoreResult(totalQuestion: Int): String = "Ton score est de $this/$totalQuestion"
}

class BadEnumException(val customMessage: String = "Wrong enumerator value") : Exception()

class HighOrderFunctions {
    inline fun executeOperation(x: Any, y: Any, operation: (Any, Any) -> Double) : Double = operation(x, y)
}

class LambdaFunctions {
    val averageLambdaExpression = { historicScores: List<Int>, totalGamePlayed: Int -> historicScores.sum().toDouble() / if(totalGamePlayed == 0) 1 else totalGamePlayed }
}