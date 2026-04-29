package cleancode.ch04_comments

object Exercise {
    // Exercise 1: Replace this comment with a well-named function.
    // Returns true if employee qualifies (hourly worker over 65).
    fun check(flags: Int, age: Int): Boolean {
        TODO("Rename to isEligibleForFullBenefits and remove the comment — explain yourself in code")
    }

    // Exercise 2: This regex needs a comment — or does it? Extract to a named constant/function.
    fun isValidTimestamp(input: String): Boolean {
        TODO("Use a named val TIMESTAMP_PATTERN = Regex(...) so the comment is unnecessary")
    }

    // Exercise 3: Remove the noise — rewrite without redundant comments.
    fun getCustomerName(id: Int): String {
        // Gets the customer name
        // Returns the name of the customer
        TODO("Same function, zero comments — code speaks for itself")
    }
}
