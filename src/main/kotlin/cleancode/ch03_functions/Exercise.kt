package cleancode.ch03_functions

object Exercise {
    // Exercise 1: This function does 3 things — split into isTestPage(), includeSetupPages(), includeContent().
    fun renderPageWithSetupsAndTeardowns(pageData: PageData, isSuite: Boolean): String {
        TODO("Split into small functions each doing ONE thing")
    }

    // Exercise 2: Fix this switch — use sealed class dispatch instead of string-based switching.
    fun calculatePay(employeeType: String, hours: Double, rate: Double): Double {
        TODO("Replace string-based switch with sealed class polymorphism")
    }

    // Exercise 3: Command-query separation — this does both setting and querying. Split it.
    // Should set the attribute AND return whether the key existed before.
    fun setAndReturnAttribute(obj: MutableMap<String, String>, key: String, value: String): Boolean {
        TODO("Split into setAttribute() and hasAttribute() — no side effects on queries")
    }
}

data class PageData(val content: String, val isTestPage: Boolean)
