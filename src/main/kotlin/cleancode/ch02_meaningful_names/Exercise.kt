package cleancode.ch02_meaningful_names

object Exercise {
    // Exercise 1: Rename this function and variables to reveal intent.
    // The original was named getThem — rename it to reveal the minesweeper context.
    // theList = gameBoard, index 0 = status value, 4 = FLAGGED.
    fun getFlaggedCells(gameBoard: List<IntArray>): List<IntArray> {
        TODO("Apply 'Use Intention-Revealing Names' — what is theList? what does index 0 mean? what is 4?")
    }

    // Exercise 2: Fix the disinformation in parameter names (body is correct).
    // a1 and a2 tell us nothing — rename to reveal source and destination.
    fun copyChars(source: CharArray, destination: CharArray) {
        TODO("Apply 'Avoid Disinformation' — rename a1/a2 to source/destination")
    }

    // Exercise 3: Replace this comment with a well-named function.
    // The original was named checkEmployee with a comment explaining eligibility.
    // Rename so the name itself explains the intent.
    fun isEligibleForFullBenefits(employee: Employee): Boolean {
        TODO("Apply 'Explain Yourself in Code' — rename checkEmployee to isEligibleForFullBenefits")
    }
}

data class Employee(val flags: Int, val age: Int)
const val HOURLY_FLAG = 1
