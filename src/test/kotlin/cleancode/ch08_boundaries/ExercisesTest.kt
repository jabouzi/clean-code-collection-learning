package cleancode.ch08_boundaries

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class BoundariesTest {

    @Test
    fun `SensorMap add then getById returns correct sensor`() {
        val map = subject.SensorMap()
        val sensor = Sensor("s1", 42.0)
        map.add("s1", sensor)
        assertEquals(sensor, map.getById("s1"))
    }

    @Test
    fun `SensorMap getById for unknown id returns null`() {
        val map = subject.SensorMap()
        assertNull(map.getById("unknown"))
    }

    @Test
    fun `verifyLoggerBehavior returns true when all messages are non-blank`() {
        assertTrue(subject.verifyLoggerBehavior(listOf("msg1", "msg2")))
    }

    @Test
    fun `verifyLoggerBehavior returns false when any message is blank`() {
        assertFalse(subject.verifyLoggerBehavior(listOf("", "msg")))
    }
}
