package cleancode.ch15_junit_internals

object Exercise {
    // Exercise 2: Rename these confusing fields (return better names as list)
    fun betterNames(original: List<String>): List<String> {
        TODO("Map: fE->fExpected, fA->fActual, fCtx->fContextLength, fPfxLen->fPrefixLength, fSfxLen->fSuffixLength")
    }

    // Exercise 3: Extract a well-named boolean
    fun shouldBeCompacted(expected: String, actual: String): Boolean {
        TODO("Return true if expected != actual (i.e. compaction is needed)")
    }
}

// Exercise 1: Messy compactor — clean it up (rename, extract, simplify)
class StringCompactor(private val contextLength: Int, private val expected: String, private val actual: String) {
    fun compact(): String {
        TODO("""
            Return compact diff string. If strings are equal return ''.
            Otherwise show: '[prefix]<expected|actual>[suffix]'
            Use contextLength chars of context around the difference.
        """)
    }
}
