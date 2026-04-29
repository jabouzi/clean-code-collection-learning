# Chapter 8: Testing Strategies

## Key Principles
- **Test Pyramid** — the vast majority of tests should be unit tests; integration and system tests form a much smaller upper layer
- **QA Should Find Nothing** — if QA is regularly finding bugs, the developer's testing is insufficient; professional developers ensure QA has nothing to find
- **Test Layers**:
  - **Unit Tests** — written by programmers, for programmers; test individual functions/classes in isolation; ~100% of code
  - **Component Tests** — test components (subsystems) through their API; written by QA with developer assistance; ~50% of system
  - **Integration Tests** — test how components choreograph together; test wiring, not business rules; ~20% of system
  - **System Tests** — end-to-end tests of the entire integrated system; ~10% of system
  - **Exploratory Tests** — manual, creative testing to find unexpected behaviours

## Kotlin Notes
- Use `enum class` for classifying test types — exhaustive `when` expressions make intent clear
- Sealed classes can model test result states (pass/fail/error) more expressively than booleans
- `kotlin.test` library integrates with JUnit 5 for all test layers

## Exercises
1. **classifyTest**: Classify a test by its characteristics (isolatesDependencies, crossesProcessBoundary, coversFullSystem) into the correct test pyramid layer
2. **isPyramidHealthy**: Verify that test counts form a proper pyramid shape (unit > component > integration > system)
3. **qaEscapeRate**: Calculate the proportion of bugs that escaped QA and were found by users — the lower this number, the healthier the QA process
