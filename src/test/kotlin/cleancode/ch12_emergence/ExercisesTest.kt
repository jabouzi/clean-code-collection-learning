package cleancode.ch12_emergence

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class EmergenceTest {

    // Note: HtmlRenderer and StringUtils are at file scope — construct them directly.
    // primaryTermination is dispatched through `subject` (supports solution swap).

    @Test
    fun `HtmlRenderer renders full html structure`() {
        val renderer = HtmlRenderer()
        assertEquals("<html><body>hello</body></html>", renderer.render("hello"))
    }

    @Test
    fun `primaryTermination returns true when string ends with period`() {
        assertTrue(subject.primaryTermination("end."))
    }

    @Test
    fun `primaryTermination returns false when string does not end with period`() {
        assertFalse(subject.primaryTermination("no"))
    }

    @Test
    fun `StringUtils reverse returns reversed string`() {
        assertEquals("cba", StringUtils().reverse("abc"))
    }

    @Test
    fun `StringUtils isPalindrome returns true for palindrome`() {
        assertTrue(StringUtils().isPalindrome("racecar"))
    }

    @Test
    fun `StringUtils isPalindrome returns false for non-palindrome`() {
        assertFalse(StringUtils().isPalindrome("hello"))
    }
}
