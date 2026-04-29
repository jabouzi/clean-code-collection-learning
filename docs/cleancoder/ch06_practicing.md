# The Clean Coder — Chapter 6: Practicing

## Key Principles

- **Katas** — A kata is a set of programming exercises practiced repeatedly to build muscle memory. Like a musician's scales, they keep skills sharp.
- **Wasa** — Pairs of programmers practicing together, one writing tests and one making them pass, then swapping. Keeps skills sharp through friendly challenge.
- **Randori** — A group kata where one person codes at a time, passing the keyboard. Good for learning diverse approaches.
- **Broadening Experience** — Professionals do not let themselves become parochial. Learn different languages, frameworks, and problem domains.
- **Open Source** — Contributing to open source is one way to broaden experience and practice discipline outside a day job.
- **Practice Ethics** — You owe your employer 40 hours of productivity. The 20 hours you spend practicing on your own time is what you owe yourself.

## Classic Katas

| Kata | Purpose |
|---|---|
| **Bowling Score** | Complex state machine, frame counting, spares and strikes |
| **FizzBuzz** | Conditional logic, first kata for beginners |
| **Prime Factors** | TDD-driven incremental development |
| **Word Wrap** | String manipulation, edge cases |
| **Stack** | Data structure with clean API |

## Bowling Scoring Rules

- 10 frames per game
- **Strike** (all 10 pins on first roll): score is 10 + next two rolls as bonus
- **Spare** (all 10 pins across two rolls): score is 10 + next one roll as bonus
- **Open frame**: score is sum of two rolls, no bonus

## Kotlin Notes

- Use an index-based approach for bowling — `rollIndex` tracks position in the roll list
- `repeat(10)` is idiomatic for 10 frames
- `when` expression maps cleanly to FizzBuzz's mutually exclusive conditions

## Exercises

1. **bowlingScore**: Implement a full bowling scorer supporting strikes, spares, and open frames including the bonus roll in frame 10.
2. **fizzBuzz**: Implement the FizzBuzz kata — a warm-up exercise every professional should be able to write from memory.
3. **isPracticed**: Determine whether a kata has been repeated enough times (>= 10) to build genuine muscle memory.
