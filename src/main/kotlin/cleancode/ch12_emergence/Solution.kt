package cleancode.ch12_emergence

// NOTE: BaseRenderer, HtmlRenderer, and StringUtils are defined at file scope in Exercise.kt.
// Solution provides renamed solution versions (SolBaseRenderer, SolHtmlRenderer, SolStringUtils)
// to avoid redefinition conflicts in the same package.

object Solution {
    // Principle: Expressive Names — 'primaryTermination' reveals intent; 'isPT' does not
    fun primaryTermination(s: String): Boolean = s.endsWith(".")
}

// Principle: No Duplication — Template Method eliminates duplicated render skeleton
abstract class SolBaseRenderer {
    fun render(data: String): String = header() + body(data) + footer()
    protected abstract fun header(): String
    protected abstract fun body(data: String): String
    protected abstract fun footer(): String
}

// Principle: Expressive — each override has a clear, purposeful name
class SolHtmlRenderer : SolBaseRenderer() {
    override fun header() = "<html>"
    override fun body(data: String) = "<body>$data</body>"
    override fun footer() = "</html>"
}

// Principle: Minimal Classes and Methods — one class handles both related string utilities
class SolStringUtils {
    fun reverse(s: String): String = s.reversed()
    fun isPalindrome(s: String): Boolean = s == s.reversed()
}
