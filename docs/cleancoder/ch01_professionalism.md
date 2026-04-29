# The Clean Coder — Chapter 1: Professionalism

## Key Principles

- **Take Responsibility** — Professionals own their mistakes. Shipping a bug and having it cause damage means taking responsibility for the harm done.
- **Do No Harm to Function** — Your code must work. Test it. Know it works before you ship it.
- **Do No Harm to Structure** — The code must remain flexible and clean. Never let it rot.
- **100% Test Coverage** — The only way to know your code works is to test every line. Professionals aim for 100%.
- **Boy Scout Rule** — Always leave the code cleaner than you found it. Small continuous improvements prevent rot.
- **Work Ethic** — Your career is your responsibility. Invest 20 hours per week outside of work to stay current.

## The Cost of Bugs

Bugs shipped to production are not just technical debt — they carry a real cost:
- Developer time to diagnose and fix
- Customer time lost while the bug affects them
- Reputation damage to the team and company

A professional owns these costs rather than deflecting blame.

## Kotlin Notes

- Use `data class` for value types like `CodeMetrics` to get equality semantics for free
- `Double` division handles coverage ratios naturally — be aware of integer division traps

## Exercises

1. **bugCost**: Calculate the total cost of a bug to the team — developer fix time plus customer impact time, all at the hourly rate.
2. **isCodeCleaner**: Apply the Boy Scout Rule — verify that both warnings decreased and average function length shortened after a change.
3. **isProfessionalCoverage**: Check whether test coverage meets the professional standard of 100% (a ratio of 1.0).
