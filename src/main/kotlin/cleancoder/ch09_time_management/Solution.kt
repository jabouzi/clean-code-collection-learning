package cleancoder.ch09_time_management

object Solution {
    // Principle: Decline meetings that lack agenda, don't require your presence, or run too long
    fun shouldAttend(isAgendaProvided: Boolean, isYourPresenceRequired: Boolean, durationMinutes: Int): Boolean {
        return isAgendaProvided && isYourPresenceRequired && durationMinutes <= 30
    }

    // Principle: Focus/Mana — guard your concentration budget; meetings drain it
    fun focusHoursRemaining(totalHours: Double, meetingHours: Double, overhead: Double = 0.5): Double {
        return totalHours - meetingHours - overhead
    }

    // Principle: Time-box work sessions using the Pomodoro Technique (25-min focused blocks)
    fun isValidPomodoro(durationMinutes: Int): Boolean {
        return durationMinutes == 25
    }
}
