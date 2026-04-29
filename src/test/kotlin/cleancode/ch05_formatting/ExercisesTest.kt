package cleancode.ch05_formatting

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class FormattingTest {

    @Test
    fun `correctDeclarationOrder follows newspaper metaphor — high-level first`() {
        assertEquals(
            listOf("publicApi", "helperCalledByApi", "privateDetail"),
            subject.correctDeclarationOrder()
        )
    }

    @Test
    fun `lineCompliance returns 0 point 5 when half the lines exceed the limit`() {
        val lines = listOf("short", "a".repeat(130))
        assertEquals(0.5, subject.lineCompliance(lines))
    }

    @Test
    fun `lineCompliance returns 1 point 0 when all lines are within the limit`() {
        val lines = listOf("short", "also short")
        assertEquals(1.0, subject.lineCompliance(lines))
    }

    @Test
    fun `followsStepDownRule returns true for a valid stepdown call graph`() {
        // a calls b, b calls c — all callees appear after their callers
        val graph = mapOf("a" to listOf("b"), "b" to listOf("c"), "c" to emptyList())
        assertTrue(subject.followsStepDownRule(graph))
    }

    @Test
    fun `followsStepDownRule returns false when a function calls one declared before it`() {
        // c calls a, but a is declared before c — violates stepdown rule
        val graph = mapOf("a" to emptyList<String>(), "b" to listOf("a"), "c" to listOf("a"))
        assertFalse(subject.followsStepDownRule(graph))
    }
}
