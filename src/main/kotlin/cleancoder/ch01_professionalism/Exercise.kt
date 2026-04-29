package cleancoder.ch01_professionalism

data class CodeMetrics(val warnings: Int, val avgFunctionLength: Double)

object Exercise {
    // Exercise 1: Professionalism means owning your bugs. Calculate cost of a bug to the team.
    fun bugCost(hourlyRate: Double, hoursToFix: Double, hoursCustomerLost: Double): Double {
        TODO("Return hourlyRate * hoursToFix + hoursCustomerLost * hourlyRate")
    }

    // Exercise 2: Boy Scout Rule — is the code cleaner than when you checked it out?
    fun isCodeCleaner(before: CodeMetrics, after: CodeMetrics): Boolean {
        TODO("Return true if after has fewer warnings AND shorter average function length")
    }

    // Exercise 3: Test coverage check — is it professional?
    fun isProfessionalCoverage(coveredLines: Int, totalLines: Int): Boolean {
        TODO("Return true only if coverage >= 1.0 (100%) — professionals demand it all")
    }
}
