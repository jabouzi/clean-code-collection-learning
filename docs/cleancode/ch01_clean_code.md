# Chapter 1: Clean Code

## Key Principles

- **LeBlanc's Law** — "Later equals never." Technical debt accumulates if you defer cleanup.
- **Cost of Mess** — Messy code slows every future change; productivity trends toward zero as the codebase rots.
- **What Makes Code Clean** — Readable, expressive, single-responsibility units with minimal dependencies and comprehensive tests.
- **Boy Scout Rule** — Always leave the code cleaner than you found it.
- **WTF/Minute** — The informal measure of code quality: how many "what the?!" moments per minute during a code review.

## Kotlin Notes

- Kotlin's concise syntax and null safety already nudge you toward cleaner code.
- Use `val` over `var` where possible — immutability is a cleanliness signal.
- Data classes, extension functions, and named parameters reduce boilerplate noise.

## Exercises

1. **responsibilities(fn)**: Count the number of responsibilities implied by a camelCase function name by splitting on `And`.
2. **isBoyScoutCompliant(before, after)**: Return `true` if the `after` version is shorter (simpler) than `before` — a proxy for leaving code cleaner.
3. **wtfRate(totalLines, badLines)**: Return `badLines / totalLines` as a `Double` — the lower the ratio, the cleaner the code.
