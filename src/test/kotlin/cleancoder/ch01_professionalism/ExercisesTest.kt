package cleancoder.ch01_professionalism

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class ProfessionalismTest {

    @Test
    fun `bug cost includes both fix time and customer time`() {
        assertEquals(600.0, subject.bugCost(100.0, 4.0, 2.0))
    }

    @Test
    fun `bug cost with zero customer impact is just fix time`() {
        assertEquals(200.0, subject.bugCost(100.0, 2.0, 0.0))
    }

    @Test
    fun `code is cleaner when both metrics improve`() {
        assertTrue(subject.isCodeCleaner(CodeMetrics(10, 20.0), CodeMetrics(5, 15.0)))
    }

    @Test
    fun `code is not cleaner when warnings increase`() {
        assertFalse(subject.isCodeCleaner(CodeMetrics(5, 20.0), CodeMetrics(10, 15.0)))
    }

    @Test
    fun `code is not cleaner when function length increases`() {
        assertFalse(subject.isCodeCleaner(CodeMetrics(10, 15.0), CodeMetrics(5, 20.0)))
    }

    @Test
    fun `100 percent coverage is professional`() {
        assertTrue(subject.isProfessionalCoverage(100, 100))
    }

    @Test
    fun `90 percent coverage is not professional enough`() {
        assertFalse(subject.isProfessionalCoverage(90, 100))
    }
}
