# Clean Code Interactive Tutorial — Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Build a chapter-by-chapter interactive Kotlin tutorial for both Clean Code and The Clean Coder, using TDD-style exercises with pre-written failing tests.

**Architecture:** Gradle + kotlin.test project with two top-level packages (`cleancode/`, `cleancoder/`). Each chapter = one package with `object Exercise` (stubs), `object Solution` (reference), and `ExercisesTest` (pre-written tests against `Exercise` via `val subject`).

**Tech Stack:** Kotlin JVM, Gradle Kotlin DSL, kotlin.test, JUnit 5

---

## Epub paths (for content extraction)

- Clean Code chapters: `/Users/skander.jabouzi/Library/Mobile Documents/iCloud~com~apple~iBooks/Documents/The Robert C Martin Clean Code Collection Collection.epub/OEBPS/html/item2_chapter01.html` … `item2_chapter17.html`
- The Clean Coder chapters: same base path, `item1_ch01.html` … `item1_ch14.html`

---

## File pattern (reference — follow exactly)

Every chapter follows this structure (shown for `cleancode/ch02_meaningful_names`):

### `src/main/kotlin/cleancode/ch02_meaningful_names/Exercise.kt`
```kotlin
package cleancode.ch02_meaningful_names

object Exercise {
    // Exercise 1: Rename this function and variables to reveal intent
    fun getThem(theList: List<IntArray>): List<IntArray> {
        TODO("Apply 'Use Intention-Revealing Names' — what is theList? what does index 0 mean? what is 4?")
    }

    // Exercise 2: Fix the disinformation in parameter names (body is correct)
    fun copyChars(a1: CharArray, a2: CharArray) {
        for (i in a1.indices) a2[i] = a1[i]
    }

    // Exercise 3: Replace this comment with a well-named function
    fun checkEmployee(employee: Employee): Boolean {
        // Check to see if the employee is eligible for full benefits
        return (employee.flags and HOURLY_FLAG) != 0 && employee.age > 65
    }
}

data class Employee(val flags: Int, val age: Int)
const val HOURLY_FLAG = 1
```

### `src/main/kotlin/cleancode/ch02_meaningful_names/Solution.kt`
```kotlin
package cleancode.ch02_meaningful_names

object Solution {
    // Principle: Intention-Revealing Names
    fun getFlaggedCells(gameBoard: List<IntArray>): List<IntArray> {
        val STATUS_VALUE = 0
        val FLAGGED = 4
        return gameBoard.filter { cell -> cell[STATUS_VALUE] == FLAGGED }
    }

    // Principle: Avoid Disinformation
    fun copyChars(source: CharArray, destination: CharArray) {
        for (i in source.indices) destination[i] = source[i]
    }

    // Principle: Explain Yourself in Code — no comment needed
    fun isEligibleForFullBenefits(employee: Employee): Boolean =
        (employee.flags and HOURLY_FLAG) != 0 && employee.age > 65
}
```

### `src/test/kotlin/cleancode/ch02_meaningful_names/ExercisesTest.kt`
```kotlin
package cleancode.ch02_meaningful_names

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class MeaningfulNamesTest {

    @Test
    fun `getFlaggedCells returns only flagged cells from game board`() {
        val FLAGGED = 4
        val board = listOf(intArrayOf(0), intArrayOf(FLAGGED), intArrayOf(2))
        // Hint: your function should be named getFlaggedCells, not getThem
        assertEquals(1, subject.getFlaggedCells(board).size)
    }

    @Test
    fun `copyChars copies from source to destination`() {
        val src = charArrayOf('h', 'i')
        val dst = CharArray(2)
        subject.copyChars(src, dst)
        assertEquals(src.toList(), dst.toList())
    }

    @Test
    fun `eligibility check expressed as intent-revealing function name`() {
        val eligible = Employee(flags = HOURLY_FLAG, age = 66)
        val notEligible = Employee(flags = HOURLY_FLAG, age = 64)
        // Hint: rename checkEmployee to isEligibleForFullBenefits
        assertTrue(subject.isEligibleForFullBenefits(eligible))
        assertTrue(!subject.isEligibleForFullBenefits(notEligible))
    }
}
```

### `docs/cleancode/ch02_meaningful_names.md`
```markdown
# Chapter 2: Meaningful Names

## Key Principles
- **Use Intention-Revealing Names** — every name answers why it exists, what it does, how it is used
- **Avoid Disinformation** — don't use names that mislead (e.g. `accountList` when it's not a List)
- **Make Meaningful Distinctions** — `a1`/`a2` is noise; `source`/`destination` communicates
- **Use Pronounceable Names** — if you can't say it, you can't discuss it
- **Use Searchable Names** — single-letter names and magic numbers can't be found with grep
- **Explain Yourself in Code** — prefer `isEligibleForFullBenefits()` over a comment

## Kotlin Notes
- Kotlin's named parameters make intention even clearer than Java: `copyChars(source = src, destination = dst)`
- Use `const val` for searchable named constants instead of magic numbers

## Exercises
1. **getThem → getFlaggedCells**: Rename function and variables to reveal the minesweeper context
2. **copyChars parameters**: Rename `a1`/`a2` to `source`/`destination`
3. **checkEmployee**: Replace the comment with an intention-revealing function name
```

---

## Task 1: Gradle Migration

**Files:**
- Create: `build.gradle.kts`
- Create: `settings.gradle.kts`
- Delete (via git rm): `Learning.iml`

- [ ] Create `settings.gradle.kts`:
```kotlin
rootProject.name = "Learning"
```

- [ ] Create `build.gradle.kts`:
```kotlin
plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.learning"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
```

- [ ] Run: `cd /Users/skander.jabouzi/Development/Learning/Learning && ./gradlew test`
  Expected: BUILD SUCCESSFUL (no test sources yet, that's fine)

- [ ] Commit:
```bash
git add build.gradle.kts settings.gradle.kts
git rm Learning.iml
git commit -m "feat: migrate to Gradle with kotlin.test + JUnit 5"
```

---

## Task 2: Clean Code Ch01 — Clean Code

**Package:** `cleancode.ch01_clean_code`
**Epub:** `item2_chapter01.html`
**Key principles:** LeBlanc's Law (later = never), cost of mess, what makes code clean (readable, single responsibility, minimal dependencies, tests)

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: This function does too much — identify by returning a list of responsibility names
    fun responsibilities(fn: String): List<String> { TODO() }

    // Exercise 2: True/False — does this satisfy the Boy Scout Rule?
    fun isBoyScoutCompliant(before: String, after: String): Boolean { TODO() }

    // Exercise 3: Calculate the "WTF/minute" rate (ratio of bad lines to total)
    fun wtfRate(totalLines: Int, badLines: Int): Double { TODO() }
}
```

**Tests assert:**
- `responsibilities("processUserAndSendEmailAndUpdateDB")` returns list with 3 items
- `isBoyScoutCompliant("messy code", "cleaner code")` = true, reverse = false (compare length as proxy)
- `wtfRate(100, 20)` = 0.2

---

## Task 3: Clean Code Ch02 — Meaningful Names

**Package:** `cleancode.ch02_meaningful_names`
→ **Full content shown in "File pattern" section above. Use that exactly.**

---

## Task 4: Clean Code Ch03 — Functions

**Package:** `cleancode.ch03_functions`
**Epub:** `item2_chapter03.html`
**Key principles:** Small, do one thing, one level of abstraction, step-down rule, few arguments, no side effects, command-query separation

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: This function does 3 things — split into isTestPage(), includeSetupPages(), includeContent()
    fun renderPageWithSetupsAndTeardowns(pageData: PageData, isSuite: Boolean): String {
        TODO("Split into small functions each doing ONE thing")
    }

    // Exercise 2: Fix this switch — use sealed class dispatch instead
    fun calculatePay(employeeType: String, hours: Double, rate: Double): Double {
        TODO("Replace string-based switch with sealed class polymorphism")
    }

    // Exercise 3: Command-query separation — this does both, split it
    fun setAndReturnAttribute(obj: MutableMap<String, String>, key: String, value: String): Boolean {
        TODO("Split into setAttribute() and hasAttribute() — no side effects on queries")
    }
}

data class PageData(val content: String, val isTestPage: Boolean)
```

**Tests assert:**
- `renderPageWithSetupsAndTeardowns(PageData("content", true), false)` contains "content"
- Pay for `Hourly` type = hours * rate; `Salaried` = fixed rate
- `setAndReturnAttribute` sets value AND returns whether key existed before

---

## Task 5: Clean Code Ch04 — Comments

**Package:** `cleancode.ch04_comments`
**Epub:** `item2_chapter04.html`
**Key principles:** Comments are failures, explain yourself in code, good comments (legal/warning/TODO/amplification), bad comments (redundant/misleading/noise/commented-out code)

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Replace this comment with a well-named function
    // Returns true if employee qualifies (hourly worker over 65)
    fun check(flags: Int, age: Int): Boolean {
        TODO("Rename to isEligibleForFullBenefits and remove the comment")
    }

    // Exercise 2: This regex needs a comment — or does it? Extract to a named constant/function
    fun isValidTimestamp(input: String): Boolean {
        TODO("Use a named val TIMESTAMP_PATTERN = Regex(...) so the comment is unnecessary")
    }

    // Exercise 3: Remove the noise — rewrite without redundant comments
    fun getCustomerName(id: Int): String {
        // Gets the customer name
        // Returns the name of the customer
        TODO("Same function, zero comments — code speaks for itself")
    }
}
```

**Tests assert:**
- `check(1, 66)` = true, `check(1, 64)` = false (hourly flag = 1)
- `isValidTimestamp("14:30:00 Mon, Apr 29 2026")` = true, `isValidTimestamp("not-a-date")` = false
- `getCustomerName(1)` returns a non-empty string (any deterministic value)

---

## Task 6: Clean Code Ch05 — Formatting

**Package:** `cleancode.ch05_formatting`
**Epub:** `item2_chapter05.html`
**Key principles:** Newspaper metaphor (high-level first, details below), vertical openness between concepts, dependent functions close together, team rules

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Reorder these declarations so high-level comes first (return correct order)
    fun correctDeclarationOrder(): List<String> {
        TODO("Return [publicApi, helperCalledByApi, privateDetail] — newspaper metaphor")
    }

    // Exercise 2: Calculate max line length compliance (what % of lines are <= 120 chars)
    fun lineCompliance(lines: List<String>, maxLength: Int = 120): Double {
        TODO("Return ratio of compliant lines to total")
    }

    // Exercise 3: Does this class follow the stepdown rule? (each fn calls only fns defined after it)
    fun followsStepDownRule(callGraph: Map<String, List<String>>): Boolean {
        TODO("Return true if no function calls a function defined before it in declaration order")
    }
}
```

**Tests assert:**
- `correctDeclarationOrder()` == listOf("publicApi", "helperCalledByApi", "privateDetail")
- `lineCompliance(listOf("short", "a".repeat(130)))` = 0.5
- `followsStepDownRule(mapOf("a" to listOf("b"), "b" to listOf("c"), "c" to emptyList()))` = true

---

## Task 7: Clean Code Ch06 — Objects and Data Structures

**Package:** `cleancode.ch06_objects_and_data_structures`
**Epub:** `item2_chapter06.html`
**Key principles:** Data abstraction, data/object anti-symmetry, Law of Demeter (train wrecks), DTOs vs Active Records

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Fix the train wreck — tell the object what to do, don't ask about its internals
    fun getScratchFilePath(ctxt: AppContext, className: String): String {
        TODO("Call ctxt.createScratchFileStream(className) — don't navigate ctxt.options.scratchDir.path")
    }

    // Exercise 2: Abstract the fuel — expose percentage not raw gallons
    interface Vehicle {
        fun getPercentFuelRemaining(): Double  // implement this
    }
    class Car(val gallons: Double, val capacity: Double) : Vehicle {
        override fun getPercentFuelRemaining(): Double = TODO("Return gallons/capacity as a percentage 0.0–1.0")
    }

    // Exercise 3: Procedural → OO. Add area() to each shape instead of using instanceof
    interface Shape { fun area(): Double }
    class Square(val side: Double) : Shape { override fun area(): Double = TODO() }
    class Circle(val radius: Double) : Shape { override fun area(): Double = TODO() }
}

class AppContext(val scratchDir: String)
fun AppContext.createScratchFileStream(className: String) = "$scratchDir/$className.tmp"
```

**Tests assert:**
- `getScratchFilePath(AppContext("/tmp"), "Foo")` = "/tmp/Foo.tmp"
- `Car(5.0, 10.0).getPercentFuelRemaining()` = 0.5
- `Square(4.0).area()` = 16.0, `Circle(1.0).area()` ≈ 3.14159

---

## Task 8: Clean Code Ch07 — Error Handling

**Package:** `cleancode.ch07_error_handling`
**Epub:** `item2_chapter07.html`
**Key principles:** Exceptions over return codes, write try-catch-finally first, unchecked exceptions, provide context, Special Case pattern, don't return null, don't pass null

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Replace return-code style with exceptions
    fun sendShutDown(device: Device) {
        TODO("Throw DeviceException instead of checking status codes")
    }

    // Exercise 2: Special Case pattern — never return null
    fun getEmployees(): List<Employee> {
        TODO("Return emptyList() instead of null when no employees")
    }

    // Exercise 3: Wrap multiple exceptions into one
    fun openPort(portNumber: Int): Port {
        TODO("Wrap DeviceResponseException, ATM1212UnlockedException, GMXError into PortDeviceFailure")
    }
}

data class Device(val isValid: Boolean, val isSuspended: Boolean)
data class Employee(val name: String)
data class Port(val number: Int)
class DeviceException(msg: String) : Exception(msg)
class PortDeviceFailure(cause: Throwable) : Exception(cause)
class DeviceResponseException : Exception()
class ATM1212UnlockedException : Exception()
class GMXError : Exception()
```

**Tests assert:**
- `sendShutDown(Device(false, false))` throws `DeviceException`
- `getEmployees()` returns empty list (not null) when no data
- `openPort(-1)` throws `PortDeviceFailure` (wrapping any of the three low-level exceptions)

---

## Task 9: Clean Code Ch08 — Boundaries

**Package:** `cleancode.ch08_boundaries`
**Epub:** `item2_chapter08.html`
**Key principles:** Wrap third-party APIs, learning tests, using code that doesn't exist yet, clean boundaries

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Wrap a raw Map to provide a safe, typed boundary
    class SensorMap {
        private val sensors = mutableMapOf<String, Sensor>()
        fun getById(id: String): Sensor? = TODO("Return sensor or null — don't expose raw map")
        fun add(id: String, sensor: Sensor) = TODO("Delegate to internal map")
    }

    // Exercise 2: Define an interface for a dependency that doesn't exist yet
    interface Transmitter {
        fun transmit(frequency: Double, stream: String): Boolean
    }

    // Exercise 3: Write a learning test — verify your understanding of the boundary
    fun verifyLoggerBehavior(messages: List<String>): Boolean {
        TODO("Return true if all messages are non-blank (simulates verifying 3rd-party logger contract)")
    }
}

data class Sensor(val id: String, val value: Double)
```

**Tests assert:**
- `SensorMap` add then getById returns correct sensor
- `SensorMap` getById for unknown id returns null
- `verifyLoggerBehavior(listOf("msg1", "msg2"))` = true, `verifyLoggerBehavior(listOf("", "msg"))` = false

---

## Task 10: Clean Code Ch09 — Unit Tests

**Package:** `cleancode.ch09_unit_tests`
**Epub:** `item2_chapter09.html`
**Key principles:** Three Laws of TDD, clean tests (readability), Build-Operate-Check, single concept per test, F.I.R.S.T.

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Build-Operate-Check — return state string like "HBchL" (heater/blower/cooler/hiAlarm/loAlarm)
    fun getSystemState(hw: ControlHardware): String {
        TODO("Return 5-char string: uppercase=ON, lowercase=OFF, order: H B C H L")
    }

    // Exercise 2: F.I.R.S.T. compliance check
    fun isFastTest(durationMs: Long): Boolean = TODO("Return true if test runs in under 100ms")
    fun isIndependentTest(usesSharedState: Boolean): Boolean = TODO("Return true if no shared state")

    // Exercise 3: Single concept — does this test name suggest single concept?
    fun hasSingleConcept(testName: String): Boolean {
        TODO("Return false if testName contains 'And' — multiple concepts in one test")
    }
}

data class ControlHardware(
    val heater: Boolean, val blower: Boolean, val cooler: Boolean,
    val hiTempAlarm: Boolean, val loTempAlarm: Boolean
)
```

**Tests assert:**
- `getSystemState(ControlHardware(true, true, false, false, true))` = "HBchL"
- `isFastTest(50)` = true, `isFastTest(200)` = false
- `hasSingleConcept("testAddAndRemove")` = false, `hasSingleConcept("testAdd")` = true

---

## Task 11: Clean Code Ch10 — Classes

**Package:** `cleancode.ch10_classes`
**Epub:** `item2_chapter10.html`
**Key principles:** Small (measure by responsibilities), SRP, cohesion, OCP, isolating from change

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Count responsibilities (one per public method group serving same purpose)
    fun countResponsibilities(publicMethodNames: List<String>): Int {
        TODO("Group methods by concern: getVersion/getMajor/getMinor = 1, addWidget/render = 1 each")
    }

    // Exercise 2: Cohesion — ratio of methods that use ALL instance variables
    fun cohesionScore(totalMethods: Int, methodsUsingAllVars: Int): Double {
        TODO("Return methodsUsingAllVars.toDouble() / totalMethods")
    }

    // Exercise 3: SRP — split SuperDashboard into focused classes
    class DashboardVersion(val major: Int, val minor: Int) {
        fun getVersion(): String = TODO("Return 'major.minor'")
    }
    class DashboardFocus {
        private var lastFocused: String = ""
        fun setLastFocused(component: String) = TODO("Store the component")
        fun getLastFocused(): String = TODO("Return stored component")
    }
}
```

**Tests assert:**
- `countResponsibilities(listOf("getVersion","getMajor","getMinor","addWidget"))` = 2
- `cohesionScore(10, 7)` = 0.7
- `DashboardVersion(1, 3).getVersion()` = "1.3"
- `DashboardFocus` set then get returns same value

---

## Task 12: Clean Code Ch11 — Systems

**Package:** `cleancode.ch11_systems`
**Epub:** `item2_chapter11.html`
**Key principles:** Separate construction from use, DI, factories, cross-cutting concerns, scaling up

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Separate construction — use a factory instead of new inside logic
    interface ServiceFactory { fun makeService(): MyService }
    class Application(private val factory: ServiceFactory) {
        fun run(): String = TODO("Call factory.makeService().execute() — don't construct directly")
    }

    // Exercise 2: DI — inject the dependency instead of creating it
    class OrderProcessor(private val db: Database) {
        fun process(orderId: Int): Boolean = TODO("Call db.find(orderId) != null")
    }

    // Exercise 3: Naive scaling — show that single-thread concern and concurrency concern are separate
    fun isConcernSeparated(hasDedicatedThreadClass: Boolean, businessLogicHasThreadCode: Boolean): Boolean {
        TODO("Return true only if dedicated thread class exists AND business logic has no thread code")
    }
}

interface MyService { fun execute(): String }
interface Database { fun find(id: Int): Any? }
```

**Tests assert:**
- `Application(factory = { MyServiceImpl() }).run()` = "ok" (with stub factory)
- `OrderProcessor(db = { id -> if (id == 1) "order" else null }).process(1)` = true
- `isConcernSeparated(true, false)` = true, `isConcernSeparated(true, true)` = false

---

## Task 13: Clean Code Ch12 — Emergence

**Package:** `cleancode.ch12_emergence`
**Epub:** `item2_chapter12.html`
**Key principles:** 4 Rules of Simple Design (Kent Beck): 1) passes all tests, 2) no duplication, 3) expresses intent, 4) minimizes classes/methods

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Remove duplication using Template Method
    abstract class BaseRenderer {
        fun render(data: String): String = TODO("Call header() + body(data) + footer()")
        protected abstract fun header(): String
        protected abstract fun body(data: String): String
        protected abstract fun footer(): String
    }
    class HtmlRenderer : BaseRenderer() {
        override fun header() = TODO("Return '<html>'")
        override fun body(data: String) = TODO("Return '<body>$data</body>'")
        override fun footer() = TODO("Return '</html>'")
    }

    // Exercise 2: Express intent — rename cryptic to expressive
    fun primaryTermination(s: String): Boolean = TODO("Return true if s ends with '.' — rename from isPT")

    // Exercise 3: Minimize classes — merge two trivial single-method classes into one
    class StringUtils {
        fun reverse(s: String): String = TODO("Return s.reversed()")
        fun isPalindrome(s: String): Boolean = TODO("Return s == s.reversed()")
    }
}
```

**Tests assert:**
- `HtmlRenderer().render("hello")` = "<html><body>hello</body></html>"
- `primaryTermination("end.")` = true, `primaryTermination("no")` = false
- `StringUtils().reverse("abc")` = "cba"
- `StringUtils().isPalindrome("racecar")` = true

---

## Task 14: Clean Code Ch13 — Concurrency

**Package:** `cleancode.ch13_concurrency`
**Epub:** `item2_chapter13.html`
**Key principles:** Decouple what from when, shared data risks, limit scope of shared data, use copies, threads independent, know your library (AtomicInteger, ConcurrentHashMap)

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Thread-safe counter using AtomicInteger
    class ThreadSafeCounter {
        private val count = java.util.concurrent.atomic.AtomicInteger(0)
        fun increment(): Int = TODO("Atomically increment and return new value")
        fun get(): Int = TODO("Return current value")
    }

    // Exercise 2: Limit scope — return immutable copy, not reference to mutable shared state
    class SensorRepository {
        private val sensors = mutableMapOf("a" to 1.0, "b" to 2.0)
        fun getSnapshot(): Map<String, Double> = TODO("Return unmodifiable copy of sensors")
    }

    // Exercise 3: Producer-consumer handoff using a blocking queue
    fun produceAndConsume(items: List<Int>): List<Int> {
        TODO("Put items into LinkedBlockingQueue, drain from another thread, return consumed list")
    }
}
```

**Tests assert:**
- `ThreadSafeCounter().increment()` = 1 after one call
- `SensorRepository().getSnapshot()` returns correct values and is unmodifiable
- `produceAndConsume(listOf(1,2,3))` returns list containing 1, 2, 3 (order may vary)

---

## Task 15: Clean Code Ch14 — Successive Refinement

**Package:** `cleancode.ch14_successive_refinement`
**Epub:** `item2_chapter14.html`
**Key principles:** Make it work → make it clean. Continuous refinement. Args parser evolution.

**Exercise signatures:**
```kotlin
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
```

**Tests assert:**
- `parseNaive("host=localhost port=8080")` = mapOf("host" to "localhost", "port" to "8080")
- `parseRefined(listOf("-verbose", "-debug"))` = mapOf("verbose" to true, "debug" to true)
- `needsExtraction(25, 3)` = true (loc > 20)
- `needsExtraction(10, 2)` = false

---

## Task 16: Clean Code Ch15 — JUnit Internals (Kotlin adaptation)

**Package:** `cleancode.ch15_junit_internals`
**Note:** Original chapter walks through JUnit's ComparisonCompactor in Java. This chapter adapts it: refactor a messy Kotlin string compactor into clean code.

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Messy compactor — clean it up (rename, extract, simplify)
    class StringCompactor(private val contextLength: Int, private val expected: String, private val actual: String) {
        fun compact(): String {
            TODO("""
                Return compact diff string. If strings are equal return ''. 
                Otherwise show: '...[prefix]<expected|actual>[suffix]...'
                Use contextLength chars of context around the difference.
            """)
        }
    }

    // Exercise 2: Rename these confusing fields (return better names as list)
    fun betterNames(original: List<String>): List<String> {
        TODO("Map: fE->fExpected, fA->fActual, fCtx->fContextLength, fPfxLen->fPrefixLength, fSfxLen->fSuffixLength")
    }

    // Exercise 3: Extract a well-named boolean
    fun shouldBeCompacted(expected: String, actual: String): Boolean {
        TODO("Return true if expected != actual (i.e. compaction is needed)")
    }
}
```

**Tests assert:**
- `StringCompactor(2, "abc", "abc").compact()` = ""
- `StringCompactor(2, "abcde", "abXde").compact()` contains "c" and "X"
- `betterNames(listOf("fE","fA","fCtx"))` = listOf("fExpected","fActual","fContextLength")
- `shouldBeCompacted("a","b")` = true, `shouldBeCompacted("a","a")` = false

---

## Task 17: Clean Code Ch16 — Refactoring SerialDate (Kotlin adaptation)

**Package:** `cleancode.ch16_refactoring_serial_date`
**Note:** Original chapter refactors a Java date class. This chapter adapts it with a messy Kotlin date utility.

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: The original messy function — replace magic numbers with named constants
    fun addDays(date: SimpleDate, days: Int): SimpleDate {
        TODO("Implement correctly. Use DAYS_IN_NON_LEAP_YEAR = 365, not magic numbers")
    }

    // Exercise 2: Extract enum — replace int month with Month enum
    enum class Month(val value: Int) {
        JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
        JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);
        companion object { fun fromInt(v: Int): Month = TODO("Return matching enum or throw") }
    }

    // Exercise 3: isLeapYear — replace messy nested ifs with clean boolean expression
    fun isLeapYear(year: Int): Boolean {
        TODO("divisible by 4 AND (not divisible by 100 OR divisible by 400)")
    }
}

data class SimpleDate(val year: Int, val month: Int, val day: Int)
```

**Tests assert:**
- `addDays(SimpleDate(2026, 4, 29), 2)` = `SimpleDate(2026, 5, 1)`
- `Month.fromInt(1)` = `Month.JANUARY`
- `isLeapYear(2000)` = true, `isLeapYear(1900)` = false, `isLeapYear(2024)` = true

---

## Task 18: Clean Code Ch17 — Smells and Heuristics

**Package:** `cleancode.ch17_smells_and_heuristics`
**Epub:** `item2_chapter17.html`
**Key principles:** Catalog of smells across: comments, environment, functions, general (G1–G35), Java, names, tests

**Exercise signatures:**
```kotlin
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
```

**Tests assert:**
- `hasMultipleLanguages("fun main() { <?php echo 1; } ")` = true
- `countDuplicateBlocks(listOf("a","b","a","c"))` = 1 (line "a" duplicated)
- `isDescriptiveName("x")` = false, `isDescriptiveName("customerName")` = true
- `hasSufficientTests(85, 100)` = true, `hasSufficientTests(70, 100)` = false

---

## Task 19: Clean Coder Ch01 — Professionalism

**Package:** `cleancoder.ch01_professionalism`
**Epub:** `item1_ch01.html`
**Key principles:** Taking responsibility, do no harm (function + structure), test coverage, know it works, Boy Scout Rule, work ethic

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Professionalism means owning your bugs. Calculate cost of a bug to the team.
    fun bugCost(hourlyRate: Double, hoursToFix: Double, hoursCustomerLost: Double): Double {
        TODO("Return hourlyRate * hoursToFix + hoursCustomerLost * hourlyRate")
    }

    // Exercise 2: Boy Scout Rule — is the code cleaner than when you checked it out?
    fun isCodeCleaner(before: CodeMetrics, after: CodeMetrics): Boolean {
        TODO("Return true if after has fewer warnings AND shorter average function length")
    }

    // Exercise 3: Test coverage check — is it professional?
    fun isProfessionalCoverage(coveredLines: Int, totalLines: Int): Boolean {
        TODO("Return true only if coverage >= 1.0 (100%) — professionals demand it all")
    }
}

data class CodeMetrics(val warnings: Int, val avgFunctionLength: Double)
```

**Tests assert:**
- `bugCost(100.0, 4.0, 2.0)` = 600.0
- `isCodeCleaner(CodeMetrics(10, 20.0), CodeMetrics(5, 15.0))` = true
- `isProfessionalCoverage(100, 100)` = true, `isProfessionalCoverage(90, 100)` = false

---

## Task 20: Clean Coder Ch02 — Saying No

**Package:** `cleancoder.ch02_saying_no`
**Epub:** `item1_ch02.html`
**Key principles:** Adversarial roles, courage, the manager and programmer both defend objectives, "I'll try" is a lie

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Is this a real commitment or a weasel word?
    fun isRealCommitment(statement: String): Boolean {
        TODO("Return false if statement contains 'try', 'maybe', 'should', 'might', 'hope'")
    }

    // Exercise 2: Find the best possible outcome through negotiation
    fun negotiate(developerDays: Int, managerDays: Int): Int {
        TODO("Return the midpoint (integer division) — professionals find common ground")
    }

    // Exercise 3: The cost of saying yes when you should say no
    fun costOfYes(featureComplexity: Int, currentCapacity: Int): String {
        TODO("If featureComplexity > currentCapacity return 'disaster', else return 'ok'")
    }
}
```

**Tests assert:**
- `isRealCommitment("I will have it done by Friday")` = true
- `isRealCommitment("I'll try to get it done")` = false
- `negotiate(10, 4)` = 7
- `costOfYes(15, 10)` = "disaster"

---

## Task 21: Clean Coder Ch03 — Saying Yes

**Package:** `cleancoder.ch03_saying_yes`
**Epub:** `item1_ch03.html`
**Key principles:** Language of commitment (say/mean/do), recognising lack of commitment, creating commitment

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Language of commitment — does this statement use commitment language?
    fun usesCommitmentLanguage(statement: String): Boolean {
        TODO("Return true if starts with 'I will' or 'I am going to' — not 'I'll try' or 'we should'")
    }

    // Exercise 2: Identify what's stopping commitment and return a resolution
    fun resolveBlocker(blocker: String): String {
        TODO("""
            If blocker == 'dependency' return 'communicate dependency to stakeholder'
            If blocker == 'unclear' return 'clarify requirement before committing'
            Else return 'raise concern immediately'
        """)
    }

    // Exercise 3: Partial commitment — commit to what you CAN do
    fun partialCommitment(canDeliver: List<String>, requested: List<String>): List<String> {
        TODO("Return intersection of canDeliver and requested — commit only to what is possible")
    }
}
```

**Tests assert:**
- `usesCommitmentLanguage("I will finish the login page by Friday")` = true
- `usesCommitmentLanguage("We should probably get this done")` = false
- `resolveBlocker("dependency")` = "communicate dependency to stakeholder"
- `partialCommitment(listOf("A","B"), listOf("A","C"))` = listOf("A")

---

## Task 22: Clean Coder Ch04 — Coding

**Package:** `cleancoder.ch04_coding`
**Epub:** `item1_ch04.html`
**Key principles:** Preparedness, flow, interruptions, writer's block, debugging, pacing, being late

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Identify if you're in a productive state to code
    fun isReadyToCode(isRested: Boolean, hasUnderstoodRequirements: Boolean, isDistracted: Boolean): Boolean {
        TODO("Return true only if rested AND understands requirements AND NOT distracted")
    }

    // Exercise 2: Estimate remaining time when running late (linear extrapolation)
    fun estimateRemaining(completedPercent: Double, elapsedHours: Double): Double {
        TODO("Return (1.0 - completedPercent) / completedPercent * elapsedHours")
    }

    // Exercise 3: Debugging discipline — binary search the problem space
    fun binarySearchBug(low: Int, high: Int, bugAt: Int): Int {
        TODO("Return number of steps to find bugAt using binary search between low and high")
    }
}
```

**Tests assert:**
- `isReadyToCode(true, true, false)` = true
- `isReadyToCode(false, true, false)` = false
- `estimateRemaining(0.5, 4.0)` = 4.0
- `binarySearchBug(0, 100, 75)` <= 7 (log2(100) ≈ 7 steps)

---

## Task 23: Clean Coder Ch05 — Test Driven Development

**Package:** `cleancoder.ch05_test_driven_development`
**Epub:** `item1_ch05.html`
**Key principles:** Three Laws of TDD, certainty, courage, documentation, design

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Three laws — validate a TDD cycle step
    fun isValidTddStep(step: String, hasFailingTest: Boolean): Boolean {
        TODO("""
            'write_prod_code' requires hasFailingTest == true
            'write_test' requires hasFailingTest == false  
            'refactor' requires hasFailingTest == false (tests pass)
        """)
    }

    // Exercise 2: Kata — prime factors (classic TDD kata)
    fun primeFactors(n: Int): List<Int> {
        TODO("Return prime factors of n in ascending order. e.g. 12 -> [2,2,3]")
    }

    // Exercise 3: Coverage as documentation — does test name describe behavior?
    fun isBehavioralTestName(name: String): Boolean {
        TODO("Return true if name starts with 'should' or uses backtick notation with spaces (Kotlin style)")
    }
}
```

**Tests assert:**
- `isValidTddStep("write_prod_code", false)` = false (no failing test yet)
- `primeFactors(12)` = listOf(2, 2, 3)
- `primeFactors(1)` = emptyList()
- `primeFactors(7)` = listOf(7)
- `isBehavioralTestName("shouldReturnEmptyWhenInputIsZero")` = true

---

## Task 24: Clean Coder Ch06 — Practicing

**Package:** `cleancoder.ch06_practicing`
**Epub:** `item1_ch06.html`
**Key principles:** Coding katas, wasa (repetition), randori (pair kata), broadening experience

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Bowling kata — calculate score for a bowling game
    fun bowlingScore(rolls: List<Int>): Int {
        TODO("""
            Calculate score for a 10-frame bowling game.
            Strike (10): 10 + next two rolls bonus
            Spare (frame total 10): 10 + next one roll bonus
            Otherwise: sum of pins
        """)
    }

    // Exercise 2: FizzBuzz kata
    fun fizzBuzz(n: Int): String {
        TODO("Return 'FizzBuzz' if divisible by 15, 'Fizz' by 3, 'Buzz' by 5, else n.toString()")
    }

    // Exercise 3: Track kata repetitions — did you practice enough?
    fun isPracticed(repetitions: Int): Boolean {
        TODO("Return true if repetitions >= 10 (katas require repetition to become muscle memory)")
    }
}
```

**Tests assert:**
- `fizzBuzz(15)` = "FizzBuzz", `fizzBuzz(9)` = "Fizz", `fizzBuzz(10)` = "Buzz", `fizzBuzz(7)` = "7"
- `bowlingScore(List(20){0})` = 0 (all gutter balls)
- `bowlingScore(List(12){10})` = 300 (perfect game)
- `isPracticed(10)` = true, `isPracticed(9)` = false

---

## Task 25: Clean Coder Ch07 — Acceptance Testing

**Package:** `cleancoder.ch07_acceptance_testing`
**Epub:** `item1_ch07.html`
**Key principles:** Automated acceptance tests, Given-When-Then, communication between business and devs, avoiding ambiguity

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Parse a Given-When-Then scenario into parts
    data class Scenario(val given: String, val `when`: String, val then: String)
    fun parseScenario(text: String): Scenario {
        TODO("Split on 'Given:', 'When:', 'Then:' keywords and return trimmed parts")
    }

    // Exercise 2: Validate acceptance criterion completeness
    fun isCompleteAcceptanceCriterion(given: String, `when`: String, then: String): Boolean {
        TODO("Return true if all three parts are non-blank")
    }

    // Exercise 3: Simulate acceptance test execution
    fun runAcceptanceTest(feature: String, actualBehavior: String): Boolean {
        TODO("Return true if actualBehavior contains feature (case-insensitive substring match)")
    }
}
```

**Tests assert:**
- `parseScenario("Given: user logged in When: clicks logout Then: redirected to login")` = correct Scenario
- `isCompleteAcceptanceCriterion("user", "clicks", "redirected")` = true
- `isCompleteAcceptanceCriterion("", "clicks", "redirected")` = false
- `runAcceptanceTest("login", "user is shown the Login Page")` = true

---

## Task 26: Clean Coder Ch08 — Testing Strategies

**Package:** `cleancoder.ch08_testing_strategies`
**Epub:** `item1_ch08.html`
**Key principles:** Test pyramid (unit/component/integration/system/exploratory), QA finds nothing, test layers

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Classify a test by its characteristics
    enum class TestType { UNIT, COMPONENT, INTEGRATION, SYSTEM }
    fun classifyTest(isolatesDependencies: Boolean, crossesProcessBoundary: Boolean, coversFullSystem: Boolean): TestType {
        TODO("""
            coversFullSystem -> SYSTEM
            crossesProcessBoundary -> INTEGRATION  
            !isolatesDependencies -> COMPONENT
            else -> UNIT
        """)
    }

    // Exercise 2: Is the test pyramid healthy? (unit >> component >> integration >> system)
    fun isPyramidHealthy(unit: Int, component: Int, integration: Int, system: Int): Boolean {
        TODO("Return true if unit > component > integration > system")
    }

    // Exercise 3: Calculate QA escape rate
    fun qaEscapeRate(bugsFoundByQa: Int, bugsFoundByUsers: Int): Double {
        TODO("Return bugsFoundByUsers.toDouble() / (bugsFoundByQa + bugsFoundByUsers)")
    }
}
```

**Tests assert:**
- `classifyTest(true, false, false)` = UNIT
- `classifyTest(false, true, false)` = INTEGRATION
- `isPyramidHealthy(1000, 100, 10, 1)` = true
- `isPyramidHealthy(10, 100, 10, 1)` = false
- `qaEscapeRate(9, 1)` = 0.1

---

## Task 27: Clean Coder Ch09 — Time Management

**Package:** `cleancoder.ch09_time_management`
**Epub:** `item1_ch09.html`
**Key principles:** Meetings (decline when no value), focus/mana, avoiding blind alleys, marshes and messes

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Should you attend this meeting?
    fun shouldAttend(isAgendaProvided: Boolean, isYourPresenceRequired: Boolean, durationMinutes: Int): Boolean {
        TODO("Attend only if: agenda provided AND your presence required AND duration <= 30")
    }

    // Exercise 2: Focus budget — how many focused hours remain after meetings?
    fun focusHoursRemaining(totalHours: Double, meetingHours: Double, overhead: Double = 0.5): Double {
        TODO("Return totalHours - meetingHours - overhead")
    }

    // Exercise 3: Pomodoro — is this a valid work session?
    fun isValidPomodoro(durationMinutes: Int): Boolean {
        TODO("Return true if duration is exactly 25 minutes")
    }
}
```

**Tests assert:**
- `shouldAttend(true, true, 25)` = true
- `shouldAttend(false, true, 25)` = false (no agenda)
- `focusHoursRemaining(8.0, 3.0)` = 4.5
- `isValidPomodoro(25)` = true, `isValidPomodoro(30)` = false

---

## Task 28: Clean Coder Ch10 — Estimation

**Package:** `cleancoder.ch10_estimation`
**Epub:** `item1_ch10.html`
**Key principles:** Business vs developer estimates, PERT (optimistic/nominal/pessimistic), standard deviation, wideband delphi

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: PERT expected duration
    fun pertExpected(optimistic: Double, nominal: Double, pessimistic: Double): Double {
        TODO("Return (optimistic + 4*nominal + pessimistic) / 6")
    }

    // Exercise 2: PERT standard deviation
    fun pertStdDev(optimistic: Double, pessimistic: Double): Double {
        TODO("Return (pessimistic - optimistic) / 6")
    }

    // Exercise 3: 95% confidence range (expected ± 2 standard deviations)
    fun confidenceRange(expected: Double, stdDev: Double): Pair<Double, Double> {
        TODO("Return Pair(expected - 2*stdDev, expected + 2*stdDev)")
    }
}
```

**Tests assert:**
- `pertExpected(1.0, 3.0, 12.0)` ≈ 4.0 (within 0.01)
- `pertStdDev(1.0, 7.0)` = 1.0
- `confidenceRange(4.0, 1.0)` = Pair(2.0, 6.0)

---

## Task 29: Clean Coder Ch11 — Pressure

**Package:** `cleancoder.ch11_pressure`
**Epub:** `item1_ch11.html`
**Key principles:** Avoid pressure by keeping code clean, don't abandon disciplines under pressure, communicate

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Should you abandon TDD under deadline pressure?
    fun shouldAbandonTdd(isUnderPressure: Boolean, daysUntilDeadline: Int): Boolean {
        TODO("Always return false — TDD is the way OUT of pressure, not the cause of it")
    }

    // Exercise 2: Crisis response — what's the professional response?
    fun crisisResponse(problem: String): String {
        TODO("""
            'deadline' -> 'communicate early, keep disciplines, look for scope reduction'
            'bug_in_prod' -> 'stay calm, use TDD to reproduce, fix systematically'
            else -> 'keep disciplines, communicate status'
        """)
    }

    // Exercise 3: Technical debt accumulator — how does slipping under pressure compound?
    fun debtAccumulated(shortcuts: Int, complexityMultiplier: Double): Double {
        TODO("Return shortcuts * complexityMultiplier * shortcuts — debt grows quadratically")
    }
}
```

**Tests assert:**
- `shouldAbandonTdd(true, 1)` = false
- `shouldAbandonTdd(false, 100)` = false
- `crisisResponse("deadline")` contains "communicate"
- `debtAccumulated(3, 2.0)` = 18.0

---

## Task 30: Clean Coder Ch12 — Collaboration

**Package:** `cleancoder.ch12_collaboration`
**Epub:** `item1_ch12.html`
**Key principles:** Programming is a team sport, pair programming, code ownership, continuous review

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Pair programming — who drives, who navigates?
    data class PairSession(val driver: String, val navigator: String, val durationMinutes: Int)
    fun shouldSwitch(session: PairSession): Boolean {
        TODO("Return true if durationMinutes >= 30 — switch roles regularly")
    }

    // Exercise 2: Code ownership — collective ownership check
    fun isCollectiveOwnership(touchedByDevelopers: Int, totalDevelopers: Int): Boolean {
        TODO("Return true if touchedByDevelopers.toDouble() / totalDevelopers >= 0.5")
    }

    // Exercise 3: Review value — is this feedback actionable?
    fun isActionableFeedback(comment: String): Boolean {
        TODO("Return true if comment length > 10 AND contains a verb (simple check: contains ' ' and length > 10)")
    }
}
```

**Tests assert:**
- `shouldSwitch(PairSession("Alice", "Bob", 31))` = true
- `shouldSwitch(PairSession("Alice", "Bob", 20))` = false
- `isCollectiveOwnership(4, 6)` = true (4/6 > 0.5)
- `isActionableFeedback("ok")` = false
- `isActionableFeedback("extract this into a separate function")` = true

---

## Task 31: Clean Coder Ch13 — Teams and Projects

**Package:** `cleancoder.ch13_teams_and_projects`
**Epub:** `item1_ch13.html`
**Key principles:** Team jell, team velocity, fractured teams, team players, project ownership

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Calculate team velocity (story points per sprint)
    fun teamVelocity(completedPoints: List<Int>): Double {
        TODO("Return average of last 3 completed sprint velocities (or all if fewer than 3)")
    }

    // Exercise 2: Team gel check — is the team working as one?
    fun isGelled(hasSharedGoal: Boolean, trustLevel: Int, communicationScore: Int): Boolean {
        TODO("Return true if hasSharedGoal AND trustLevel >= 7 AND communicationScore >= 7")
    }

    // Exercise 3: Fractured team risk — too many projects per developer?
    fun isFractured(developers: Int, simultaneousProjects: Int): Boolean {
        TODO("Return true if simultaneousProjects > developers * 2 — team is spread too thin")
    }
}
```

**Tests assert:**
- `teamVelocity(listOf(20, 22, 18, 25))` = (22 + 18 + 25) / 3.0 ≈ 21.67
- `isGelled(true, 8, 8)` = true, `isGelled(true, 5, 8)` = false
- `isFractured(4, 9)` = true (9 > 4*2=8)

---

## Task 32: Clean Coder Ch14 — Mentoring, Apprenticeship, and Craftsmanship

**Package:** `cleancoder.ch14_mentoring_apprenticeship_craftsmanship`
**Epub:** `item1_ch14.html`
**Key principles:** Craftsmanship manifesto, apprenticeship, mentoring, school vs craft, the software craftsmanship manifesto

**Exercise signatures:**
```kotlin
object Exercise {
    // Exercise 1: Craftsmanship level assessment
    enum class CraftsmanshipLevel { APPRENTICE, JOURNEYMAN, MASTER }
    fun assessLevel(yearsExperience: Int, hasMentored: Boolean, contributesToOss: Boolean): CraftsmanshipLevel {
        TODO("""
            MASTER: yearsExperience >= 10 AND hasMentored AND contributesToOss
            JOURNEYMAN: yearsExperience >= 5 AND (hasMentored OR contributesToOss)
            APPRENTICE: otherwise
        """)
    }

    // Exercise 2: Mentoring value — time invested in mentee
    fun mentoringReturn(hoursMentored: Double, menteeProductivityGain: Double): Double {
        TODO("Return hoursMentored * menteeProductivityGain — investment that compounds over career")
    }

    // Exercise 3: Craftsmanship manifesto — does this behavior reflect craftsmanship?
    fun demonstratesCraftsmanship(refactorsOpportunistically: Boolean, writesTestsFirst: Boolean, sharesKnowledge: Boolean): Boolean {
        TODO("Return true if ALL three are true — craftsmanship requires all three disciplines")
    }
}
```

**Tests assert:**
- `assessLevel(12, true, true)` = MASTER
- `assessLevel(6, false, true)` = JOURNEYMAN
- `assessLevel(2, false, false)` = APPRENTICE
- `mentoringReturn(10.0, 1.5)` = 15.0
- `demonstratesCraftsmanship(true, true, true)` = true
- `demonstratesCraftsmanship(true, false, true)` = false

---

## Commit strategy

Each chapter agent should commit their chapter with:
```bash
git add src/ docs/
git commit -m "feat: add [book] ch[NN] — [chapter name] exercises"
```
