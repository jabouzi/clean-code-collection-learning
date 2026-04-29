package cleancode.ch15_junit_internals

object Solution {
    // Principle: Expressive Names — cryptic abbreviations mapped to full descriptive names
    fun betterNames(original: List<String>): List<String> {
        val nameMap = mapOf(
            "fE" to "fExpected",
            "fA" to "fActual",
            "fCtx" to "fContextLength",
            "fPfxLen" to "fPrefixLength",
            "fSfxLen" to "fSuffixLength"
        )
        return original.map { nameMap[it] ?: it }
    }

    // Principle: Extract Well-Named Boolean — replaces inline !(expected == actual) noise
    fun shouldBeCompacted(expected: String, actual: String): Boolean = expected != actual
}

// Principle: Expressive Names + Extract Method — the ComparisonCompactor refactored
class StringCompactorSolution(
    private val contextLength: Int,
    private val expected: String,
    private val actual: String
) {
    fun compact(): String {
        // Principle: Extract well-named boolean — the intent is immediately clear
        if (!shouldBeCompacted()) return ""

        val prefixLength = findCommonPrefixLength()
        val suffixLength = findCommonSuffixLength(prefixLength)

        val compactExpected = compactString(expected, prefixLength, suffixLength)
        val compactActual = compactString(actual, prefixLength, suffixLength)

        val prefix = if (prefixLength > contextLength) "..." else ""
        val suffix = if (suffixLength > contextLength) "..." else ""
        return "$prefix$compactExpected|$compactActual$suffix"
    }

    // Principle: Intent-Revealing Name — extracted from an inline boolean
    private fun shouldBeCompacted(): Boolean = expected != actual

    private fun findCommonPrefixLength(): Int {
        var prefix = 0
        val end = minOf(expected.length, actual.length)
        while (prefix < end && expected[prefix] == actual[prefix]) prefix++
        return prefix
    }

    private fun findCommonSuffixLength(prefixLength: Int): Int {
        var suffix = 0
        val expectedEnd = expected.length - 1
        val actualEnd = actual.length - 1
        while (suffix <= expectedEnd - prefixLength &&
            suffix <= actualEnd - prefixLength &&
            expected[expectedEnd - suffix] == actual[actualEnd - suffix]
        ) suffix++
        return suffix
    }

    private fun compactString(s: String, prefixLength: Int, suffixLength: Int): String {
        val start = maxOf(0, prefixLength - contextLength)
        val end = minOf(s.length - suffixLength + contextLength, s.length)
        return s.substring(start, end)
    }
}
