package cleancoder.ch04_coding

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class CodingTest {

    @Test
    fun `rested and focused developer is ready to code`() {
        assertTrue(subject.isReadyToCode(true, true, false))
    }

    @Test
    fun `tired developer is not ready to code`() {
        assertFalse(subject.isReadyToCode(false, true, false))
    }

    @Test
    fun `distracted developer is not ready to code`() {
        assertFalse(subject.isReadyToCode(true, true, true))
    }

    @Test
    fun `developer who misunderstood requirements is not ready to code`() {
        assertFalse(subject.isReadyToCode(true, false, false))
    }

    @Test
    fun `estimate remaining is symmetric when halfway done`() {
        assertEquals(4.0, subject.estimateRemaining(0.5, 4.0))
    }

    @Test
    fun `estimate remaining when one quarter done`() {
        assertEquals(6.0, subject.estimateRemaining(0.25, 2.0))
    }

    @Test
    fun `binary search finds bug within log2 of range steps`() {
        val steps = subject.binarySearchBug(0, 100, 75)
        assertTrue(steps <= 7, "Expected at most 7 steps, got $steps")
    }

    @Test
    fun `binary search finds bug at beginning of range`() {
        val steps = subject.binarySearchBug(0, 100, 0)
        assertTrue(steps <= 7, "Expected at most 7 steps, got $steps")
    }
}
