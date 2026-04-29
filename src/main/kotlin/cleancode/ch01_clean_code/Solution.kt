package cleancode.ch01_clean_code

object Solution {
    // Principle: Single Responsibility — a function name with multiple "And"s reveals multiple responsibilities.
    // Split camelCase by uppercase letters, then count segments separated by "And".
    fun responsibilities(fn: String): List<String> {
        // Split on "And" that is surrounded by word boundaries (camelCase convention).
        return fn.split(Regex("(?<=[a-z])And(?=[A-Z])"))
    }

    // Principle: Boy Scout Rule — always leave the code cleaner than you found it.
    // We use string length as a simple proxy for "cleanliness" (fewer characters ≈ less clutter).
    fun isBoyScoutCompliant(before: String, after: String): Boolean =
        after.length < before.length

    // Principle: Measure code quality by the WTF/minute rate during review.
    // A ratio close to 0 means clean code; close to 1 means a mess.
    fun wtfRate(totalLines: Int, badLines: Int): Double =
        badLines.toDouble() / totalLines
}
