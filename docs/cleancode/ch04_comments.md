# Chapter 4: Comments

## Key Principles

- **Comments Are Failures** — a comment is an admission that the code fails to express itself.
- **Explain Yourself in Code** — prefer a well-named function or constant over a comment that describes what the code does.
- **Good Comments** — legal notices, warnings, TODO markers, amplification of non-obvious intent.
- **Bad Comments** — redundant comments that repeat what the code already says.
- **Misleading Comments** — comments that are imprecise or wrong are worse than no comment.
- **Noise Comments** — `// Gets the customer name` above `getCustomerName()` adds zero value.
- **Commented-Out Code** — delete it; version control remembers history.

## Kotlin Notes

- Named top-level constants (`val TIMESTAMP_PATTERN = Regex(...)`) self-document regex patterns — no comment needed.
- Kotlin's expressive type system (sealed classes, extension functions) often makes intent obvious without prose.

## Exercises

1. **check → isEligibleForFullBenefits**: Replace the explanatory comment with a function rename.
2. **isValidTimestamp**: Extract the regex to a named constant `TIMESTAMP_PATTERN` to make the comment redundant.
3. **getCustomerName**: Rewrite without any comments — the function name says everything.
