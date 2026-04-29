# Chapter 16: Refactoring SerialDate (Kotlin Adaptation)

## Key Principles

- **Replace Magic Numbers with Named Constants** — `365`, `12`, `28` scattered through date logic are time bombs. Name them: `DAYS_IN_NON_LEAP_YEAR`, `MONTHS_IN_YEAR`, etc.
- **Use Enums to Replace int Constants** — `month: Int` can be any integer; `month: Month` is type-safe and self-documenting.
- **Clean Boolean Expressions** — the leap year rule expressed as a single boolean (`year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)`) is clearer than nested `if`/`else` chains.
- **Small, Focused Functions** — `addDays` should delegate to `daysInMonth` which delegates to `isLeapYear`. Each layer has one job.
- **Incremental Refactoring** — the chapter demonstrates that even a well-known library class can be substantially improved by systematic, test-backed refactoring.

## Kotlin Notes

- `enum class Month(val value: Int)` with a `companion object { fun fromInt(v: Int): Month }` is the idiomatic type-safe enum factory.
- `entries.firstOrNull { it.value == v }` is the modern Kotlin way (replaces `values()`).
- The leap year expression maps directly to the Gregorian calendar rule: divisible by 4, UNLESS divisible by 100, EXCEPT when divisible by 400.

## Exercises

1. **addDays**: Advance a `SimpleDate` by `days` days, rolling over month and year boundaries correctly.
2. **Month.fromInt**: Find the matching `Month` enum entry for an integer, or throw `IllegalArgumentException`.
3. **isLeapYear**: Express the Gregorian leap year rule as a single boolean: `year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)`.
