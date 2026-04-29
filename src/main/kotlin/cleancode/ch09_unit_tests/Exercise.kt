package cleancode.ch09_unit_tests

object Exercise {
    // Exercise 1: Build-Operate-Check — return state string like "HBchL" (heater/blower/cooler/hiAlarm/loAlarm)
    fun getSystemState(hw: ControlHardware): String {
        TODO("Return 5-char string: uppercase=ON, lowercase=OFF, order: H B C H L")
    }

    // Exercise 2: F.I.R.S.T. compliance check
    fun isFastTest(durationMs: Long): Boolean = TODO("Return true if test runs in under 100ms")
    fun isIndependentTest(usesSharedState: Boolean): Boolean = TODO("Return true if no shared state")

    // Exercise 3: Single concept — does this test name suggest single concept?
    fun hasSingleConcept(testName: String): Boolean {
        TODO("Return false if testName contains 'And' — multiple concepts in one test")
    }
}

data class ControlHardware(
    val heater: Boolean,
    val blower: Boolean,
    val cooler: Boolean,
    val hiTempAlarm: Boolean,
    val loTempAlarm: Boolean
)
