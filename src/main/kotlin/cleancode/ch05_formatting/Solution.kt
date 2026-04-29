package cleancode.ch05_formatting

object Solution {
    // Principle: Newspaper Metaphor — high-level concepts first, implementation details below.
    fun correctDeclarationOrder(): List<String> =
        listOf("publicApi", "helperCalledByApi", "privateDetail")

    // Principle: Horizontal Formatting — lines should be short enough to read without scrolling.
    // The team-agreed limit (120 chars here) enforces this consistently.
    fun lineCompliance(lines: List<String>, maxLength: Int = 120): Double {
        if (lines.isEmpty()) return 1.0
        val compliant = lines.count { it.length <= maxLength }
        return compliant.toDouble() / lines.size
    }

    // Principle: Stepdown Rule — callers appear before the functions they call,
    // so the code reads top-to-bottom like a well-written narrative.
    fun followsStepDownRule(callGraph: Map<String, List<String>>): Boolean {
        val order = callGraph.keys.toList() // declaration order is key insertion order
        val indexMap = order.withIndex().associate { (i, name) -> name to i }
        return callGraph.entries.all { (caller, callees) ->
            val callerIndex = indexMap[caller] ?: return@all true
            callees.all { callee ->
                val calleeIndex = indexMap[callee] ?: return@all true
                calleeIndex > callerIndex // callee must be declared AFTER caller
            }
        }
    }
}
