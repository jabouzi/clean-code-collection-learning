package cleancode.ch16_refactoring_serial_date

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class RefactoringSerialDateTest {

    @Test
    fun `addDays advances day within same month`() {
        assertEquals(SimpleDate(2026, 4, 30), subject.addDays(SimpleDate(2026, 4, 29), 1))
    }

    @Test
    fun `addDays crosses month boundary correctly`() {
        assertEquals(SimpleDate(2026, 5, 1), subject.addDays(SimpleDate(2026, 4, 29), 2))
    }

    @Test
    fun `addDays crosses year boundary correctly`() {
        assertEquals(SimpleDate(2027, 1, 1), subject.addDays(SimpleDate(2026, 12, 31), 1))
    }

    @Test
    fun `Month fromInt returns correct enum value`() {
        // Month is now at file scope — access directly
        assertEquals(1, Month.fromInt(1).value)
        assertEquals(12, Month.fromInt(12).value)
        assertEquals(4, Month.fromInt(4).value)
    }

    @Test
    fun `Month fromInt returns january for value 1`() {
        assertEquals("JANUARY", Month.fromInt(1).name)
    }

    @Test
    fun `isLeapYear returns true for year divisible by 400`() {
        assertTrue(subject.isLeapYear(2000))
    }

    @Test
    fun `isLeapYear returns false for year divisible by 100 but not 400`() {
        assertFalse(subject.isLeapYear(1900))
    }

    @Test
    fun `isLeapYear returns true for year divisible by 4 but not 100`() {
        assertTrue(subject.isLeapYear(2024))
    }

    @Test
    fun `isLeapYear returns false for non-leap year`() {
        assertFalse(subject.isLeapYear(2023))
    }
}
