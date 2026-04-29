package cleancoder.ch05_test_driven_development

object Solution {
    // Principle: Three Laws of TDD — no production code without a failing test
    fun isValidTddStep(step: String, hasFailingTest: Boolean): Boolean {
        return when (step) {
            "write_prod_code" -> hasFailingTest
            "write_test" -> !hasFailingTest
            "refactor" -> !hasFailingTest
            else -> false
        }
    }

    // Principle: TDD as design tool — prime factors kata grown test by test
    fun primeFactors(n: Int): List<Int> {
        val factors = mutableListOf<Int>()
        var remaining = n
        var divisor = 2
        while (remaining > 1) {
            while (remaining % divisor == 0) {
                factors.add(divisor)
                remaining /= divisor
            }
            divisor++
        }
        return factors
    }

    // Principle: Tests as documentation — names should describe observable behavior
    fun isBehavioralTestName(name: String): Boolean {
        return name.startsWith("should") || name.contains(" ")
    }
}
