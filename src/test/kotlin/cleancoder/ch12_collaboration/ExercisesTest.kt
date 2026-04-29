package cleancoder.ch12_collaboration

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class CollaborationTest {

    @Test
    fun `shouldSwitch returns true after 30 or more minutes`() {
        assertTrue(subject.shouldSwitch(PairSession(driver = "Alice", navigator = "Bob", durationMinutes = 31)))
    }

    @Test
    fun `shouldSwitch returns false before 30 minutes`() {
        assertFalse(subject.shouldSwitch(PairSession(driver = "Alice", navigator = "Bob", durationMinutes = 20)))
    }

    @Test
    fun `shouldSwitch returns true at exactly 30 minutes`() {
        assertTrue(subject.shouldSwitch(PairSession(driver = "Alice", navigator = "Bob", durationMinutes = 30)))
    }

    @Test
    fun `isCollectiveOwnership returns true when majority of devs touched the code`() {
        assertTrue(subject.isCollectiveOwnership(touchedByDevelopers = 4, totalDevelopers = 6))
    }

    @Test
    fun `isCollectiveOwnership returns false when only a minority touched the code`() {
        assertFalse(subject.isCollectiveOwnership(touchedByDevelopers = 1, totalDevelopers = 6))
    }

    @Test
    fun `isActionableFeedback returns false for short vague comments`() {
        assertFalse(subject.isActionableFeedback("ok"))
    }

    @Test
    fun `isActionableFeedback returns true for substantive feedback`() {
        assertTrue(subject.isActionableFeedback("extract this into a separate function"))
    }
}
