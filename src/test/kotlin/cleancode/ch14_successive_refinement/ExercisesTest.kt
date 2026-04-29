package cleancode.ch14_successive_refinement

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class SuccessiveRefinementTest {

    @Test
    fun `parseNaive splits key=value pairs correctly`() {
        val result = subject.parseNaive("host=localhost port=8080")
        assertEquals("localhost", result["host"])
        assertEquals("8080", result["port"])
    }

    @Test
    fun `parseRefined maps flags to true`() {
        val result = subject.parseRefined(listOf("-verbose", "-debug"))
        assertEquals(mapOf("verbose" to true, "debug" to true), result)
    }

    @Test
    fun `parseRefined ignores non-flag arguments`() {
        val result = subject.parseRefined(listOf("-verbose", "someValue"))
        assertTrue(result.containsKey("verbose"))
        assertFalse(result.containsKey("someValue"))
    }

    @Test
    fun `needsExtraction returns true when lines of code exceed threshold`() {
        assertTrue(subject.needsExtraction(linesOfCode = 25, cyclomaticComplexity = 3))
    }

    @Test
    fun `needsExtraction returns true when complexity exceeds threshold`() {
        assertTrue(subject.needsExtraction(linesOfCode = 10, cyclomaticComplexity = 6))
    }

    @Test
    fun `needsExtraction returns false when both metrics are within bounds`() {
        assertFalse(subject.needsExtraction(linesOfCode = 10, cyclomaticComplexity = 2))
    }
}
