package cleancoder.ch02_saying_no

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class SayingNoTest {

    @Test
    fun `firm deadline statement is a real commitment`() {
        assertTrue(subject.isRealCommitment("I will have it done by Friday"))
    }

    @Test
    fun `try is a weasel word and not a real commitment`() {
        assertFalse(subject.isRealCommitment("I'll try to get it done"))
    }

    @Test
    fun `maybe is a weasel word`() {
        assertFalse(subject.isRealCommitment("Maybe I can finish it"))
    }

    @Test
    fun `should is a weasel word`() {
        assertFalse(subject.isRealCommitment("I should be able to deliver"))
    }

    @Test
    fun `negotiation returns midpoint of developer and manager estimates`() {
        assertEquals(7, subject.negotiate(10, 4))
    }

    @Test
    fun `negotiation with equal estimates returns the same value`() {
        assertEquals(5, subject.negotiate(5, 5))
    }

    @Test
    fun `exceeding capacity causes disaster`() {
        assertEquals("disaster", subject.costOfYes(15, 10))
    }

    @Test
    fun `within capacity is ok`() {
        assertEquals("ok", subject.costOfYes(8, 10))
    }

    @Test
    fun `exact capacity is ok`() {
        assertEquals("ok", subject.costOfYes(10, 10))
    }
}
