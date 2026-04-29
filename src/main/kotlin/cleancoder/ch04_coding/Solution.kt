package cleancoder.ch04_coding

object Solution {
    // Principle: Preparedness — only code when you are in the right mental state
    fun isReadyToCode(isRested: Boolean, hasUnderstoodRequirements: Boolean, isDistracted: Boolean): Boolean {
        return isRested && hasUnderstoodRequirements && !isDistracted
    }

    // Principle: Pacing and honesty — give accurate estimates when running late
    fun estimateRemaining(completedPercent: Double, elapsedHours: Double): Double {
        return (1.0 - completedPercent) / completedPercent * elapsedHours
    }

    // Principle: Debugging discipline — systematically bisect the problem space
    fun binarySearchBug(low: Int, high: Int, bugAt: Int): Int {
        var steps = 0
        var lo = low
        var hi = high
        while (lo < hi) {
            steps++
            val mid = (lo + hi) / 2
            if (bugAt <= mid) hi = mid else lo = mid + 1
        }
        return steps
    }
}
