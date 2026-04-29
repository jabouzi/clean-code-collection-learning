# Chapter 9: Unit Tests

## Key Principles

- **Three Laws of TDD** — (1) Write no production code before a failing test. (2) Write only enough test code to produce a failure. (3) Write only enough production code to make the failing test pass.
- **Clean Tests = Readability** — the most important quality of a test is readability. Tests serve as documentation; they must be clear, simple, and expressive.
- **Build-Operate-Check (Given-When-Then)** — structure every test in three phases: build the test data, operate on the system, check the result. Separate each phase visually.
- **Single Concept Per Test** — one `assert` per concept, one concept per test. If a test name contains "And", it likely tests multiple concepts.
- **F.I.R.S.T.** — tests must be: **F**ast (milliseconds), **I**ndependent (no shared state), **R**epeatable (same result anywhere), **S**elf-validating (pass/fail, no manual inspection), **T**imely (written just before production code).

## Kotlin Notes

- Backtick test names `` fun `should return empty list when no sensors` `` make test intent crystal clear — prefer them over camelCase names.
- `kotlin.test` provides `assertEquals`, `assertTrue`, `assertFalse`, `assertFailsWith` with no extra setup.
- Use `data class` for test fixtures — structural equality makes assertions trivial.

## Exercises

1. **getSystemState** — Build-Operate-Check: encode five hardware booleans into a compact 5-character string (uppercase = ON, lowercase = OFF).
2. **isFastTest / isIndependentTest** — implement F.I.R.S.T. attribute checks for Fast and Independent.
3. **hasSingleConcept** — detect when a test name (containing "And") violates the single-concept rule.
