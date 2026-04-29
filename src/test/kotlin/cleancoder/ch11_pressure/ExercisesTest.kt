package cleancoder.ch11_pressure

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class PressureTest {

    @Test
    fun `shouldAbandonTdd is always false even under extreme pressure`() {
        assertFalse(subject.shouldAbandonTdd(isUnderPressure = true, daysUntilDeadline = 1))
    }

    @Test
    fun `shouldAbandonTdd is always false when there is no pressure`() {
        assertFalse(subject.shouldAbandonTdd(isUnderPressure = false, daysUntilDeadline = 100))
    }

    @Test
    fun `crisisResponse for deadline contains communicate`() {
        assertTrue(subject.crisisResponse("deadline").contains("communicate"))
    }

    @Test
    fun `crisisResponse for bug_in_prod mentions staying calm`() {
        assertTrue(subject.crisisResponse("bug_in_prod").contains("calm"))
    }

    @Test
    fun `crisisResponse for unknown problem keeps disciplines`() {
        assertTrue(subject.crisisResponse("unknown").contains("disciplines"))
    }

    @Test
    fun `debtAccumulated grows quadratically with shortcuts`() {
        assertEquals(18.0, subject.debtAccumulated(shortcuts = 3, complexityMultiplier = 2.0), absoluteTolerance = 0.001)
    }
}
