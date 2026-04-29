# Chapter 15: JUnit Internals (Kotlin Adaptation)

## Key Principles

- **Expressive Names** — `fE`, `fA`, `fCtx` are opaque. `fExpected`, `fActual`, `fContextLength` communicate immediately. Names are the cheapest form of documentation.
- **Extract Well-Named Booleans** — `if (!shouldBeCompacted())` reads like prose; `if (!(expected == null || actual == null || areStringsEqual()))` does not.
- **Single Responsibility within Methods** — `compact()` should orchestrate steps; each step (find prefix, find suffix, build compact string) should be its own extracted method.
- **Encapsulation of State** — all the messy intermediate state (`fPrefixLength`, `fSuffixLength`) should be private implementation detail, not exposed.
- **Refactoring Is Iterative** — the ComparisonCompactor chapter shows that even good code in a revered open-source project has room for improvement.

## Kotlin Notes

- Kotlin's `String.substring(start, end)` is the same as Java's.
- `minOf`/`maxOf` replace `Math.min`/`Math.max` idiomatically.
- `mapOf` with `getOrDefault` (or `?: it`) cleanly handles unknown keys in renaming maps.

## Exercises

1. **StringCompactor.compact()**: Return `""` for equal strings; for differing strings, show context around the first difference using `contextLength`.
2. **betterNames()**: Map the five abbreviated field names (`fE`, `fA`, `fCtx`, `fPfxLen`, `fSfxLen`) to their descriptive counterparts.
3. **shouldBeCompacted()**: Return `expected != actual` — the simplest boolean extraction that eliminates a confusing negated condition.
