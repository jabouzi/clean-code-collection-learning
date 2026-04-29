# The Clean Coder — Chapter 7: Acceptance Testing

## Key Principles

- **Communication Eliminates Ambiguity** — The purpose of acceptance tests is not to test software; it is to eliminate ambiguity between the business and the developers.
- **Automated Acceptance Tests** — Acceptance tests must be automated. Manual acceptance testing is not repeatable and not trustworthy.
- **Given-When-Then** — The standard structure for expressing acceptance criteria. Removes ambiguity by making the precondition, action, and expected outcome explicit.
- **Business and QA Collaboration** — Business analysts write the "given" and "then"; QA writes the "when". Developers make the tests pass.
- **The Definition of Done** — A feature is done when all its acceptance tests pass. Not when the developer thinks it's done.
- **Avoid Ambiguity** — Every vague word in a requirement is a bug waiting to happen. Acceptance tests make vague requirements concrete.

## Given-When-Then Structure

```
Given: [precondition — system state before the action]
When:  [action — what the user or system does]
Then:  [expected outcome — what must be true after the action]
```

Example:
```
Given: a logged-in user
When:  the user clicks the logout button
Then:  the user is redirected to the login page
```

## The Professional Responsibility

Developers must:
1. Work with the business to define acceptance tests before implementation
2. Not start coding until acceptance tests are written
3. Ensure all acceptance tests pass before declaring done

## Kotlin Notes

- `indexOf()` + `substring()` is a clean way to parse structured text
- `isNotBlank()` is preferred over `isNotEmpty()` — it also catches whitespace-only strings
- `lowercase()` comparison for case-insensitive matching avoids locale issues

## Exercises

1. **parseScenario**: Parse a Given-When-Then text string into a typed `Scenario` data class with trimmed fields.
2. **isCompleteAcceptanceCriterion**: Validate that all three parts of an acceptance criterion are non-blank — incomplete criteria cause ambiguity.
3. **runAcceptanceTest**: Simulate acceptance test execution by checking whether actual system behavior contains the expected feature (case-insensitive).
