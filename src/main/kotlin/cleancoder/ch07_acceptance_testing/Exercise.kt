package cleancoder.ch07_acceptance_testing

data class Scenario(val given: String, val `when`: String, val then: String)

object Exercise {
    // Exercise 1: Parse a Given-When-Then scenario into parts
    fun parseScenario(text: String): Scenario {
        TODO("Split on 'Given:', 'When:', 'Then:' keywords and return trimmed parts")
    }

    // Exercise 2: Validate acceptance criterion completeness
    fun isCompleteAcceptanceCriterion(given: String, `when`: String, then: String): Boolean {
        TODO("Return true if all three parts are non-blank")
    }

    // Exercise 3: Simulate acceptance test execution
    fun runAcceptanceTest(feature: String, actualBehavior: String): Boolean {
        TODO("Return true if actualBehavior contains feature (case-insensitive substring match)")
    }
}
