package cleancode.ch01_clean_code

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class CleanCodeTest {

    @Test
    fun `responsibilities splits a camelCase function name on And`() {
        // processUserAndSendEmailAndUpdateDB implies 3 distinct responsibilities
        assertEquals(3, subject.responsibilities("processUserAndSendEmailAndUpdateDB").size)
    }

    @Test
    fun `isBoyScoutCompliant returns true when after is shorter than before`() {
        assertTrue(subject.isBoyScoutCompliant("messy code here", "cleaner code"))
    }

    @Test
    fun `isBoyScoutCompliant returns false when after is longer than before`() {
        assertFalse(subject.isBoyScoutCompliant("cleaner code", "messy code here"))
    }

    @Test
    fun `wtfRate returns the ratio of bad lines to total lines`() {
        assertEquals(0.2, subject.wtfRate(100, 20))
    }
}
