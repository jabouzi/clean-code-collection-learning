# The Clean Coder — Chapter 3: Saying Yes

## Key Principles

- **Language of Commitment** — Real commitment has three parts: say it, mean it, do it.
- **The Words of Commitment** — "I will X by Y" is commitment. "We should", "I'll try", "Let's" are not.
- **Recognise What Stops You** — Dependencies, unclear requirements, personal overcommitment all block real commitment. Identify them explicitly.
- **Raise Concerns Early** — If you know you might miss a commitment, raise the concern immediately — not at the deadline.
- **Commit Only to What You Can Do** — A partial commitment to what IS achievable is more valuable than a full commitment that will be broken.

## The Three Parts of Commitment

1. **Say it** — Make the commitment explicitly and publicly.
2. **Mean it** — Believe you can and will do it when you say it.
3. **Do it** — Follow through regardless of obstacles (or raise concerns early if obstacles appear).

## Commitment Language Examples

| Non-commitment | Commitment |
|---|---|
| "We should get this done" | "I will have this done by Friday" |
| "I'll try to finish it" | "I am going to complete this today" |
| "Let's see if we can..." | "I will deliver X by Y" |

## Kotlin Notes

- `startsWith()` is the right tool for matching commitment prefixes
- `intersect()` on sets gives you the clean mathematical intersection for partial commitment logic

## Exercises

1. **usesCommitmentLanguage**: Identify whether a statement uses true commitment language ("I will" / "I am going to").
2. **resolveBlocker**: Given a type of blocker (dependency, unclear requirements, unknown), return the professional response.
3. **partialCommitment**: From two lists (what you can deliver, what was requested), return only what you can actually commit to.
