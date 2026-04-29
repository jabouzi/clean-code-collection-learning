package cleancode.ch02_meaningful_names

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class MeaningfulNamesTest {

    @Test
    fun `getFlaggedCells returns only flagged cells from game board`() {
        val FLAGGED = 4
        val board = listOf(intArrayOf(0), intArrayOf(FLAGGED), intArrayOf(2))
        // Hint: your function should be named getFlaggedCells, not getThem
        assertEquals(1, subject.getFlaggedCells(board).size)
    }

    @Test
    fun `copyChars copies from source to destination`() {
        val src = charArrayOf('h', 'i')
        val dst = CharArray(2)
        subject.copyChars(src, dst)
        assertEquals(src.toList(), dst.toList())
    }

    @Test
    fun `eligibility check expressed as intent-revealing function name`() {
        val eligible = Employee(flags = HOURLY_FLAG, age = 66)
        val notEligible = Employee(flags = HOURLY_FLAG, age = 64)
        // Hint: rename checkEmployee to isEligibleForFullBenefits
        assertTrue(subject.isEligibleForFullBenefits(eligible))
        assertTrue(!subject.isEligibleForFullBenefits(notEligible))
    }
}
