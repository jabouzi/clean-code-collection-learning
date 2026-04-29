# Chapter 10: Classes

## Key Principles

- **Small (Measure by Responsibilities)** — classes should be small, but the measure is *responsibilities*, not lines of code. A class with one responsibility has one reason to change.
- **Single Responsibility Principle (SRP)** — a class should have one, and only one, reason to change. `SuperDashboard` mixing version tracking with focus tracking violates SRP.
- **Cohesion** — a class is maximally cohesive when every method uses every instance variable. When cohesion drops, the class is ready to be split.
- **Open-Closed Principle (OCP)** — classes should be open for extension but closed for modification. Polymorphism lets new behaviour be added without touching existing code.
- **Isolating from Change** — depend on abstractions (interfaces), not concretions. This makes classes robust to change and easy to test in isolation.

## Kotlin Notes

- Kotlin `data class` enforces cohesion by design: every generated method (`equals`, `hashCode`, `copy`) uses all declared properties.
- `interface` + `class` implements OCP cleanly — add a new class implementing the interface without changing anything else.
- `internal` visibility restricts a class to its Gradle module — useful for hiding implementation details at module boundaries.
- Kotlin `object` is a natural fit for stateless utility groupings; avoid turning it into a responsibility grab-bag.

## Exercises

1. **countResponsibilities** — group related methods by concern and count distinct responsibilities: version methods form one group, widget methods another.
2. **cohesionScore** — calculate the ratio of methods that use all instance variables; a score close to 1.0 signals a focused, well-designed class.
3. **DashboardVersion / DashboardFocus** — split the monolithic `SuperDashboard` into two focused classes, each with exactly one reason to change.
