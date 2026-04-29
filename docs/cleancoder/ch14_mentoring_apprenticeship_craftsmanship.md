# Chapter 14: Mentoring, Apprenticeship, and Craftsmanship

## Key Principles
- **Craftsmanship Manifesto** — "Not only working software, but also well-crafted software. Not only responding to change, but also steadily adding value. Not only individuals and interactions, but also a community of professionals. Not only customer collaboration, but also productive partnerships."
- **Apprenticeship** — formal learning under a master; school teaches theory but not the craft; the craft is learned on the job under guidance
- **Three Stages of Craftsmanship**:
  - **Apprentice** — learning the craft under supervision; quality is variable; needs pairing and review
  - **Journeyman** — competent and growing; works independently; beginning to mentor others or contribute to the community
  - **Master** — deep expertise; actively mentors; gives back to the profession through writing, speaking, OSS, or community leadership
- **Mentoring Value** — time invested in a mentee multiplies in value over their career; a master who mentors 10 developers compounds their impact enormously
- **School vs Craft** — universities teach computer science (theory, algorithms, architecture); they do not teach software craftsmanship (TDD, refactoring, clean code, estimation, collaboration)

## Kotlin Notes
- `enum class CraftsmanshipLevel` is defined at file scope (not inside the object) so it can be referenced in both `Exercise` and `Solution`
- `when` expression with compound conditions (`&&`, `||`) maps cleanly to the three-tier level assessment
- All three are `true` for craftsmanship: `&&` is the right operator — one missing discipline breaks the whole

## Exercises
1. **assessLevel**: Classify a developer's craftsmanship level (APPRENTICE / JOURNEYMAN / MASTER) based on experience, mentoring history, and OSS contributions
2. **mentoringReturn**: Calculate the return on mentoring investment — hours mentored multiplied by the mentee's productivity gain
3. **demonstratesCraftsmanship**: Verify all three craftsmanship disciplines are present: opportunistic refactoring, test-first development, and knowledge sharing
