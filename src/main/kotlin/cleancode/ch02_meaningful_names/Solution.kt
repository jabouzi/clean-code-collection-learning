package cleancode.ch02_meaningful_names

object Solution {
    // Principle: Intention-Revealing Names — every name answers why it exists, what it does, how it is used.
    fun getFlaggedCells(gameBoard: List<IntArray>): List<IntArray> {
        val STATUS_VALUE = 0
        val FLAGGED = 4
        return gameBoard.filter { cell -> cell[STATUS_VALUE] == FLAGGED }
    }

    // Principle: Avoid Disinformation — a1/a2 misleads; source/destination communicates intent clearly.
    fun copyChars(source: CharArray, destination: CharArray) {
        for (i in source.indices) destination[i] = source[i]
    }

    // Principle: Explain Yourself in Code — no comment needed when the function name says it all.
    fun isEligibleForFullBenefits(employee: Employee): Boolean =
        (employee.flags and HOURLY_FLAG) != 0 && employee.age > 65
}
