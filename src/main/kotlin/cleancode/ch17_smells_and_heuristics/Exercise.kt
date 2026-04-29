package cleancode.ch17_smells_and_heuristics

object Exercise {
    // Exercise 1: G1 — Multiple languages in one source file. Detect it.
    fun hasMultipleLanguages(sourceFile: String): Boolean {
        TODO("Return true if file contains both '<?php' and Kotlin keywords like 'fun '")
    }

    // Exercise 2: G5 — Duplication. Find duplicated blocks (returns count of duplicated line groups)
    fun countDuplicateBlocks(lines: List<String>): Int {
        TODO("Return number of lines that appear more than once in the list")
    }

    // Exercise 3: N1 — Choose descriptive names. Score name quality (length > 3 AND not all-caps abbreviation)
    fun isDescriptiveName(name: String): Boolean {
        TODO("Return true if name.length > 3 and name is not all uppercase")
    }

    // Exercise 4: T1 — Insufficient tests. Flag if coverage is below threshold
    fun hasSufficientTests(coveredLines: Int, totalLines: Int, threshold: Double = 0.8): Boolean {
        TODO("Return true if coveredLines/totalLines >= threshold")
    }
}
