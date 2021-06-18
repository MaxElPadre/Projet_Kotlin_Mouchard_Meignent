package com.ekip.projet_kotlin_mouchard_meignent

class HighOrderFunctions {
    inline fun executeOperation(x: Any, y: Any, operation: (Any, Any) -> Double) : Double = operation(x, y)
}