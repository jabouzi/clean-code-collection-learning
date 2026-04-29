package cleancoder.ch12_collaboration

object Solution {
    // Principle: Pair Programming — switch driver/navigator every 30 minutes or less to stay engaged
    fun shouldSwitch(session: PairSession): Boolean {
        return session.durationMinutes >= 30
    }

    // Principle: Collective Code Ownership — everyone owns the code; no one owns it exclusively
    fun isCollectiveOwnership(touchedByDevelopers: Int, totalDevelopers: Int): Boolean {
        return touchedByDevelopers.toDouble() / totalDevelopers >= 0.5
    }

    // Principle: Continuous Review — feedback must be specific and actionable, not vague one-word reactions
    fun isActionableFeedback(comment: String): Boolean {
        return comment.length > 10 && comment.contains(' ')
    }
}
