package cleancoder.ch14_mentoring_apprenticeship_craftsmanship

object Solution {
    // Principle: Craftsmanship Manifesto — progression from apprentice → journeyman → master
    fun assessLevel(yearsExperience: Int, hasMentored: Boolean, contributesToOss: Boolean): CraftsmanshipLevel {
        return when {
            yearsExperience >= 10 && hasMentored && contributesToOss -> CraftsmanshipLevel.MASTER
            yearsExperience >= 5 && (hasMentored || contributesToOss) -> CraftsmanshipLevel.JOURNEYMAN
            else -> CraftsmanshipLevel.APPRENTICE
        }
    }

    // Principle: Mentoring multiplies value — the hours invested in a mentee pay dividends for their entire career
    fun mentoringReturn(hoursMentored: Double, menteeProductivityGain: Double): Double {
        return hoursMentored * menteeProductivityGain
    }

    // Principle: Craftsmanship = well-crafted software + steady addition of value + community + productive partnerships
    fun demonstratesCraftsmanship(refactorsOpportunistically: Boolean, writesTestsFirst: Boolean, sharesKnowledge: Boolean): Boolean {
        return refactorsOpportunistically && writesTestsFirst && sharesKnowledge
    }
}
