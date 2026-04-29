# Chapter 9: Time Management

## Key Principles
- **Meetings are necessary but costly** — attend only those that are directly relevant to you: agenda provided, your presence genuinely required, and kept short
- **Focus/Mana** — concentration is a finite resource; once depleted it takes time to restore; guard it fiercely
- **Avoid Blind Alleys** — know when to abandon an approach; don't let sunk-cost fallacy keep you stuck; set a time-box
- **Marshes and Messes** — messes look like swamps: you sink in slowly; recognise when you're in one and get out; clean code is faster code
- **Pomodoro Technique** — work in 25-minute focused intervals with short breaks; helps maintain concentration and measure true throughput

## Kotlin Notes
- Short-circuit boolean logic (`&&`) maps cleanly to attendance policies
- Default parameters (e.g., `overhead: Double = 0.5`) model sensible defaults without overloads
- `==` on `Int` for exact Pomodoro duration check is intentional — 24 and 26 are not valid

## Exercises
1. **shouldAttend**: Decide whether to attend a meeting based on agenda, required presence, and duration — professionals protect their time
2. **focusHoursRemaining**: Calculate remaining focused work hours after accounting for meetings and overhead — a daily focus budget
3. **isValidPomodoro**: Validate that a work session follows the Pomodoro standard of exactly 25 minutes
