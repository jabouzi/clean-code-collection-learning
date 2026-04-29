package cleancoder.ch06_practicing

object Exercise {
    // Exercise 1: Bowling kata — calculate score for a bowling game
    fun bowlingScore(rolls: List<Int>): Int {
        TODO("""
            Calculate score for a 10-frame bowling game.
            Strike (10): 10 + next two rolls bonus
            Spare (frame total 10): 10 + next one roll bonus
            Otherwise: sum of pins
        """)
    }

    // Exercise 2: FizzBuzz kata
    fun fizzBuzz(n: Int): String {
        TODO("Return 'FizzBuzz' if divisible by 15, 'Fizz' by 3, 'Buzz' by 5, else n.toString()")
    }

    // Exercise 3: Track kata repetitions — did you practice enough?
    fun isPracticed(repetitions: Int): Boolean {
        TODO("Return true if repetitions >= 10 (katas require repetition to become muscle memory)")
    }
}
