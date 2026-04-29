package cleancoder.ch05_test_driven_development

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class TestDrivenDevelopmentTest {

    @Test
    fun `writing production code without a failing test is invalid`() {
        assertFalse(subject.isValidTddStep("write_prod_code", false))
    }

    @Test
    fun `writing production code with a failing test is valid`() {
        assertTrue(subject.isValidTddStep("write_prod_code", true))
    }

    @Test
    fun `writing a test when tests are already failing is invalid`() {
        assertFalse(subject.isValidTddStep("write_test", true))
    }

    @Test
    fun `refactoring when tests pass is valid`() {
        assertTrue(subject.isValidTddStep("refactor", false))
    }

    @Test
    fun `prime factors of 1 is empty`() {
        assertEquals(emptyList<Int>(), subject.primeFactors(1))
    }

    @Test
    fun `prime factors of 2 is just 2`() {
        assertEquals(listOf(2), subject.primeFactors(2))
    }

    @Test
    fun `prime factors of 12 is 2 2 3`() {
        assertEquals(listOf(2, 2, 3), subject.primeFactors(12))
    }

    @Test
    fun `prime factors of 7 is just 7`() {
        assertEquals(listOf(7), subject.primeFactors(7))
    }

    @Test
    fun `prime factors of 100 is 2 2 5 5`() {
        assertEquals(listOf(2, 2, 5, 5), subject.primeFactors(100))
    }

    @Test
    fun `should prefix makes a behavioral test name`() {
        assertTrue(subject.isBehavioralTestName("shouldReturnEmptyWhenInputIsZero"))
    }

    @Test
    fun `space in name indicates Kotlin backtick style behavioral test`() {
        assertTrue(subject.isBehavioralTestName("returns empty when input is zero"))
    }

    @Test
    fun `cryptic test name without should or spaces is not behavioral`() {
        assertFalse(subject.isBehavioralTestName("testMethod1"))
    }
}
