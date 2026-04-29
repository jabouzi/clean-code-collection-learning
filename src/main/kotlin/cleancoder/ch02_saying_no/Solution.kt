package cleancoder.ch02_saying_no

object Solution {
    private val weaselWords = listOf("try", "maybe", "should", "might", "hope")

    // Principle: Real commitments have no wiggle words — "I will" not "I'll try"
    fun isRealCommitment(statement: String): Boolean {
        return weaselWords.none { word -> statement.lowercase().contains(word) }
    }

    // Principle: Saying no opens a conversation — negotiation finds the real possible outcome
    fun negotiate(developerDays: Int, managerDays: Int): Int {
        return (developerDays + managerDays) / 2
    }

    // Principle: Saying yes when you can't deliver causes disaster — courage to say no protects everyone
    fun costOfYes(featureComplexity: Int, currentCapacity: Int): String {
        return if (featureComplexity > currentCapacity) "disaster" else "ok"
    }
}
