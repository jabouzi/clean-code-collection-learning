package cleancoder.ch06_practicing

object Solution {
    // Principle: Katas build muscle memory — the bowling scorer is a classic kata
    fun bowlingScore(rolls: List<Int>): Int {
        var score = 0
        var rollIndex = 0
        repeat(10) { _ ->
            when {
                rolls[rollIndex] == 10 -> {
                    // Strike: add 10 plus next two rolls as bonus
                    score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2]
                    rollIndex += 1
                }
                rolls[rollIndex] + rolls[rollIndex + 1] == 10 -> {
                    // Spare: add 10 plus next one roll as bonus
                    score += 10 + rolls[rollIndex + 2]
                    rollIndex += 2
                }
                else -> {
                    score += rolls[rollIndex] + rolls[rollIndex + 1]
                    rollIndex += 2
                }
            }
        }
        return score
    }

    // Principle: FizzBuzz — simple kata for warming up and teaching TDD
    fun fizzBuzz(n: Int): String {
        return when {
            n % 15 == 0 -> "FizzBuzz"
            n % 3 == 0 -> "Fizz"
            n % 5 == 0 -> "Buzz"
            else -> n.toString()
        }
    }

    // Principle: Repetition is the path to mastery — 10 repetitions minimum for a kata
    fun isPracticed(repetitions: Int): Boolean {
        return repetitions >= 10
    }
}
