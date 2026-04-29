package cleancode.ch06_objects_and_data_structures

object Exercise {
    // Exercise 1: Fix the train wreck — tell the object what to do, don't ask about its internals
    fun getScratchFilePath(ctxt: AppContext, className: String): String {
        TODO("Call ctxt.createScratchFileStream(className) — don't navigate ctxt.options.scratchDir.path")
    }

    // Exercise 2: Abstract the fuel — expose percentage not raw gallons
    interface Vehicle {
        fun getPercentFuelRemaining(): Double
    }

    class Car(val gallons: Double, val capacity: Double) : Vehicle {
        override fun getPercentFuelRemaining(): Double =
            TODO("Return gallons/capacity as a percentage 0.0–1.0")
    }

    // Exercise 3: Procedural → OO. Add area() to each shape instead of using instanceof
    interface Shape { fun area(): Double }
    class Square(val side: Double) : Shape { override fun area(): Double = TODO("Return side * side") }
    class Circle(val radius: Double) : Shape { override fun area(): Double = TODO("Return PI * radius * radius") }
}

class AppContext(val scratchDir: String)
fun AppContext.createScratchFileStream(className: String) = "$scratchDir/$className.tmp"
