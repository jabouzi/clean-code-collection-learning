# Chapter 11: Systems

## Key Principles

- **Separate Construction from Use** — the startup process (building objects) is a concern distinct from the runtime logic that uses them. Use factories, DI containers, or main separators.
- **Dependency Injection** — let an external authority wire collaborators together; the object should receive its dependencies, never create them.
- **Factories** — when the application must control when an object is created (not just how), use the Abstract Factory pattern.
- **Cross-Cutting Concerns** — aspects like logging, security, and transactions span many modules. Use AOP-style techniques to keep them out of business logic.
- **Scaling Up** — clean separation of concerns is what allows a system to grow from simple to complex without a rewrite.

## Kotlin Notes

- Kotlin interfaces with `fun interface` (SAM) make lightweight factories trivial.
- Constructor injection (`class Foo(private val dep: Dep)`) is idiomatic Kotlin DI.
- Companion objects can serve as factories while keeping construction logic co-located.

## Exercises

1. **Application + ServiceFactory**: Implement `run()` by delegating to the injected factory — never construct `MyService` inline.
2. **OrderProcessor**: Implement `process()` using the injected `Database` — return true only if the order is found.
3. **isConcernSeparated**: Return true only when concurrency lives in its own dedicated class and business logic is free of threading code.
