package cleancoder.ch01_professionalism

object Solution {
    // Principle: Professionals own their mistakes — bugs have a real cost to the team and customer
    fun bugCost(hourlyRate: Double, hoursToFix: Double, hoursCustomerLost: Double): Double {
        return hourlyRate * hoursToFix + hoursCustomerLost * hourlyRate
    }

    // Principle: Boy Scout Rule — always leave the code cleaner than you found it
    fun isCodeCleaner(before: CodeMetrics, after: CodeMetrics): Boolean {
        return after.warnings < before.warnings && after.avgFunctionLength < before.avgFunctionLength
    }

    // Principle: 100% test coverage is the professional standard — no excuses
    fun isProfessionalCoverage(coveredLines: Int, totalLines: Int): Boolean {
        return coveredLines.toDouble() / totalLines >= 1.0
    }
}
