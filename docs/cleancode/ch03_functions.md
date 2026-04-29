# Chapter 3: Functions

## Key Principles

- **Small** — functions should be small; ideally 5–10 lines, rarely more than 20.
- **Do One Thing** — a function should do one thing, do it well, do it only.
- **One Level of Abstraction** — don't mix high-level policy and low-level detail in one function.
- **Step-Down Rule** — code should read like a top-down narrative; each function is followed by the ones it calls.
- **Few Arguments** — niladic (0) is best, monadic (1) is fine, dyadic (2) requires care, triadic (3) needs justification.
- **No Side Effects** — a function should not secretly change state when it appears to be a query.
- **Command-Query Separation** — functions either do something (command) or answer something (query), not both.
- **Replace Switch with Polymorphism** — use sealed classes / when expressions rather than string dispatch.

## Kotlin Notes

- Kotlin sealed classes give exhaustive `when` expressions — the compiler enforces all cases are handled.
- Extension functions let you add behaviour to classes without modifying them, keeping functions small and focused.
- Named parameters and default values reduce the need for overloaded variants.

## Exercises

1. **renderPageWithSetupsAndTeardowns**: Split a monolithic render function into `isTestPage()`, `includeSetupPages()`, and `includeContent()`.
2. **calculatePay**: Replace a string-based switch with proper `when` dispatch (or sealed class polymorphism).
3. **setAndReturnAttribute**: Demonstrate Command-Query Separation — set a value AND report prior existence as a deliberate combined operation.
