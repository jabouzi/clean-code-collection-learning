package cleancode.ch09_unit_tests

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class UnitTestsTest {

    @Test
    fun `getSystemState encodes ON as uppercase and OFF as lowercase`() {
        val hw = ControlHardware(heater = true, blower = true, cooler = false, hiTempAlarm = false, loTempAlarm = true)
        assertEquals("HBchL", subject.getSystemState(hw))
    }

    @Test
    fun `isFastTest returns true for tests under 100ms`() {
        assertTrue(subject.isFastTest(50L))
    }

    @Test
    fun `isFastTest returns false for tests at or over 100ms`() {
        assertFalse(subject.isFastTest(200L))
    }

    @Test
    fun `isIndependentTest returns true when no shared state is used`() {
        assertTrue(subject.isIndependentTest(usesSharedState = false))
    }

    @Test
    fun `isIndependentTest returns false when shared state is used`() {
        assertFalse(subject.isIndependentTest(usesSharedState = true))
    }

    @Test
    fun `hasSingleConcept returns false when test name contains And`() {
        assertFalse(subject.hasSingleConcept("testAddAndRemove"))
    }

    @Test
    fun `hasSingleConcept returns true when test name addresses one concept`() {
        assertTrue(subject.hasSingleConcept("testAdd"))
    }
}
