# Chapter 6: Objects and Data Structures

## Key Principles

- **Data Abstraction** — expose behaviour, not representation. A `Vehicle` should report `getPercentFuelRemaining()`, not expose raw `gallons` and `capacity`. Callers are insulated from implementation details.
- **Data/Object Anti-Symmetry** — procedural code (data structures + functions) makes it easy to add new functions without changing existing types. OO code makes it easy to add new types without changing existing functions. Each style has a different axis of extension.
- **Law of Demeter (Train Wrecks)** — a method should only call methods on: itself, its arguments, objects it creates, or direct component objects. Avoid chains like `ctxt.getOptions().getScratchDir().getAbsolutePath()` — they expose the internals of collaborators.
- **DTOs vs Active Records** — a DTO (data class) is pure data with no business logic. An Active Record is a DTO with save/find methods. Never add business rules to either; put them in separate domain objects.

## Kotlin Notes

- Kotlin `data class` is the idiomatic DTO: `data class Point(val x: Double, val y: Double)`
- Extension functions let you add behaviour at the boundary without modifying the type, keeping the original type clean: `fun AppContext.createScratchFileStream(name: String) = ...`
- Use `interface` + `class` to achieve the Data/Object Anti-Symmetry: new shapes need only implement `area()`, no change to existing code.

## Exercises

1. **Train Wreck Fix (`getScratchFilePath`)**: Replace a chain of attribute navigations with a single method call on the context object — apply the Law of Demeter.
2. **Fuel Abstraction (`Car.getPercentFuelRemaining`)**: Expose a percentage instead of raw gallons to hide the internal representation from callers.
3. **Procedural → OO (`Shape.area`)**: Move `area()` into each shape via polymorphism so adding a new shape requires no `when`/`instanceof` changes elsewhere.
