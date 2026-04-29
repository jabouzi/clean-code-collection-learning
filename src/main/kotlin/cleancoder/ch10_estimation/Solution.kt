package cleancoder.ch10_estimation

object Solution {
    // Principle: PERT — Program Evaluation and Review Technique gives a probabilistic estimate
    fun pertExpected(optimistic: Double, nominal: Double, pessimistic: Double): Double {
        return (optimistic + 4 * nominal + pessimistic) / 6.0
    }

    // Principle: Standard deviation quantifies uncertainty — larger spread = less certainty
    fun pertStdDev(optimistic: Double, pessimistic: Double): Double {
        return (pessimistic - optimistic) / 6.0
    }

    // Principle: 95% confidence interval — commit to a range, not a single point
    fun confidenceRange(expected: Double, stdDev: Double): Pair<Double, Double> {
        return Pair(expected - 2 * stdDev, expected + 2 * stdDev)
    }
}
