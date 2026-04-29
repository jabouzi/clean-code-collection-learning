package cleancode.ch15_junit_internals

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class JUnitInternalsTest {

    @Test
    fun `StringCompactor returns empty string when strings are equal`() {
        // StringCompactor is at package level — instantiate directly
        assertEquals("", StringCompactor(2, "abc", "abc").compact())
    }

    @Test
    fun `StringCompactor compact output contains context around difference`() {
        val result = StringCompactor(2, "abcde", "abXde").compact()
        assertTrue(result.contains("c") || result.contains("b"), "Expected context around diff: $result")
        assertTrue(result.contains("X"), "Expected actual value 'X' in output: $result")
    }

    @Test
    fun `betterNames maps abbreviated field names to descriptive names`() {
        val result = subject.betterNames(listOf("fE", "fA", "fCtx"))
        assertEquals(listOf("fExpected", "fActual", "fContextLength"), result)
    }

    @Test
    fun `betterNames maps all five abbreviated names`() {
        val result = subject.betterNames(listOf("fE", "fA", "fCtx", "fPfxLen", "fSfxLen"))
        assertEquals(listOf("fExpected", "fActual", "fContextLength", "fPrefixLength", "fSuffixLength"), result)
    }

    @Test
    fun `shouldBeCompacted returns true when strings differ`() {
        assertTrue(subject.shouldBeCompacted("a", "b"))
    }

    @Test
    fun `shouldBeCompacted returns false when strings are equal`() {
        assertFalse(subject.shouldBeCompacted("a", "a"))
    }
}
