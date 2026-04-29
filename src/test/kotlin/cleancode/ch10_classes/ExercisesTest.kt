package cleancode.ch10_classes

import kotlin.test.Test
import kotlin.test.assertEquals

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class ClassesTest {

    @Test
    fun `countResponsibilities groups version methods as one and widget methods as one`() {
        val methods = listOf("getVersion", "getMajor", "getMinor", "addWidget")
        assertEquals(2, subject.countResponsibilities(methods))
    }

    @Test
    fun `cohesionScore returns ratio of methods using all variables`() {
        assertEquals(0.7, subject.cohesionScore(totalMethods = 10, methodsUsingAllVars = 7))
    }

    @Test
    fun `DashboardVersion getVersion returns major dot minor string`() {
        val version = subject.DashboardVersion(major = 1, minor = 3)
        assertEquals("1.3", version.getVersion())
    }

    @Test
    fun `DashboardFocus setLastFocused then getLastFocused returns same value`() {
        val focus = subject.DashboardFocus()
        focus.setLastFocused("button1")
        assertEquals("button1", focus.getLastFocused())
    }
}
