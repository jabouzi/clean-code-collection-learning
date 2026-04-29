# Chapter 5: Formatting

## Key Principles

- **Newspaper Metaphor** — a source file should read like a newspaper: the headline (high-level concept) at the top, detail below. Public API before private helpers.
- **Vertical Openness** — blank lines separate distinct concepts; tightly related lines have no blank lines between them.
- **Vertical Density** — lines of code that are closely related should appear close together.
- **Vertical Distance** — concepts that are strongly related should be vertically close.
- **Dependent Functions Close Together** — callers appear just above their callees in the file.
- **Stepdown Rule** — the code reads top-to-bottom; each function is followed only by the functions it calls.
- **Horizontal Formatting** — keep lines short (team-agreed limit, typically 80–120 chars); never scroll right.
- **Team Rules** — the team agrees on a single style and everyone follows it. Tools (ktlint, IntelliJ formatter) enforce it.

## Kotlin Notes

- Kotlin's `ktlint` and IntelliJ's built-in formatter automate horizontal and vertical formatting rules.
- Trailing lambdas and single-expression functions (`fun foo() = bar()`) naturally keep related code close.

## Exercises

1. **correctDeclarationOrder**: Return `["publicApi", "helperCalledByApi", "privateDetail"]` — high-level first (newspaper metaphor).
2. **lineCompliance**: Calculate what fraction of lines respect the agreed maximum line length.
3. **followsStepDownRule**: Verify that in a call graph no function calls a function declared before it.
