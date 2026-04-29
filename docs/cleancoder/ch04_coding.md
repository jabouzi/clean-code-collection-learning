# The Clean Coder — Chapter 4: Coding

## Key Principles

- **Preparedness** — Only code when you are mentally ready. Tired, anxious, or distracted coding produces errors that take far longer to fix than the time saved by pushing through.
- **Flow Is Overrated** — The "zone" feels productive but often produces code that needs to be undone. Prefer a state of steady focus over manic flow.
- **Manage Interruptions** — Use TDD and clean code to make stopping and restarting safe. Tests tell you where you were.
- **Writer's Block** — If you can't code, pair with someone. Creative input from a partner breaks logjams.
- **Debug Systematically** — Binary search the problem space. Don't guess; bisect.
- **Be Honest About Lateness** — Do not create false hope. Give accurate estimates. Do not say "I'll try" when the math says you won't make it.
- **Pacing** — Software development is a marathon. Know when to stop and rest.

## The Ready-to-Code Checklist

Before sitting down to write code, verify:
1. Are you rested?
2. Have you understood the requirements?
3. Are you free from significant distraction?

## Binary Search Debugging

Instead of reading code linearly looking for a bug:
1. Split the suspect range in half
2. Determine which half contains the bug
3. Repeat until found

This reduces O(n) investigation to O(log n) steps.

## Kotlin Notes

- Boolean logic with `&&` and `!` maps cleanly to the ready-to-code check
- For binary search, track `lo` and `hi` with a step counter

## Exercises

1. **isReadyToCode**: Check all three preparedness conditions — must be rested, must understand requirements, must not be distracted.
2. **estimateRemaining**: Use linear extrapolation to estimate remaining work — honest arithmetic beats optimistic guessing.
3. **binarySearchBug**: Count the binary search steps to locate a bug in a range — demonstrates O(log n) debugging discipline.
