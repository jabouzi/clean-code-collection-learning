package cleancode.ch05_formatting

object Exercise {
    // Exercise 1: Reorder these declarations so high-level comes first (return correct order).
    // Newspaper metaphor: lead with the headline (public API), follow with supporting detail.
    fun correctDeclarationOrder(): List<String> {
        TODO("Return [\"publicApi\", \"helperCalledByApi\", \"privateDetail\"] — newspaper metaphor")
    }

    // Exercise 2: Calculate max line length compliance (what % of lines are <= maxLength chars).
    fun lineCompliance(lines: List<String>, maxLength: Int = 120): Double {
        TODO("Return ratio of compliant lines to total")
    }

    // Exercise 3: Does this class follow the stepdown rule?
    // Each function should only call functions defined after it in declaration order.
    fun followsStepDownRule(callGraph: Map<String, List<String>>): Boolean {
        TODO("Return true if no function calls a function defined before it in declaration order")
    }
}
