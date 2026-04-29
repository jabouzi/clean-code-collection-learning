package cleancode.ch01_clean_code

object Exercise {
    // Exercise 1: This function does too much — identify by returning a list of responsibility names.
    // Count the number of "And" occurrences + 1 to identify responsibilities from a camelCase function name.
    fun responsibilities(fn: String): List<String> {
        TODO("Apply 'Single Responsibility Principle' — count how many things this function name implies")
    }

    // Exercise 2: True/False — does this satisfy the Boy Scout Rule?
    // The Boy Scout Rule: leave the code cleaner than you found it.
    // Use string length as a proxy: shorter = cleaner (simplified model).
    fun isBoyScoutCompliant(before: String, after: String): Boolean {
        TODO("Apply 'Boy Scout Rule' — is 'after' cleaner (shorter) than 'before'?")
    }

    // Exercise 3: Calculate the "WTF/minute" rate (ratio of bad lines to total).
    // Clean code minimises the WTF rate during code reviews.
    fun wtfRate(totalLines: Int, badLines: Int): Double {
        TODO("Return the ratio badLines / totalLines — the lower, the cleaner the code")
    }
}
