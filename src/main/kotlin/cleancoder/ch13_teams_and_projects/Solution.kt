package cleancoder.ch13_teams_and_projects

object Solution {
    // Principle: Team Velocity — use recent history (last 3 sprints) as the best predictor
    fun teamVelocity(completedPoints: List<Int>): Double {
        val recent = completedPoints.takeLast(3)
        return recent.sum().toDouble() / recent.size
    }

    // Principle: Team Gel — a gelled team has shared goals, high trust, and strong communication
    fun isGelled(hasSharedGoal: Boolean, trustLevel: Int, communicationScore: Int): Boolean {
        return hasSharedGoal && trustLevel >= 7 && communicationScore >= 7
    }

    // Principle: Fractured Teams — splitting developers across too many projects destroys focus and gel
    fun isFractured(developers: Int, simultaneousProjects: Int): Boolean {
        return simultaneousProjects > developers * 2
    }
}
