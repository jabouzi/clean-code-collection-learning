package cleancode.ch10_classes

// NOTE: DashboardVersion and DashboardFocus are defined at file scope in Exercise.kt (same package).
// Solution does not redefine them.

object Solution {
    // Principle: Single Responsibility Principle — count the number of distinct responsibilities
    // (reasons to change). Version-related methods share one responsibility; widget methods
    // form another.
    fun countResponsibilities(publicMethodNames: List<String>): Int {
        val versionMethods = setOf("getVersion", "getMajor", "getMinor")
        val widgetMethods = setOf("addWidget", "render")
        // Each non-empty intersection with a known group counts as one responsibility
        var count = 0
        if (publicMethodNames.any { it in versionMethods }) count++
        if (publicMethodNames.any { it in widgetMethods }) count++
        // Any remaining methods each represent their own responsibility
        val known = versionMethods + widgetMethods
        count += publicMethodNames.count { it !in known }
        return count
    }

    // Principle: Cohesion — high cohesion means most methods use most instance variables.
    // A score of 1.0 is maximally cohesive; 0.0 means no method uses all variables.
    fun cohesionScore(totalMethods: Int, methodsUsingAllVars: Int): Double =
        methodsUsingAllVars.toDouble() / totalMethods
}

// Principle: SRP — DashboardVersion has exactly one reason to change: version format.
// Solution for DashboardVersion: fun getVersion() = "$major.$minor"

// Principle: SRP — DashboardFocus has exactly one reason to change: focus tracking.
// Solution for DashboardFocus:
//   fun setLastFocused(component: String) { lastFocused = component }
//   fun getLastFocused(): String = lastFocused
