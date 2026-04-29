package cleancode.ch12_emergence

// ── File-scope types shared between Exercise and Solution ──────────────────────

// Exercise 1: Remove duplication using Template Method
abstract class BaseRenderer {
    fun render(data: String): String = TODO("Call header() + body(data) + footer()")
    protected abstract fun header(): String
    protected abstract fun body(data: String): String
    protected abstract fun footer(): String
}

class HtmlRenderer : BaseRenderer() {
    override fun header() = TODO("Return '<html>'")
    override fun body(data: String) = TODO("Return '<body>\$data</body>'")
    override fun footer() = TODO("Return '</html>'")
}

// Exercise 3: Minimize classes — merge two trivial single-method classes into one
class StringUtils {
    fun reverse(s: String): String = TODO("Return s.reversed()")
    fun isPalindrome(s: String): Boolean = TODO("Return s == s.reversed()")
}

// ──────────────────────────────────────────────────────────────────────────────

object Exercise {
    // Exercise 2: Express intent — rename cryptic to expressive
    fun primaryTermination(s: String): Boolean = TODO("Return true if s ends with '.' — rename from isPT")
}
