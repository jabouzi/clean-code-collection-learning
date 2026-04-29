package cleancoder.ch09_time_management

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class TimeManagementTest {

    @Test
    fun `shouldAttend returns true when all criteria are met`() {
        assertTrue(subject.shouldAttend(isAgendaProvided = true, isYourPresenceRequired = true, durationMinutes = 25))
    }

    @Test
    fun `shouldAttend returns false when no agenda is provided`() {
        assertFalse(subject.shouldAttend(isAgendaProvided = false, isYourPresenceRequired = true, durationMinutes = 25))
    }

    @Test
    fun `shouldAttend returns false when presence is not required`() {
        assertFalse(subject.shouldAttend(isAgendaProvided = true, isYourPresenceRequired = false, durationMinutes = 25))
    }

    @Test
    fun `shouldAttend returns false when meeting is too long`() {
        assertFalse(subject.shouldAttend(isAgendaProvided = true, isYourPresenceRequired = true, durationMinutes = 60))
    }

    @Test
    fun `focusHoursRemaining subtracts meetings and overhead from total`() {
        assertEquals(4.5, subject.focusHoursRemaining(totalHours = 8.0, meetingHours = 3.0), absoluteTolerance = 0.001)
    }

    @Test
    fun `isValidPomodoro returns true for exactly 25 minutes`() {
        assertTrue(subject.isValidPomodoro(25))
    }

    @Test
    fun `isValidPomodoro returns false for non-standard duration`() {
        assertFalse(subject.isValidPomodoro(30))
    }
}
