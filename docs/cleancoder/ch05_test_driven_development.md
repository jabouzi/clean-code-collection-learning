# The Clean Coder — Chapter 5: Test Driven Development

## Key Principles

- **The Three Laws of TDD**:
  1. You may not write production code until you have written a failing unit test.
  2. You may not write more of a unit test than is sufficient to fail (and not compiling is failing).
  3. You may not write more production code than is sufficient to pass the currently failing test.
- **Certainty** — Following the three laws means you have a test for every line of production code. The tests become the safety net.
- **Courage** — A comprehensive test suite gives you the courage to refactor. Without tests, every change is a risk.
- **Documentation** — Unit tests are the best possible documentation of the system. They are always up to date and always executable.
- **Design** — TDD forces better design. Testable code is decoupled code.

## The TDD Cycle

```
Write failing test → Write just enough code to pass → Refactor → Repeat
```

Each cycle should take minutes, not hours. If the cycle is long, the design has problems.

## Prime Factors Kata

A classic TDD kata that demonstrates how tests drive incremental growth:
- `primeFactors(1)` → `[]`
- `primeFactors(2)` → `[2]`
- `primeFactors(4)` → `[2, 2]`
- `primeFactors(12)` → `[2, 2, 3]`

The solution emerges by adding one test at a time, never writing more code than needed.

## Kotlin Notes

- `mutableListOf<Int>()` is the natural accumulator for the prime factors loop
- Use `while (remaining > 1)` with an inner `while (remaining % divisor == 0)` loop
- Backtick test names like `` `should return empty for 1` `` are idiomatic Kotlin TDD

## Exercises

1. **isValidTddStep**: Enforce the Three Laws — verify that each step in a TDD cycle only happens when the preconditions are met.
2. **primeFactors**: Implement the classic TDD kata using a loop-based divisor approach.
3. **isBehavioralTestName**: Identify test names that describe observable behavior rather than internal implementation details.
