# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Purpose

An interactive, chapter-by-chapter Kotlin tutorial covering both books in the Robert C. Martin Clean Code Collection:

- **Clean Code** (17 chapters) — code quality: naming, functions, comments, error handling, classes, concurrency, refactoring
- **The Clean Coder** (14 chapters) — professional behavior: saying no, TDD, estimation, pressure, collaboration

Exercises use a TDD-style learning loop: pre-written failing tests that pass once you implement the solution.

## Build & Test

```bash
# Run all 205 tests
./gradlew test

# Run a single chapter
./gradlew test --tests "cleancode.ch02_meaningful_names.*"

# Run all Clean Code chapters
./gradlew test --tests "cleancode.*"

# Run all Clean Coder chapters
./gradlew test --tests "cleancoder.*"
```

## Project Setup

- **Language**: Kotlin JVM
- **Build**: Gradle with Kotlin DSL (`build.gradle.kts`)
- **Test framework**: `kotlin.test` + JUnit 5
- **JVM toolchain**: 17

## Architecture

Each of the 31 chapters is a self-contained package under one of two top-level namespaces:

```
src/
├── main/kotlin/
│   ├── cleancode/ch01_clean_code/ … ch17_smells_and_heuristics/
│   │   ├── Exercise.kt   ← object Exercise { TODO() stubs — fill these in }
│   │   └── Solution.kt   ← object Solution { reference implementation }
│   └── cleancoder/ch01_professionalism/ … ch14_mentoring_…/
│       ├── Exercise.kt
│       └── Solution.kt
└── test/kotlin/
    ├── cleancode/ch*/ExercisesTest.kt
    └── cleancoder/ch*/ExercisesTest.kt
docs/
├── cleancode/ch*.md    ← principles + exercise briefs
└── cleancoder/ch*.md
```

### The learning loop

1. Read `docs/<book>/<chapter>.md` — understand the principles
2. Open `ExercisesTest.kt` — read what each test expects
3. Open `Exercise.kt` — replace `TODO(...)` with your implementation
4. Run `./gradlew test --tests "<package>.*"` — iterate until green
5. Swap `val subject = Solution` in the test file — compare with the reference answer
6. Move to the next chapter

### The swap mechanism

Every `ExercisesTest.kt` has this at the top:

```kotlin
// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────
```

Changing one line switches all tests between your work and the reference. Note: 22 class-implementation exercises test the Exercise class directly (no swap needed — just look at the `Sol`-prefixed class in `Solution.kt` for reference).

### Expected test counts

| Mode | Tests passing |
|------|--------------|
| `subject = Exercise` (default) | 0/205 — all `NotImplementedError` until you implement |
| `subject = Solution` | 183/205 — 22 class-impl exercises always test Exercise directly |

## Adding new chapters / topics

New learning content goes under a new package following the same 3-file pattern. If adding content unrelated to Clean Code, create a new top-level package (e.g., `designpatterns/`, `algorithms/`).
