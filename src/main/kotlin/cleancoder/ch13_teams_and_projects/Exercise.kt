package cleancoder.ch13_teams_and_projects

object Exercise {
    // Exercise 1: Calculate team velocity (average of last 3 sprint story points)
    fun teamVelocity(completedPoints: List<Int>): Double {
        TODO("Return average of the LAST 3 completed sprint velocities (or all if fewer than 3) — use takeLast(3)")
    }

    // Exercise 2: Team gel check — is the team working as one?
    fun isGelled(hasSharedGoal: Boolean, trustLevel: Int, communicationScore: Int): Boolean {
        TODO("Return true if hasSharedGoal AND trustLevel >= 7 AND communicationScore >= 7")
    }

    // Exercise 3: Fractured team risk — too many projects per developer?
    fun isFractured(developers: Int, simultaneousProjects: Int): Boolean {
        TODO("Return true if simultaneousProjects > developers * 2 — team is spread too thin")
    }
}
