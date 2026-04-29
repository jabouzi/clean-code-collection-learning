package cleancode.ch14_successive_refinement

object Solution {
    // Principle: Make It Work First — naive parser is honest about its limitations
    fun parseNaive(args: String): Map<String, String> =
        args.split(" ")
            .filter { it.contains("=") }
            .associate { pair ->
                val (key, value) = pair.split("=", limit = 2)
                key to value
            }

    // Principle: Successive Refinement — refined parser handles -flag style cleanly
    fun parseRefined(args: List<String>): Map<String, Boolean> =
        args
            .filter { it.startsWith("-") }
            .associate { it.removePrefix("-") to true }

    // Principle: Extract Method — functions that are too long or complex need to be broken down
    fun needsExtraction(linesOfCode: Int, cyclomaticComplexity: Int): Boolean =
        linesOfCode > 20 || cyclomaticComplexity > 5
}
