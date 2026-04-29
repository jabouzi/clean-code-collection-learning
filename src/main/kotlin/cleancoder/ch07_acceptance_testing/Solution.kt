package cleancoder.ch07_acceptance_testing

object Solution {
    // Principle: Given-When-Then eliminates ambiguity between business and developers
    fun parseScenario(text: String): Scenario {
        val givenIdx = text.indexOf("Given:")
        val whenIdx = text.indexOf("When:")
        val thenIdx = text.indexOf("Then:")

        val given = text.substring(givenIdx + "Given:".length, whenIdx).trim()
        val `when` = text.substring(whenIdx + "When:".length, thenIdx).trim()
        val then = text.substring(thenIdx + "Then:".length).trim()

        return Scenario(given, `when`, then)
    }

    // Principle: Complete acceptance criteria have all three parts — incomplete criteria create ambiguity
    fun isCompleteAcceptanceCriterion(given: String, `when`: String, then: String): Boolean {
        return given.isNotBlank() && `when`.isNotBlank() && then.isNotBlank()
    }

    // Principle: Acceptance tests verify the system behaves as the business expects
    fun runAcceptanceTest(feature: String, actualBehavior: String): Boolean {
        return actualBehavior.lowercase().contains(feature.lowercase())
    }
}
