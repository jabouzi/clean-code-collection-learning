package cleancode.ch10_classes

// ── File-scope types shared between Exercise and Solution ──────────────────────

// Exercise 3: SRP — split SuperDashboard into focused classes
class DashboardVersion(val major: Int, val minor: Int) {
    fun getVersion(): String = TODO("Return 'major.minor'")
}

class DashboardFocus {
    private var lastFocused: String = ""
    fun setLastFocused(component: String): Unit = TODO("Store the component")
    fun getLastFocused(): String = TODO("Return stored component")
}

// ──────────────────────────────────────────────────────────────────────────────

object Exercise {
    // Exercise 1: Count responsibilities (one per public method group serving same purpose)
    fun countResponsibilities(publicMethodNames: List<String>): Int {
        TODO("Group methods by concern: getVersion/getMajor/getMinor = 1, addWidget/render = 1 each")
    }

    // Exercise 2: Cohesion — ratio of methods that use ALL instance variables
    fun cohesionScore(totalMethods: Int, methodsUsingAllVars: Int): Double {
        TODO("Return methodsUsingAllVars.toDouble() / totalMethods")
    }
}
