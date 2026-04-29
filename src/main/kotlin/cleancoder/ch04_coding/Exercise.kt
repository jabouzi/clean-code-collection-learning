package cleancoder.ch04_coding

object Exercise {
    // Exercise 1: Identify if you're in a productive state to code
    fun isReadyToCode(isRested: Boolean, hasUnderstoodRequirements: Boolean, isDistracted: Boolean): Boolean {
        TODO("Return true only if rested AND understands requirements AND NOT distracted")
    }

    // Exercise 2: Estimate remaining time when running late (linear extrapolation)
    fun estimateRemaining(completedPercent: Double, elapsedHours: Double): Double {
        TODO("Return (1.0 - completedPercent) / completedPercent * elapsedHours")
    }

    // Exercise 3: Debugging discipline — binary search the problem space
    fun binarySearchBug(low: Int, high: Int, bugAt: Int): Int {
        TODO("Return number of steps to find bugAt using binary search between low and high")
    }
}
