# Chapter 17: Smells and Heuristics

## Key Principles

This chapter is a catalog of code smells organized into categories:

### Comments
- **C1** — Inappropriate Information: comments that belong in other systems (VCS, issue tracker)
- **C2** — Obsolete Comment: a comment that has drifted from the code it describes
- **C3** — Redundant Comment: a comment that describes what the code already clearly says
- **C4** — Poorly Written Comment: if you write a comment, write it well
- **C5** — Commented-Out Code: delete it; VCS remembers

### General (selected)
- **G1** — Multiple Languages in One Source File: each file should be written in one language
- **G2** — Obvious Behaviour Is Unimplemented: follow the Principle of Least Surprise
- **G5** — Duplication: DRY — every duplication is a missed abstraction
- **G16** — Obscured Intent: code should express intent as clearly as possible
- **G25** — Replace Magic Numbers with Named Constants: every raw number is a candidate
- **G30** — Functions Should Do One Thing

### Names
- **N1** — Choose Descriptive Names: single letters and cryptic abbreviations are not names
- **N2** — Choose Names at the Appropriate Level of Abstraction
- **N7** — Names Should Describe Side-Effects: `getOrCreateSocket()` not `getSocket()`

### Tests
- **T1** — Insufficient Tests: a test suite should test everything that could possibly break
- **T2** — Use a Coverage Tool: make the untested code visible
- **T5** — Test Boundary Conditions: the edges are where bugs cluster
- **T9** — Tests Should Be Fast: slow tests don't get run

## Kotlin Notes

- `String.uppercase()` is the idiomatic Kotlin replacement for Java's `toUpperCase()`.
- `groupingBy { it }.eachCount()` is a one-liner for frequency counting.
- Named parameters (`hasSufficientTests(coveredLines = 85, totalLines = 100)`) reduce the need for comments at call sites.

## Exercises

1. **hasMultipleLanguages**: Detect G1 by checking for both `<?php` and `fun ` in a single source file.
2. **countDuplicateBlocks**: Detect G5 by counting lines that appear more than once.
3. **isDescriptiveName**: Enforce N1 — a name is descriptive if it is longer than 3 characters and is not all uppercase.
4. **hasSufficientTests**: Enforce T1 — flag insufficient coverage when `coveredLines / totalLines < 0.8`.
