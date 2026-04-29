package cleancoder.ch03_saying_yes

object Solution {
    private val commitmentPrefixes = listOf("I will", "I am going to")

    // Principle: Language of commitment — say it, mean it, do it
    fun usesCommitmentLanguage(statement: String): Boolean {
        return commitmentPrefixes.any { prefix -> statement.startsWith(prefix) }
    }

    // Principle: Identify blockers and raise them — don't commit when you know you can't
    fun resolveBlocker(blocker: String): String {
        return when (blocker) {
            "dependency" -> "communicate dependency to stakeholder"
            "unclear" -> "clarify requirement before committing"
            else -> "raise concern immediately"
        }
    }

    // Principle: Partial commitment is still commitment — be precise about what you can deliver
    fun partialCommitment(canDeliver: List<String>, requested: List<String>): List<String> {
        return canDeliver.intersect(requested.toSet()).toList()
    }
}
