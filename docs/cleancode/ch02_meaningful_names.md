# Chapter 2: Meaningful Names

## Key Principles

- **Use Intention-Revealing Names** — every name answers why it exists, what it does, how it is used.
- **Avoid Disinformation** — don't use names that mislead (e.g. `accountList` when it's not a List).
- **Make Meaningful Distinctions** — `a1`/`a2` is noise; `source`/`destination` communicates.
- **Use Pronounceable Names** — if you can't say it, you can't discuss it.
- **Use Searchable Names** — single-letter names and magic numbers can't be found with grep.
- **Explain Yourself in Code** — prefer `isEligibleForFullBenefits()` over a comment.

## Kotlin Notes

- Kotlin's named parameters make intention even clearer than Java: `copyChars(source = src, destination = dst)`.
- Use `const val` for searchable named constants instead of magic numbers.

## Exercises

1. **getThem → getFlaggedCells**: Rename function and variables to reveal the minesweeper context.
2. **copyChars parameters**: Rename `a1`/`a2` to `source`/`destination`.
3. **checkEmployee**: Replace the comment with an intention-revealing function name.
