# Chapter 12: Emergence

## Key Principles (Kent Beck's 4 Rules of Simple Design)

1. **Passes All Tests** — a system that cannot be verified cannot be trusted; testability drives good design.
2. **No Duplication** — duplication is the primary enemy of a well-designed system. Use Template Method, strategy, or extraction to eliminate it.
3. **Expresses Intent** — the code should clearly communicate the programmer's intent. Choose expressive names (`primaryTermination` vs `isPT`), use standard patterns, write expressive unit tests.
4. **Minimizes Classes and Methods** — don't create extra classes/methods just to satisfy some rule. Merge trivially thin abstractions. Dogma is the enemy of pragmatism.

## Kotlin Notes

- Abstract classes with a concrete `render()` that calls abstract hooks are a clean Template Method in Kotlin.
- `String.reversed()` and `String.endsWith()` make string utilities concise.
- Kotlin's `==` on strings is structural equality — no need for `.equals()`.

## Exercises

1. **HtmlRenderer**: Implement `render()` in `BaseRenderer` as `header() + body(data) + footer()`, and fill in each HTML fragment method.
2. **primaryTermination**: Return `s.endsWith(".")` — the expressive name makes the comment unnecessary.
3. **StringUtils**: Implement `reverse()` with `s.reversed()` and `isPalindrome()` with `s == s.reversed()` — one class, two related utilities, no bloat.
