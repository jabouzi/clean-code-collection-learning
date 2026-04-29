package cleancode.ch17_smells_and_heuristics

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class SmellsAndHeuristicsTest {

    @Test
    fun `hasMultipleLanguages returns true when file mixes php and kotlin`() {
        assertTrue(subject.hasMultipleLanguages("fun main() { <?php echo 1; } "))
    }

    @Test
    fun `hasMultipleLanguages returns false for pure kotlin`() {
        assertFalse(subject.hasMultipleLanguages("fun main() { println(\"hello\") }"))
    }

    @Test
    fun `countDuplicateBlocks returns count of duplicated lines`() {
        assertEquals(1, subject.countDuplicateBlocks(listOf("a", "b", "a", "c")))
    }

    @Test
    fun `countDuplicateBlocks returns zero when no duplicates`() {
        assertEquals(0, subject.countDuplicateBlocks(listOf("a", "b", "c")))
    }

    @Test
    fun `countDuplicateBlocks counts each duplicated line once`() {
        // "a" and "b" both appear twice — two duplicate lines
        assertEquals(2, subject.countDuplicateBlocks(listOf("a", "b", "a", "b")))
    }

    @Test
    fun `isDescriptiveName returns false for single character name`() {
        assertFalse(subject.isDescriptiveName("x"))
    }

    @Test
    fun `isDescriptiveName returns true for camelCase name`() {
        assertTrue(subject.isDescriptiveName("customerName"))
    }

    @Test
    fun `isDescriptiveName returns false for all-caps abbreviation`() {
        assertFalse(subject.isDescriptiveName("ACCT"))
    }

    @Test
    fun `hasSufficientTests returns true when coverage meets threshold`() {
        assertTrue(subject.hasSufficientTests(85, 100))
    }

    @Test
    fun `hasSufficientTests returns false when coverage is below threshold`() {
        assertFalse(subject.hasSufficientTests(70, 100))
    }

    @Test
    fun `hasSufficientTests returns true when exactly at threshold`() {
        assertTrue(subject.hasSufficientTests(80, 100))
    }
}
