# Chapter 8: Boundaries

## Key Principles

- **Wrap Third-Party APIs** — never scatter raw third-party types throughout your codebase. Wrap them behind a narrow interface you control. If the library changes, only the wrapper changes.
- **Learning Tests** — write focused tests that verify your understanding of the third-party API. They document your assumptions and alert you to breaking changes in future versions.
- **Using Code That Does Not Yet Exist** — define the interface you *wish* you had before the external team delivers the real implementation. Write your code against the interface; stub it for tests.
- **Clean Boundaries** — keep third-party knowledge at the edges. The rest of your system should only know about your own abstractions.

## Kotlin Notes

- A `class` wrapping a `mutableMapOf` is the idiomatic way to provide a typed boundary: expose typed `get`/`add` rather than a raw `MutableMap<K, V>`.
- Kotlin `interface` is lightweight — define the interface you wish you had with zero boilerplate.
- Learning tests in kotlin.test look exactly like regular unit tests; use descriptive names that document the contract being verified.

## Exercises

1. **SensorMap** — wrap `mutableMapOf<String, Sensor>` so callers get a typed `getById(id)` → `Sensor?` and an `add()`, never a raw map reference.
2. **Transmitter interface** — define the interface for a dependency that does not exist yet so the rest of the code can be written and tested without the real implementation.
3. **verifyLoggerBehavior** — write a learning test that verifies the third-party logger contract (all messages are non-blank), documenting the assumption and catching future regressions.
