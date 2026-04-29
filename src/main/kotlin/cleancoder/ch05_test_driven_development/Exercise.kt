package cleancoder.ch05_test_driven_development

object Exercise {
    // Exercise 1: Three laws — validate a TDD cycle step
    fun isValidTddStep(step: String, hasFailingTest: Boolean): Boolean {
        TODO("""
            'write_prod_code' requires hasFailingTest == true
            'write_test' requires hasFailingTest == false
            'refactor' requires hasFailingTest == false (tests pass)
        """)
    }

    // Exercise 2: Kata — prime factors (classic TDD kata)
    fun primeFactors(n: Int): List<Int> {
        TODO("Return prime factors of n in ascending order. e.g. 12 -> [2,2,3]")
    }

    // Exercise 3: Coverage as documentation — does test name describe behavior?
    fun isBehavioralTestName(name: String): Boolean {
        TODO("Return true if name starts with 'should' or uses backtick notation with spaces (Kotlin style)")
    }
}
