# Chapter 13: Teams and Projects

## Key Principles
- **Team Jell** — a gelled team is a powerful force; they have trust, shared goals, and open communication; jelled teams are rare and must be protected
- **Team Velocity** — measure throughput using recent sprint history; the last 3 sprints are the best predictor of the next; older data is less relevant
- **Fractured Teams** — assigning developers to too many simultaneous projects destroys focus, collaboration, and gel; a team spread across many projects is no longer a team
- **Team Players** — a professional developer works as part of a team: writes code others can maintain, communicates blockers, helps unblock colleagues, and does not create knowledge silos
- **Project Ownership** — a team should own their project end-to-end; rotating people in and out mid-project disrupts gel and degrades quality

## Kotlin Notes
- `takeLast(3)` is the idiomatic Kotlin way to get the last N elements of a list without index arithmetic
- `sum().toDouble() / size` avoids integer division when computing averages
- All three exercises use simple scalar conditions that map naturally to `&&` and `>` comparisons

## Exercises
1. **teamVelocity**: Calculate the rolling 3-sprint average velocity — use `takeLast(3)` and fall back to all sprints if fewer than 3 exist
2. **isGelled**: Determine if a team has achieved gel — requires a shared goal, high trust (≥7), and strong communication (≥7)
3. **isFractured**: Detect when a team is spread too thin — more than 2 simultaneous projects per developer is a danger sign
