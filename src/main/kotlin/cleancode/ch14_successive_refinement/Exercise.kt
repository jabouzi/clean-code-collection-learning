package cleancode.ch14_successive_refinement

object Exercise {
    // Exercise 1: Naive args parser (first draft) — just split on spaces
    fun parseNaive(args: String): Map<String, String> {
        TODO("Split 'key=value' pairs on space, return map. Handles only simple key=value.")
    }

    // Exercise 2: Refined parser — supports -flag style args
    fun parseRefined(args: List<String>): Map<String, Boolean> {
        TODO("Return map of flag->true for each '-flag' in args, false if absent")
    }

    // Exercise 3: Detect the refactoring smell — does this function need extraction?
    fun needsExtraction(linesOfCode: Int, cyclomaticComplexity: Int): Boolean {
        TODO("Return true if loc > 20 OR complexity > 5")
    }
}
