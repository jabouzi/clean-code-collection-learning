# The Clean Coder — Chapter 2: Saying No

## Key Principles

- **Adversarial Roles Are Healthy** — Managers push for features and timelines; developers push back on unrealistic expectations. This tension produces good outcomes.
- **Courage** — The most important thing a professional can do is have the courage to say no when the answer is no.
- **"I'll Try" Is a Lie** — Saying "I'll try" implies you have a reserve of effort you haven't committed yet. If you don't, you're misleading the stakeholder.
- **No Is Temporary, Yes Is a Commitment** — Saying no opens a conversation. Saying yes creates an obligation.
- **Find Common Ground** — A professional no is followed by a search for what IS possible. Negotiation matters.

## Weasel Words

These words signal that a commitment is not real:
- "try" — implies possible failure is acceptable
- "maybe" — not a commitment at all
- "should" — intention without obligation
- "might" — conditional and non-committal
- "hope" — wishful thinking, not planning

## Kotlin Notes

- `List.none { }` is a clean way to check that none of a set of conditions matches
- `lowercase()` before comparison avoids case-sensitivity bugs in word matching

## Exercises

1. **isRealCommitment**: Detect weasel words that make a statement non-committal.
2. **negotiate**: Find the midpoint between developer and manager estimates — professionals find common ground rather than simply capitulating.
3. **costOfYes**: Quantify what happens when you say yes beyond your capacity — it causes disaster, not just inconvenience.
