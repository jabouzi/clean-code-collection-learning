package cleancode.ch06_objects_and_data_structures

import kotlin.math.PI

object Solution {
    // Principle: Law of Demeter — tell, don't ask. Call method on ctxt directly instead of chaining.
    fun getScratchFilePath(ctxt: AppContext, className: String): String {
        return ctxt.createScratchFileStream(className)
    }

    // Principle: Data Abstraction — expose behaviour (percentage), not internal representation (gallons).
    interface Vehicle {
        fun getPercentFuelRemaining(): Double
    }

    class Car(val gallons: Double, val capacity: Double) : Vehicle {
        // Principle: Data Abstraction — callers need not know about gallons or capacity
        override fun getPercentFuelRemaining(): Double = gallons / capacity
    }

    // Principle: Data/Object Anti-Symmetry — OO uses polymorphism so adding a new shape requires
    // no change to existing code; the type system dispatches correctly.
    interface Shape { fun area(): Double }
    class Square(val side: Double) : Shape { override fun area(): Double = side * side }
    class Circle(val radius: Double) : Shape { override fun area(): Double = PI * radius * radius }
}
