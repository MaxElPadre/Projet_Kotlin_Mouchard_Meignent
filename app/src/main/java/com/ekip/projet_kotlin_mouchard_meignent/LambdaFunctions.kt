package com.ekip.projet_kotlin_mouchard_meignent

class LambdaFunctions {
    val averageLambdaExpression = { historicScores: List<Int>, totalGamePlayed: Int -> historicScores.sum().toDouble() / if(totalGamePlayed == 0) 1 else totalGamePlayed }
}