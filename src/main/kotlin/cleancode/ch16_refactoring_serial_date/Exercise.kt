package cleancode.ch16_refactoring_serial_date

object Exercise {
    // Exercise 1: The original messy function — replace magic numbers with named constants
    fun addDays(date: SimpleDate, days: Int): SimpleDate {
        TODO("Implement correctly. Use DAYS_IN_NON_LEAP_YEAR = 365, not magic numbers")
    }

    // Exercise 2: Extract enum — replace int month with Month enum.
    // Access via subject.Month.fromInt(n)
    object Month {
        fun fromInt(v: Int): MonthValue {
            TODO("Return MonthValue with correct name and value, or throw if invalid")
        }
    }

    // Exercise 3: isLeapYear — replace messy nested ifs with clean boolean expression
    fun isLeapYear(year: Int): Boolean {
        TODO("divisible by 4 AND (not divisible by 100 OR divisible by 400)")
    }
}

/** Immutable value object representing a calendar month. */
data class MonthValue(val name: String, val value: Int)

data class SimpleDate(val year: Int, val month: Int, val day: Int)
