# Chapter 14: Successive Refinement

## Key Principles

- **Make It Work, Then Make It Clean** — write the simplest thing that could possibly work first. Then refactor relentlessly. Never mix writing and cleaning.
- **Continuous Refinement** — code rots when it is not continuously improved. The moment you stop caring, the mess begins.
- **Incremental Development** — the Args parser example: start with a naive version that handles one type, then add types one at a time, refactoring at each step.
- **Extract Method** — when a function grows too long or complex (`loc > 20` or `cyclomaticComplexity > 5`), it is a signal to extract.
- **Boy Scout Rule** — always leave the code cleaner than you found it.

## Kotlin Notes

- `String.split(" ")` with `filter` and `associate` makes a readable naive parser.
- `String.removePrefix("-")` cleanly strips flag prefixes.
- `split("=", limit = 2)` handles values that contain `=` (e.g. `url=http://x=y`).

## Exercises

1. **parseNaive**: Split on spaces, then split each token on `=` — handles the simple case and no more.
2. **parseRefined**: Filter tokens starting with `-`, strip the prefix, associate each with `true`.
3. **needsExtraction**: Return `true` if `linesOfCode > 20 || cyclomaticComplexity > 5` — objective signals that a function needs to be broken down.
