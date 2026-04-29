package cleancode.ch03_functions

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class FunctionsTest {

    @Test
    fun `renderPageWithSetupsAndTeardowns includes content from PageData`() {
        val page = PageData("content", true)
        val result = subject.renderPageWithSetupsAndTeardowns(page, false)
        assertTrue(result.contains("content"))
    }

    @Test
    fun `calculatePay for hourly type returns hours times rate`() {
        assertEquals(80.0, subject.calculatePay("hourly", 8.0, 10.0))
    }

    @Test
    fun `calculatePay for salaried type returns fixed rate`() {
        assertEquals(5000.0, subject.calculatePay("salaried", 160.0, 5000.0))
    }

    @Test
    fun `setAndReturnAttribute returns false when key did not exist before`() {
        val map = mutableMapOf<String, String>()
        val existed = subject.setAndReturnAttribute(map, "color", "red")
        assertFalse(existed)
        assertEquals("red", map["color"])
    }

    @Test
    fun `setAndReturnAttribute returns true when key already existed`() {
        val map = mutableMapOf("color" to "blue")
        val existed = subject.setAndReturnAttribute(map, "color", "red")
        assertTrue(existed)
        assertEquals("red", map["color"])
    }
}
