# Chapter 10: Estimation

## Key Principles
- **Business vs Developer Estimates** — businesses treat estimates as commitments; developers know they are guesses; the professional makes this distinction explicit
- **PERT (Program Evaluation and Review Technique)** — provide three estimates: optimistic (O), nominal (N), pessimistic (P); expected = (O + 4N + P) / 6
- **Standard Deviation** — σ = (P - O) / 6; quantifies the uncertainty in the estimate
- **Confidence Ranges** — commit to a range (e.g., µ ± 2σ for ~95% confidence) rather than a single point estimate
- **Wideband Delphi** — collaborative estimation technique where multiple experts estimate independently, then discuss disagreements; reduces individual bias
- **Flying Fingers / Planning Poker** — team simultaneously reveals estimates; disagreements spark valuable conversation about unknowns

## Kotlin Notes
- Use `absoluteTolerance` in `kotlin.test.assertEquals` when comparing `Double` values — floating point arithmetic accumulates small errors
- `Pair<Double, Double>` is an appropriate return type for a confidence range; `data class Range(val low: Double, val high: Double)` is more expressive for production code

## Exercises
1. **pertExpected**: Calculate the PERT expected duration from optimistic, nominal, and pessimistic estimates using the weighted average formula
2. **pertStdDev**: Calculate the PERT standard deviation — one sixth of the pessimistic-to-optimistic spread
3. **confidenceRange**: Compute a 95% confidence interval as expected ± 2 standard deviations
