package cleancode.ch16_refactoring_serial_date

@Suppress("EnumEntryName")
object Solution {
    // Named constants replace magic numbers — intent is immediately clear
    private val DAYS_IN_MONTHS = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    private const val MONTHS_IN_YEAR = 12

    // Principle: Replace Magic Numbers with Named Constants
    fun addDays(date: SimpleDate, days: Int): SimpleDate {
        var year = date.year
        var month = date.month
        var day = date.day + days

        while (day > daysInMonth(month, year)) {
            day -= daysInMonth(month, year)
            month++
            if (month > MONTHS_IN_YEAR) {
                month = 1
                year++
            }
        }
        return SimpleDate(year, month, day)
    }

    private fun daysInMonth(month: Int, year: Int): Int =
        if (month == 2 && isLeapYear(year)) 29 else DAYS_IN_MONTHS[month]

    // Principle: Use Enums to Replace int Constants — type-safe, self-documenting month names
    enum class Month(val value: Int) {
        JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
        JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

        companion object {
            fun fromInt(v: Int): Month =
                entries.firstOrNull { it.value == v }
                    ?: throw IllegalArgumentException("Invalid month value: $v")
        }
    }

    // Principle: Clean Boolean Expression — single expression, no nested ifs
    fun isLeapYear(year: Int): Boolean =
        year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}
