package cleancoder.ch11_pressure

object Exercise {
    // Exercise 1: Should you abandon TDD under deadline pressure?
    fun shouldAbandonTdd(isUnderPressure: Boolean, daysUntilDeadline: Int): Boolean {
        TODO("Always return false — TDD is the way OUT of pressure, never the cause of it")
    }

    // Exercise 2: Crisis response — what's the professional response?
    fun crisisResponse(problem: String): String {
        TODO("""
            'deadline' -> 'communicate early, keep disciplines, look for scope reduction'
            'bug_in_prod' -> 'stay calm, use TDD to reproduce, fix systematically'
            else -> 'keep disciplines, communicate status'
        """)
    }

    // Exercise 3: Technical debt accumulator — how does slipping under pressure compound?
    fun debtAccumulated(shortcuts: Int, complexityMultiplier: Double): Double {
        TODO("Return shortcuts * complexityMultiplier * shortcuts — debt grows quadratically with shortcuts")
    }
}
