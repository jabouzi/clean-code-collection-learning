package cleancoder.ch08_testing_strategies

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class TestingStrategiesTest {

    @Test
    fun `classifyTest returns UNIT when dependencies isolated and no process boundary`() {
        assertEquals(TestType.UNIT, subject.classifyTest(isolatesDependencies = true, crossesProcessBoundary = false, coversFullSystem = false))
    }

    @Test
    fun `classifyTest returns INTEGRATION when crosses process boundary`() {
        assertEquals(TestType.INTEGRATION, subject.classifyTest(isolatesDependencies = true, crossesProcessBoundary = true, coversFullSystem = false))
    }

    @Test
    fun `classifyTest returns COMPONENT when dependencies not isolated`() {
        assertEquals(TestType.COMPONENT, subject.classifyTest(isolatesDependencies = false, crossesProcessBoundary = false, coversFullSystem = false))
    }

    @Test
    fun `classifyTest returns SYSTEM when covers full system`() {
        assertEquals(TestType.SYSTEM, subject.classifyTest(isolatesDependencies = true, crossesProcessBoundary = false, coversFullSystem = true))
    }

    @Test
    fun `isPyramidHealthy returns true when counts form a proper pyramid`() {
        assertTrue(subject.isPyramidHealthy(unit = 1000, component = 100, integration = 10, system = 1))
    }

    @Test
    fun `isPyramidHealthy returns false when unit tests are fewer than component tests`() {
        assertFalse(subject.isPyramidHealthy(unit = 10, component = 100, integration = 10, system = 1))
    }

    @Test
    fun `qaEscapeRate calculates ratio of user-found bugs to total bugs`() {
        assertEquals(0.1, subject.qaEscapeRate(bugsFoundByQa = 9, bugsFoundByUsers = 1), absoluteTolerance = 0.001)
    }
}
