package cleancode.ch09_unit_tests

object Solution {
    // Principle: Build-Operate-Check (Given-When-Then) — the test builds the hardware state,
    // operates on it, and checks the resulting state string in a single readable assertion.
    fun getSystemState(hw: ControlHardware): String {
        // Principle: Readability — encode ON as uppercase, OFF as lowercase for a compact summary
        fun encode(on: Boolean, onChar: Char, offChar: Char) = if (on) onChar else offChar
        return buildString {
            append(encode(hw.heater, 'H', 'h'))
            append(encode(hw.blower, 'B', 'b'))
            append(encode(hw.cooler, 'C', 'c'))
            append(encode(hw.hiTempAlarm, 'H', 'h'))
            append(encode(hw.loTempAlarm, 'L', 'l'))
        }
    }

    // Principle: F.I.R.S.T. — Fast: tests should complete in milliseconds, not seconds.
    fun isFastTest(durationMs: Long): Boolean = durationMs < 100L

    // Principle: F.I.R.S.T. — Independent: tests must not depend on shared mutable state.
    fun isIndependentTest(usesSharedState: Boolean): Boolean = !usesSharedState

    // Principle: Single Concept Per Test — one assert per concept, no 'And' in test names.
    fun hasSingleConcept(testName: String): Boolean = !testName.contains("And")
}
