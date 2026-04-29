package cleancode.ch07_error_handling

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class ErrorHandlingTest {

    @Test
    fun `sendShutDown throws DeviceException for invalid device`() {
        assertFailsWith<DeviceException> {
            subject.sendShutDown(Device(isValid = false, isSuspended = false))
        }
    }

    @Test
    fun `sendShutDown throws DeviceException for suspended device`() {
        assertFailsWith<DeviceException> {
            subject.sendShutDown(Device(isValid = true, isSuspended = true))
        }
    }

    @Test
    fun `getEmployees returns empty list not null`() {
        val result = subject.getEmployees()
        assertEquals(emptyList(), result)
    }

    @Test
    fun `openPort throws PortDeviceFailure for invalid port number`() {
        assertFailsWith<PortDeviceFailure> {
            subject.openPort(-1)
        }
    }
}
