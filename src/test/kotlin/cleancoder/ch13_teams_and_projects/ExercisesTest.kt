package cleancoder.ch13_teams_and_projects

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class TeamsAndProjectsTest {

    @Test
    fun `teamVelocity averages the last 3 sprints when more data is available`() {
        // last 3: 22, 18, 25 → average = 65/3 ≈ 21.67
        assertEquals(21.67, subject.teamVelocity(listOf(20, 22, 18, 25)), absoluteTolerance = 0.01)
    }

    @Test
    fun `teamVelocity uses all sprints when fewer than 3 are available`() {
        assertEquals(15.0, subject.teamVelocity(listOf(10, 20)), absoluteTolerance = 0.001)
    }

    @Test
    fun `teamVelocity works for exactly 3 sprints`() {
        assertEquals(20.0, subject.teamVelocity(listOf(20, 20, 20)), absoluteTolerance = 0.001)
    }

    @Test
    fun `isGelled returns true when all conditions are met`() {
        assertTrue(subject.isGelled(hasSharedGoal = true, trustLevel = 8, communicationScore = 8))
    }

    @Test
    fun `isGelled returns false when trust is too low`() {
        assertFalse(subject.isGelled(hasSharedGoal = true, trustLevel = 5, communicationScore = 8))
    }

    @Test
    fun `isFractured returns true when projects exceed twice the developer count`() {
        assertTrue(subject.isFractured(developers = 4, simultaneousProjects = 9))
    }

    @Test
    fun `isFractured returns false when projects are within healthy bounds`() {
        assertFalse(subject.isFractured(developers = 4, simultaneousProjects = 8))
    }
}
