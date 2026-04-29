package cleancoder.ch14_mentoring_apprenticeship_craftsmanship

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class MentoringApprenticeshipCraftsmanshipTest {

    @Test
    fun `assessLevel returns MASTER for experienced mentors who contribute to OSS`() {
        assertEquals(CraftsmanshipLevel.MASTER, subject.assessLevel(yearsExperience = 12, hasMentored = true, contributesToOss = true))
    }

    @Test
    fun `assessLevel returns JOURNEYMAN for experienced developer who contributes to OSS but has not mentored`() {
        assertEquals(CraftsmanshipLevel.JOURNEYMAN, subject.assessLevel(yearsExperience = 6, hasMentored = false, contributesToOss = true))
    }

    @Test
    fun `assessLevel returns APPRENTICE for junior without mentoring or OSS contributions`() {
        assertEquals(CraftsmanshipLevel.APPRENTICE, subject.assessLevel(yearsExperience = 2, hasMentored = false, contributesToOss = false))
    }

    @Test
    fun `assessLevel returns APPRENTICE when years are sufficient but neither condition is met`() {
        assertEquals(CraftsmanshipLevel.APPRENTICE, subject.assessLevel(yearsExperience = 7, hasMentored = false, contributesToOss = false))
    }

    @Test
    fun `mentoringReturn multiplies hours by productivity gain`() {
        assertEquals(15.0, subject.mentoringReturn(hoursMentored = 10.0, menteeProductivityGain = 1.5), absoluteTolerance = 0.001)
    }

    @Test
    fun `demonstratesCraftsmanship returns true when all three disciplines are present`() {
        assertTrue(subject.demonstratesCraftsmanship(refactorsOpportunistically = true, writesTestsFirst = true, sharesKnowledge = true))
    }

    @Test
    fun `demonstratesCraftsmanship returns false when any discipline is missing`() {
        assertFalse(subject.demonstratesCraftsmanship(refactorsOpportunistically = true, writesTestsFirst = false, sharesKnowledge = true))
    }
}
