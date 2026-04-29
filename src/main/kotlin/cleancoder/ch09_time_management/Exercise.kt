package cleancoder.ch09_time_management

object Exercise {
    // Exercise 1: Should you attend this meeting?
    fun shouldAttend(isAgendaProvided: Boolean, isYourPresenceRequired: Boolean, durationMinutes: Int): Boolean {
        TODO("Attend only if: agenda provided AND your presence required AND duration <= 30")
    }

    // Exercise 2: Focus budget — how many focused hours remain after meetings?
    fun focusHoursRemaining(totalHours: Double, meetingHours: Double, overhead: Double = 0.5): Double {
        TODO("Return totalHours - meetingHours - overhead — guard your focus time")
    }

    // Exercise 3: Pomodoro — is this a valid work session?
    fun isValidPomodoro(durationMinutes: Int): Boolean {
        TODO("Return true if duration is exactly 25 minutes — the Pomodoro Technique standard")
    }
}
