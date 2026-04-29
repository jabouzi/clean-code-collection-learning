package cleancoder.ch07_acceptance_testing

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class AcceptanceTestingTest {

    @Test
    fun `parseScenario extracts given part`() {
        val scenario = subject.parseScenario(
            "Given: user logged in When: clicks logout Then: redirected to login"
        )
        assertEquals("user logged in", scenario.given)
    }

    @Test
    fun `parseScenario extracts when part`() {
        val scenario = subject.parseScenario(
            "Given: user logged in When: clicks logout Then: redirected to login"
        )
        assertEquals("clicks logout", scenario.`when`)
    }

    @Test
    fun `parseScenario extracts then part`() {
        val scenario = subject.parseScenario(
            "Given: user logged in When: clicks logout Then: redirected to login"
        )
        assertEquals("redirected to login", scenario.then)
    }

    @Test
    fun `complete criterion with all three parts is valid`() {
        assertTrue(subject.isCompleteAcceptanceCriterion("user", "clicks", "redirected"))
    }

    @Test
    fun `criterion with blank given is incomplete`() {
        assertFalse(subject.isCompleteAcceptanceCriterion("", "clicks", "redirected"))
    }

    @Test
    fun `criterion with blank when is incomplete`() {
        assertFalse(subject.isCompleteAcceptanceCriterion("user", "", "redirected"))
    }

    @Test
    fun `criterion with blank then is incomplete`() {
        assertFalse(subject.isCompleteAcceptanceCriterion("user", "clicks", ""))
    }

    @Test
    fun `acceptance test passes when behavior contains feature`() {
        assertTrue(subject.runAcceptanceTest("login", "user is shown the Login Page"))
    }

    @Test
    fun `acceptance test is case insensitive`() {
        assertTrue(subject.runAcceptanceTest("LOGIN", "user is shown the login page"))
    }

    @Test
    fun `acceptance test fails when behavior does not contain feature`() {
        assertFalse(subject.runAcceptanceTest("logout", "user is shown the login page"))
    }
}
