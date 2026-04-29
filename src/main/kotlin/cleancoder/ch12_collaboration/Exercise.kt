package cleancoder.ch12_collaboration

data class PairSession(val driver: String, val navigator: String, val durationMinutes: Int)

object Exercise {
    // Exercise 1: Pair programming — should roles be switched?
    fun shouldSwitch(session: PairSession): Boolean {
        TODO("Return true if durationMinutes >= 30 — switch roles regularly to maintain engagement")
    }

    // Exercise 2: Code ownership — collective ownership check
    fun isCollectiveOwnership(touchedByDevelopers: Int, totalDevelopers: Int): Boolean {
        TODO("Return true if touchedByDevelopers.toDouble() / totalDevelopers >= 0.5")
    }

    // Exercise 3: Review value — is this feedback actionable?
    fun isActionableFeedback(comment: String): Boolean {
        TODO("Return true if comment length > 10 AND contains a space — i.e. a substantive sentence")
    }
}
