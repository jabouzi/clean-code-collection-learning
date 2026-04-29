package cleancode.ch04_comments

// Principle: Use searchable named constants instead of magic numbers in patterns.
private val TIMESTAMP_PATTERN = Regex(
    """\d{2}:\d{2}:\d{2}\s+\w+,\s+\w+\s+\d+\s+\d{4}"""
)

private const val HOURLY_FLAG = 1

// Principle: A map serves as a simple deterministic customer store for demonstration.
private val CUSTOMER_NAMES = mapOf(
    1 to "Alice",
    2 to "Bob"
)

object Solution {
    // Principle: Explain Yourself in Code — the function name replaces the comment entirely.
    fun isEligibleForFullBenefits(flags: Int, age: Int): Boolean =
        (flags and HOURLY_FLAG) != 0 && age > 65

    // Keep Exercise entry point aligned with test expectations.
    fun check(flags: Int, age: Int): Boolean = isEligibleForFullBenefits(flags, age)

    // Principle: Named constants make regex patterns self-documenting — no comment required.
    fun isValidTimestamp(input: String): Boolean = TIMESTAMP_PATTERN.containsMatchIn(input)

    // Principle: Noise comments add nothing; the function name already describes what it does.
    fun getCustomerName(id: Int): String = CUSTOMER_NAMES[id] ?: "Customer#$id"
}
