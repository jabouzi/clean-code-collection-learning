package cleancode.ch04_comments

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class CommentsTest {

    @Test
    fun `check returns true for hourly worker over 65`() {
        // hourly flag = 1, age 66 qualifies
        assertTrue(subject.check(1, 66))
    }

    @Test
    fun `check returns false for hourly worker aged 64`() {
        // hourly flag = 1, age 64 does not qualify
        assertFalse(subject.check(1, 64))
    }

    @Test
    fun `isValidTimestamp accepts a well-formed timestamp`() {
        assertTrue(subject.isValidTimestamp("14:30:00 Mon, Apr 29 2026"))
    }

    @Test
    fun `isValidTimestamp rejects a non-timestamp string`() {
        assertFalse(subject.isValidTimestamp("not-a-date"))
    }

    @Test
    fun `getCustomerName returns a non-empty string for a known id`() {
        val name = subject.getCustomerName(1)
        assertTrue(name.isNotEmpty())
    }
}
