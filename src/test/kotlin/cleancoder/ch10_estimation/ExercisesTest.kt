package cleancoder.ch10_estimation

import kotlin.test.Test
import kotlin.test.assertEquals

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class EstimationTest {

    @Test
    fun `PERT expected value uses weighted average formula`() {
        // (1 + 4*4 + 7) / 6 = 24/6 = 4.0 exactly
        assertEquals(4.0, subject.pertExpected(optimistic = 1.0, nominal = 4.0, pessimistic = 7.0), absoluteTolerance = 0.01)
    }

    @Test
    fun `PERT standard deviation is one sixth of the range`() {
        assertEquals(1.0, subject.pertStdDev(optimistic = 1.0, pessimistic = 7.0), absoluteTolerance = 0.001)
    }

    @Test
    fun `confidence range spans two standard deviations on each side`() {
        val range = subject.confidenceRange(expected = 4.0, stdDev = 1.0)
        assertEquals(2.0, range.first, absoluteTolerance = 0.001)
        assertEquals(6.0, range.second, absoluteTolerance = 0.001)
    }
}
