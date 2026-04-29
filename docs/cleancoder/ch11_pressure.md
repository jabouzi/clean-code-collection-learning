# Chapter 11: Pressure

## Key Principles
- **Avoid Pressure by Keeping Code Clean** — messy code is the primary source of pressure; the best way to avoid pressure is to avoid creating the mess in the first place
- **Don't Abandon Disciplines Under Pressure** — the temptation to skip TDD or skip cleaning under deadline is exactly wrong; disciplines are most valuable when you feel you cannot afford them
- **Communicate Early** — when you see a deadline at risk, raise it immediately; managers need honest, early information to respond effectively
- **Don't Be a Hero** — the desire to "save the day" by working heroic hours and skipping discipline leads to catastrophe
- **Technical Debt Compounds** — each shortcut increases complexity; the next shortcut becomes more costly; debt grows non-linearly

## Kotlin Notes
- Unconditional `return false` for `shouldAbandonTdd` is intentional — the principle has no exceptions
- `when` expressions in Kotlin are exhaustive and expressive for mapping problem categories to professional responses
- Quadratic growth (`shortcuts * multiplier * shortcuts`) models how technical debt accelerates

## Exercises
1. **shouldAbandonTdd**: Recognise that TDD should never be abandoned under pressure — it is how you get out of pressure, not into it
2. **crisisResponse**: Model professional responses to common crisis scenarios — communicate, keep discipline, look for scope reduction
3. **debtAccumulated**: Demonstrate that technical debt grows quadratically with shortcuts — each shortcut makes the next one more expensive
