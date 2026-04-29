package cleancoder.ch03_saying_yes

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class SayingYesTest {

    @Test
    fun `I will is commitment language`() {
        assertTrue(subject.usesCommitmentLanguage("I will finish the login page by Friday"))
    }

    @Test
    fun `I am going to is commitment language`() {
        assertTrue(subject.usesCommitmentLanguage("I am going to complete the feature today"))
    }

    @Test
    fun `we should is not commitment language`() {
        assertFalse(subject.usesCommitmentLanguage("We should probably get this done"))
    }

    @Test
    fun `I will try is not commitment language`() {
        assertFalse(subject.usesCommitmentLanguage("I'll try to finish it"))
    }

    @Test
    fun `dependency blocker resolves to stakeholder communication`() {
        assertEquals(
            "communicate dependency to stakeholder",
            subject.resolveBlocker("dependency")
        )
    }

    @Test
    fun `unclear blocker resolves to clarifying requirements`() {
        assertEquals(
            "clarify requirement before committing",
            subject.resolveBlocker("unclear")
        )
    }

    @Test
    fun `unknown blocker resolves to raising concern`() {
        assertEquals("raise concern immediately", subject.resolveBlocker("other"))
    }

    @Test
    fun `partial commitment returns intersection of deliverable and requested`() {
        assertEquals(
            listOf("A"),
            subject.partialCommitment(listOf("A", "B"), listOf("A", "C"))
        )
    }

    @Test
    fun `partial commitment with no overlap returns empty list`() {
        assertEquals(
            emptyList<String>(),
            subject.partialCommitment(listOf("A"), listOf("B"))
        )
    }
}
