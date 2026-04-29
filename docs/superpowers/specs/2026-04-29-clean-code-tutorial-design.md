# Clean Code Interactive Tutorial — Design Spec

**Date:** 2026-04-29  
**Source material:** The Robert C. Martin Clean Code Collection (epub)  
**Project:** IntelliJ IDEA Kotlin project at `Learning/`

---

## Overview

An interactive, chapter-by-chapter tutorial covering both books in the collection:

- **The Clean Coder** (14 chapters) — professional behavior: saying no, TDD, estimation, pressure, collaboration
- **Clean Code** (17 chapters) — code quality: naming, functions, comments, error handling, classes, concurrency, refactoring

Total: 31 chapters. Each chapter is a self-contained Kotlin exercise set that the learner works through by making pre-written failing tests pass (TDD-style learning loop).

---

## Build System

Migrate the existing IntelliJ-only project to **Gradle with Kotlin DSL**.

- Plugin: `kotlin("jvm")`
- Test framework: `kotlin.test` + JUnit 5 as the engine
- No other runtime dependencies required

`build.gradle.kts` configures:
- `useJUnitPlatform()` for the test task
- Standard `src/main/kotlin` and `src/test/kotlin` source roots

---

## Project Structure

```
Learning/
├── build.gradle.kts
├── settings.gradle.kts
├── src/
│   ├── main/kotlin/
│   │   ├── cleancoder/
│   │   │   ├── ch01_professionalism/
│   │   │   │   ├── Exercise.kt
│   │   │   │   └── Solution.kt
│   │   │   ├── ch02_saying_no/
│   │   │   ├── ch03_saying_yes/
│   │   │   ├── ch04_coding/
│   │   │   ├── ch05_test_driven_development/
│   │   │   ├── ch06_practicing/
│   │   │   ├── ch07_acceptance_testing/
│   │   │   ├── ch08_testing_strategies/
│   │   │   ├── ch09_time_management/
│   │   │   ├── ch10_estimation/
│   │   │   ├── ch11_pressure/
│   │   │   ├── ch12_collaboration/
│   │   │   ├── ch13_teams_and_projects/
│   │   │   └── ch14_mentoring_apprenticeship_craftsmanship/
│   │   └── cleancode/
│   │       ├── ch01_clean_code/
│   │       │   ├── Exercise.kt
│   │       │   └── Solution.kt
│   │       ├── ch02_meaningful_names/
│   │       ├── ch03_functions/
│   │       ├── ch04_comments/
│   │       ├── ch05_formatting/
│   │       ├── ch06_objects_and_data_structures/
│   │       ├── ch07_error_handling/
│   │       ├── ch08_boundaries/
│   │       ├── ch09_unit_tests/
│   │       ├── ch10_classes/
│   │       ├── ch11_systems/
│   │       ├── ch12_emergence/
│   │       ├── ch13_concurrency/
│   │       ├── ch14_successive_refinement/
│   │       ├── ch15_junit_internals/
│   │       ├── ch16_refactoring_serial_date/
│   │       └── ch17_smells_and_heuristics/
│   └── test/kotlin/
│       ├── cleancoder/
│       │   └── ch01_professionalism/
│       │       └── ExercisesTest.kt
│       │   └── ... (ch02–ch14)
│       └── cleancode/
│           └── ch01_clean_code/
│               └── ExercisesTest.kt
│           └── ... (ch02–ch17)
└── docs/
    ├── cleancoder/
    │   ├── ch01_professionalism.md
    │   └── ... (ch02–ch14)
    └── cleancode/
        ├── ch01_clean_code.md
        └── ... (ch02–ch17)
```

---

## Chapter Anatomy

Every chapter follows an identical 3-file pattern in `src/main/kotlin/` plus one test file and one doc file.

### `Exercise.kt`

Declares an `object Exercise` with stub functions. Using an `object` (singleton) rather than top-level functions is what makes the import-swap mechanism work — the test can import either `Exercise` or `Solution` as a named qualifier. The TODO message names the specific principle to apply.

```kotlin
package cleancode.ch02_meaningful_names

object Exercise {

    // Exercise 1: Rename this function and its variables to reveal intent
    fun getThem(theList: List<IntArray>): List<IntArray> {
        TODO("Apply 'Use Intention-Revealing Names' — what is theList? what does index 0 mean? what is 4?")
    }

    // Exercise 2: Fix the disinformation in this function's parameter names
    fun copyChars(a1: CharArray, a2: CharArray) {
        for (i in a1.indices) a2[i] = a1[i]
        // Body is correct — only the parameter names need fixing
    }
}
```

### `Solution.kt`

Declares an `object Solution` with identical method signatures and a full implementation. Includes inline comments explaining the principle applied.

```kotlin
package cleancode.ch02_meaningful_names

object Solution {

    // Principle: Use Intention-Revealing Names — every name answers why, what, and how
    fun getFlaggedCells(gameBoard: List<IntArray>): List<IntArray> {
        val STATUS_VALUE = 0
        val FLAGGED = 4
        return gameBoard.filter { cell -> cell[STATUS_VALUE] == FLAGGED }
    }

    // Principle: Avoid Disinformation — source and destination are unambiguous
    fun copyChars(source: CharArray, destination: CharArray) {
        for (i in source.indices) destination[i] = source[i]
    }
}
```

### `ExercisesTest.kt`

Tests are wired to `Exercise` by default via a `val subject` alias. A single line swap switches to `Solution` — no other changes needed anywhere in the test.

```kotlin
package cleancode.ch02_meaningful_names

import kotlin.test.Test
import kotlin.test.assertEquals

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class MeaningfulNamesTest {

    @Test
    fun `getFlaggedCells returns only flagged cells from game board`() {
        val FLAGGED = 4
        val board = listOf(intArrayOf(0), intArrayOf(FLAGGED), intArrayOf(2))
        assertEquals(1, subject.getFlaggedCells(board).size)
    }

    @Test
    fun `copyChars copies all characters from source to destination`() {
        val src = charArrayOf('a', 'b', 'c')
        val dst = CharArray(3)
        subject.copyChars(src, dst)
        assertEquals(src.toList(), dst.toList())
    }
}
```

### `docs/<book>/<chapter>.md`

One Markdown file per chapter:
- **Principles** — key rules from the book (3–7 bullet points, direct quotes or close paraphrases)
- **Kotlin notes** — where Kotlin idioms differ from the book's Java examples
- **Exercises** — numbered list matching the exercise stubs, with the brief and relevant book section

---

## Exercise Content Strategy

### 3–5 exercises per chapter

Enough to be substantive; short enough to complete in a single sitting.

### Two exercise types

**Type 1 — Fix the bad code:** The book shows a before/after pair. `Exercise.kt` gets the bad structure (or the correct body with wrong names/signatures). The test asserts correct behavior. `Solution.kt` shows the clean version.

**Type 2 — Apply the principle:** For chapters with less concrete code (especially The Clean Coder), small Kotlin scenarios force application of the rule. For example:
- Ch2 "Saying No": a `ProjectManager` / `Developer` class pair where `Developer.respondToRequest()` must push back correctly
- Ch5 "Test Driven Development": write the failing test first, then the passing implementation, then refactor

### Kotlin adaptations

Java idioms in the book are replaced with idiomatic Kotlin equivalents:

| Book (Java) | Tutorial (Kotlin) |
|---|---|
| `ArrayList`, `for` loop | `listOf`, `filter`, `map` |
| `instanceof` + cast | `is` + smart cast |
| Checked exceptions | Unchecked exceptions, `Result<T>`, `sealed class` |
| Abstract class + override | `interface` with default methods or `sealed class` |
| Builder pattern (verbose) | Named parameters + default values |

### Chapters 15–16 (Java deep-dives)

Ch15 (JUnit Internals) and Ch16 (Refactoring SerialDate) are Java-specific walkthroughs. These become Kotlin refactoring exercises on equivalent Kotlin code — the same refactoring discipline applied to a Kotlin-native messy class rather than a literal Java translation.

---

## Learning Loop

The intended workflow for each chapter:

1. Read `docs/<book>/<chapter>.md` — understand the principles
2. Open `ExercisesTest.kt` — read what the tests expect
3. Open `Exercise.kt` — replace `TODO(...)` with your implementation
4. Run tests (`./gradlew test --tests "<package>.*"`) — iterate until green
5. Compare with `Solution.kt` — review the reference answer
6. Move to the next chapter

---

## Running Tests

```bash
# Run all tests
./gradlew test

# Run a single chapter's tests
./gradlew test --tests "cleancode.ch02_meaningful_names.*"

# Run all Clean Code chapters
./gradlew test --tests "cleancode.*"

# Run all Clean Coder chapters
./gradlew test --tests "cleancoder.*"
```

---

## Chapter Inventory

### The Clean Coder (14 chapters)

| Package | Chapter |
|---|---|
| `ch01_professionalism` | 1. Professionalism |
| `ch02_saying_no` | 2. Saying No |
| `ch03_saying_yes` | 3. Saying Yes |
| `ch04_coding` | 4. Coding |
| `ch05_test_driven_development` | 5. Test Driven Development |
| `ch06_practicing` | 6. Practicing |
| `ch07_acceptance_testing` | 7. Acceptance Testing |
| `ch08_testing_strategies` | 8. Testing Strategies |
| `ch09_time_management` | 9. Time Management |
| `ch10_estimation` | 10. Estimation |
| `ch11_pressure` | 11. Pressure |
| `ch12_collaboration` | 12. Collaboration |
| `ch13_teams_and_projects` | 13. Teams and Projects |
| `ch14_mentoring_apprenticeship_craftsmanship` | 14. Mentoring, Apprenticeship, and Craftsmanship |

### Clean Code (17 chapters)

| Package | Chapter |
|---|---|
| `ch01_clean_code` | 1. Clean Code |
| `ch02_meaningful_names` | 2. Meaningful Names |
| `ch03_functions` | 3. Functions |
| `ch04_comments` | 4. Comments |
| `ch05_formatting` | 5. Formatting |
| `ch06_objects_and_data_structures` | 6. Objects and Data Structures |
| `ch07_error_handling` | 7. Error Handling |
| `ch08_boundaries` | 8. Boundaries |
| `ch09_unit_tests` | 9. Unit Tests |
| `ch10_classes` | 10. Classes |
| `ch11_systems` | 11. Systems |
| `ch12_emergence` | 12. Emergence |
| `ch13_concurrency` | 13. Concurrency |
| `ch14_successive_refinement` | 14. Successive Refinement |
| `ch15_junit_internals` | 15. JUnit Internals (Kotlin adaptation) |
| `ch16_refactoring_serial_date` | 16. Refactoring SerialDate (Kotlin adaptation) |
| `ch17_smells_and_heuristics` | 17. Smells and Heuristics |
