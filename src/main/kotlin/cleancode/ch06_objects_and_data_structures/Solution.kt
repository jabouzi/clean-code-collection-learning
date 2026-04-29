package cleancode.ch06_objects_and_data_structures

import kotlin.math.PI

// NOTE: Vehicle, Car, Shape, Square, Circle are defined at file scope in Exercise.kt (same package).
// Solution does not redefine them — it shows the correct implementations via inline comments.

object Solution {
    // Principle: Law of Demeter — tell, don't ask. Call method on ctxt directly instead of chaining.
    fun getScratchFilePath(ctxt: AppContext, className: String): String {
        return ctxt.createScratchFileStream(className)
    }
}

// Principle: Data Abstraction — expose behaviour (percentage), not internal representation (gallons).
// The shared Car class at file scope demonstrates: override fun getPercentFuelRemaining() = gallons / capacity

// Principle: Data/Object Anti-Symmetry — OO uses polymorphism so adding a new shape requires
// no change to existing code; the type system dispatches correctly.
// Square solution: override fun area() = side * side
// Circle solution: override fun area() = PI * radius * radius
