package cleancoder.ch06_practicing

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class PracticingTest {

    @Test
    fun `gutter game scores zero`() {
        assertEquals(0, subject.bowlingScore(List(20) { 0 }))
    }

    @Test
    fun `all ones scores 20`() {
        assertEquals(20, subject.bowlingScore(List(20) { 1 }))
    }

    @Test
    fun `perfect game scores 300`() {
        assertEquals(300, subject.bowlingScore(List(12) { 10 }))
    }

    @Test
    fun `spare gives bonus of next roll`() {
        // Frame 1: spare (5+5), Frame 2: 3+0, rest gutter
        val rolls = mutableListOf(5, 5, 3, 0)
        repeat(16) { rolls.add(0) }
        assertEquals(16, subject.bowlingScore(rolls))
    }

    @Test
    fun `strike gives bonus of next two rolls`() {
        // Frame 1: strike, Frame 2: 3+4, rest gutter
        val rolls = mutableListOf(10, 3, 4)
        repeat(16) { rolls.add(0) }
        assertEquals(24, subject.bowlingScore(rolls))
    }

    @Test
    fun `fizzbuzz returns FizzBuzz for multiples of 15`() {
        assertEquals("FizzBuzz", subject.fizzBuzz(15))
    }

    @Test
    fun `fizzbuzz returns Fizz for multiples of 3`() {
        assertEquals("Fizz", subject.fizzBuzz(9))
    }

    @Test
    fun `fizzbuzz returns Buzz for multiples of 5`() {
        assertEquals("Buzz", subject.fizzBuzz(10))
    }

    @Test
    fun `fizzbuzz returns number as string for non-divisible`() {
        assertEquals("7", subject.fizzBuzz(7))
    }

    @Test
    fun `10 repetitions is practiced`() {
        assertTrue(subject.isPracticed(10))
    }

    @Test
    fun `9 repetitions is not enough`() {
        assertFalse(subject.isPracticed(9))
    }

    @Test
    fun `20 repetitions is also practiced`() {
        assertTrue(subject.isPracticed(20))
    }
}
