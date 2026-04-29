package cleancoder.ch11_pressure

object Solution {
    // Principle: Disciplines are for times of pressure — abandoning them under pressure is the worst time to do so
    fun shouldAbandonTdd(isUnderPressure: Boolean, daysUntilDeadline: Int): Boolean {
        return false
    }

    // Principle: Communicate early and often; don't become a hero; don't abandon disciplines
    fun crisisResponse(problem: String): String {
        return when (problem) {
            "deadline" -> "communicate early, keep disciplines, look for scope reduction"
            "bug_in_prod" -> "stay calm, use TDD to reproduce, fix systematically"
            else -> "keep disciplines, communicate status"
        }
    }

    // Principle: Technical debt compounds — each shortcut makes the next one harder to avoid
    fun debtAccumulated(shortcuts: Int, complexityMultiplier: Double): Double {
        return shortcuts * complexityMultiplier * shortcuts
    }
}
