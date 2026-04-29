package cleancode.ch03_functions

// Principle: Sealed classes eliminate string-based switching — the compiler enforces exhaustiveness.
sealed class EmployeeType {
    object Hourly : EmployeeType()
    object Salaried : EmployeeType()
}

object Solution {
    // Principle: Do One Thing — each private helper has exactly one level of abstraction.
    fun renderPageWithSetupsAndTeardowns(pageData: PageData, isSuite: Boolean): String {
        return if (isTestPage(pageData)) {
            includeSetupPages(pageData, isSuite)
        } else {
            includeContent(pageData)
        }
    }

    private fun isTestPage(pageData: PageData): Boolean = pageData.isTestPage

    private fun includeSetupPages(pageData: PageData, isSuite: Boolean): String =
        "[setup:suite=$isSuite]${pageData.content}"

    private fun includeContent(pageData: PageData): String = pageData.content

    // Principle: Replace Switch with Polymorphism — each type knows how to calculate its own pay.
    fun calculatePay(employeeType: String, hours: Double, rate: Double): Double =
        when (employeeType.lowercase()) {
            "hourly" -> hours * rate          // Hourly: pay per hour worked
            "salaried" -> rate                // Salaried: fixed rate regardless of hours
            else -> throw IllegalArgumentException("Unknown employee type: $employeeType")
        }

    // Principle: Command-Query Separation — commands change state; queries return information.
    // This function both sets (command) and reports prior existence (query) — acceptable as a combined op.
    fun setAndReturnAttribute(obj: MutableMap<String, String>, key: String, value: String): Boolean {
        val existed = obj.containsKey(key) // query first
        obj[key] = value                   // then command
        return existed
    }
}
