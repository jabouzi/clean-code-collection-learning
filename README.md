# Clean Code Collection — Interactive Kotlin Tutorial

An interactive, chapter-by-chapter Kotlin tutorial based on the **Robert C. Martin Clean Code Collection**, covering both books with hands-on TDD-style exercises.

---

## Books covered

| Book | Chapters | Focus |
|------|----------|-------|
| **Clean Code** | 17 | Code quality: naming, functions, comments, error handling, classes, concurrency, refactoring |
| **The Clean Coder** | 14 | Professional behavior: saying no, TDD, estimation, pressure, collaboration |

---

## How it works

Each chapter follows the same structure:

```
src/main/kotlin/cleancode/ch02_meaningful_names/
├── Exercise.kt   ← Fill in the TODO() stubs
└── Solution.kt   ← Reference implementation to compare against

src/test/kotlin/cleancode/ch02_meaningful_names/
└── ExercisesTest.kt  ← Pre-written failing tests

docs/cleancode/
└── ch02_meaningful_names.md  ← Principles + exercise briefs
```

### The learning loop

```
1. Read docs/<chapter>.md        → understand the principles
2. Open ExercisesTest.kt         → see what the tests expect
3. Fill in Exercise.kt TODOs     → make tests pass
4. Swap val subject = Solution   → compare with the reference answer
5. Move to the next chapter      → repeat
```

### The swap mechanism

Every test file has a single line to swap between your work and the solution:

```kotlin
// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────
```

---

## Getting started

### Prerequisites

- JDK 17+
- Gradle (or use the included `./gradlew` wrapper)

### Run all tests

```bash
./gradlew test
```

Expected output when you first clone (before implementing anything):

```
205 tests completed, 205 failed
```

All failures are `kotlin.NotImplementedError` — that's correct. Your job is to make them green.

### Run a single chapter

```bash
# One chapter
./gradlew test --tests "cleancode.ch02_meaningful_names.*"

# All Clean Code chapters
./gradlew test --tests "cleancode.*"

# All Clean Coder chapters
./gradlew test --tests "cleancoder.*"
```

---

## Chapter index

### Clean Code

| # | Chapter | Key principles |
|---|---------|---------------|
| 01 | Clean Code | LeBlanc's Law, cost of mess, Boy Scout Rule |
| 02 | Meaningful Names | Intention-revealing names, avoid disinformation, searchable names |
| 03 | Functions | Small, do one thing, one level of abstraction, command-query separation |
| 04 | Comments | Comments are failures — explain yourself in code |
| 05 | Formatting | Newspaper metaphor, vertical openness, step-down rule |
| 06 | Objects and Data Structures | Law of Demeter, data/object anti-symmetry, train wrecks |
| 07 | Error Handling | Exceptions over return codes, Special Case pattern, don't return null |
| 08 | Boundaries | Wrap third-party APIs, learning tests, clean boundaries |
| 09 | Unit Tests | F.I.R.S.T., Build-Operate-Check, single concept per test |
| 10 | Classes | SRP, cohesion, OCP, isolating from change |
| 11 | Systems | Separate construction from use, dependency injection, factories |
| 12 | Emergence | Kent Beck's 4 rules of simple design |
| 13 | Concurrency | Shared data risks, AtomicInteger, producer-consumer |
| 14 | Successive Refinement | Make it work → make it clean, continuous improvement |
| 15 | JUnit Internals | Refactoring discipline (Kotlin adaptation) |
| 16 | Refactoring SerialDate | Step-by-step refactoring (Kotlin adaptation) |
| 17 | Smells and Heuristics | Complete catalog of code smells across comments, functions, names, tests |

### The Clean Coder

| # | Chapter | Key principles |
|---|---------|---------------|
| 01 | Professionalism | Taking responsibility, do no harm, test coverage |
| 02 | Saying No | Adversarial roles, courage, "I'll try" is a lie |
| 03 | Saying Yes | Language of commitment, partial commitments |
| 04 | Coding | Preparedness, flow, pacing, debugging discipline |
| 05 | Test Driven Development | Three Laws of TDD, prime factors kata |
| 06 | Practicing | Katas, FizzBuzz, bowling scorer |
| 07 | Acceptance Testing | Given-When-Then, automated acceptance tests |
| 08 | Testing Strategies | Test pyramid, classifying tests, QA escape rate |
| 09 | Time Management | Meetings, focus, Pomodoro |
| 10 | Estimation | PERT, standard deviation, confidence ranges |
| 11 | Pressure | Never abandon disciplines, crisis response |
| 12 | Collaboration | Pair programming, collective ownership |
| 13 | Teams and Projects | Team velocity, gel, fractured teams |
| 14 | Mentoring, Apprenticeship, and Craftsmanship | Craftsmanship levels, manifesto |

---

## Project structure

```
├── build.gradle.kts
├── settings.gradle.kts
├── src/
│   ├── main/kotlin/
│   │   ├── cleancode/
│   │   │   ├── ch01_clean_code/
│   │   │   │   ├── Exercise.kt
│   │   │   │   └── Solution.kt
│   │   │   └── ... (ch02–ch17)
│   │   └── cleancoder/
│   │       ├── ch01_professionalism/
│   │       │   ├── Exercise.kt
│   │       │   └── Solution.kt
│   │       └── ... (ch02–ch14)
│   └── test/kotlin/
│       ├── cleancode/ch*/ExercisesTest.kt
│       └── cleancoder/ch*/ExercisesTest.kt
└── docs/
    ├── cleancode/ch*.md
    └── cleancoder/ch*.md
```

---

## Tech stack

- **Language**: Kotlin JVM
- **Build**: Gradle with Kotlin DSL
- **Test framework**: `kotlin.test` + JUnit 5
- **JVM**: 17

---

## Source material

Based on **The Robert C. Martin Clean Code Collection** — *Clean Code* and *The Clean Coder*.
All code examples are original Kotlin implementations inspired by the Java examples in the books.
