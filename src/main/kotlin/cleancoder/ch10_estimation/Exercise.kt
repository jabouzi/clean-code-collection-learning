package cleancoder.ch10_estimation

object Exercise {
    // Exercise 1: PERT expected duration
    fun pertExpected(optimistic: Double, nominal: Double, pessimistic: Double): Double {
        TODO("Return (optimistic + 4*nominal + pessimistic) / 6 — weighted average formula")
    }

    // Exercise 2: PERT standard deviation
    fun pertStdDev(optimistic: Double, pessimistic: Double): Double {
        TODO("Return (pessimistic - optimistic) / 6 — one sigma of the estimate range")
    }

    // Exercise 3: 95% confidence range (expected ± 2 standard deviations)
    fun confidenceRange(expected: Double, stdDev: Double): Pair<Double, Double> {
        TODO("Return Pair(expected - 2*stdDev, expected + 2*stdDev) — two-sigma interval")
    }
}
