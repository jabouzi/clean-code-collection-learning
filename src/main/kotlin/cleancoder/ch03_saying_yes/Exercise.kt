package cleancoder.ch03_saying_yes

object Exercise {
    // Exercise 1: Language of commitment — does this statement use commitment language?
    fun usesCommitmentLanguage(statement: String): Boolean {
        TODO("Return true if starts with 'I will' or 'I am going to' — not 'I'll try' or 'we should'")
    }

    // Exercise 2: Identify what's stopping commitment and return a resolution
    fun resolveBlocker(blocker: String): String {
        TODO("""
            If blocker == 'dependency' return 'communicate dependency to stakeholder'
            If blocker == 'unclear' return 'clarify requirement before committing'
            Else return 'raise concern immediately'
        """)
    }

    // Exercise 3: Partial commitment — commit to what you CAN do
    fun partialCommitment(canDeliver: List<String>, requested: List<String>): List<String> {
        TODO("Return intersection of canDeliver and requested — commit only to what is possible")
    }
}
