# Chapter 12: Collaboration

## Key Principles
- **Programming is a Team Sport** — software is not a solitary activity; professionals collaborate, share knowledge, and care about the whole codebase
- **Pair Programming** — two developers at one keyboard; the driver writes code while the navigator reviews in real time; switch roles regularly (every 25–30 minutes); detects defects immediately; spreads knowledge
- **Collective Code Ownership** — no section of the codebase belongs to one person; everyone can and should improve any part; prevents knowledge silos and single points of failure
- **Continuous Review** — code review is most effective when continuous (via pairing or short review cycles), not a batch gate at end of sprint
- **Actionable Feedback** — review comments should be specific and constructive, not vague reactions

## Kotlin Notes
- `data class PairSession` is defined at file level (not inside the object) — data classes as parameters/return types belong outside object scope
- `contains(' ')` is a simple proxy for "has multiple words" — a substantive sentence has spaces
- Ratio comparison (`toDouble() / total >= 0.5`) avoids integer division pitfalls

## Exercises
1. **shouldSwitch**: Decide when to rotate driver/navigator roles in a pair programming session — switch at 30-minute intervals
2. **isCollectiveOwnership**: Check whether code ownership is distributed across at least half the team
3. **isActionableFeedback**: Validate that a code review comment is substantive enough to act on
