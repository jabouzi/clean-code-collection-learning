package cleancode.ch17_smells_and_heuristics

object Solution {
    // Principle: G1 — Multiple Languages in One Source File is a smell
    fun hasMultipleLanguages(sourceFile: String): Boolean =
        sourceFile.contains("<?php") && sourceFile.contains("fun ")

    // Principle: G5 — Duplication is the root of all evil in software design
    fun countDuplicateBlocks(lines: List<String>): Int =
        lines.groupingBy { it }.eachCount().count { (_, count) -> count > 1 }

    // Principle: N1 — Choose Descriptive Names; single letters and ALL_CAPS abbreviations are not descriptive
    fun isDescriptiveName(name: String): Boolean =
        name.length > 3 && name != name.uppercase()

    // Principle: T1 — Insufficient Tests; any line not covered is an unknown risk
    fun hasSufficientTests(coveredLines: Int, totalLines: Int, threshold: Double = 0.8): Boolean =
        totalLines > 0 && coveredLines.toDouble() / totalLines >= threshold
}
