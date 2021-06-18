package com.ekip.projet_kotlin_mouchard_meignent

inline fun executeOperation(x: Int, y: Int, operation: (Int, Int) -> Double) : Double = operation(x, y)