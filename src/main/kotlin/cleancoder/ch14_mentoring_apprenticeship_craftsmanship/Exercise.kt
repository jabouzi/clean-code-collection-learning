package cleancoder.ch14_mentoring_apprenticeship_craftsmanship

enum class CraftsmanshipLevel { APPRENTICE, JOURNEYMAN, MASTER }

object Exercise {
    // Exercise 1: Craftsmanship level assessment
    fun assessLevel(yearsExperience: Int, hasMentored: Boolean, contributesToOss: Boolean): CraftsmanshipLevel {
        TODO("""
            MASTER: yearsExperience >= 10 AND hasMentored AND contributesToOss
            JOURNEYMAN: yearsExperience >= 5 AND (hasMentored OR contributesToOss)
            APPRENTICE: otherwise — keep learning, keep practicing
        """)
    }

    // Exercise 2: Mentoring value — time invested in mentee
    fun mentoringReturn(hoursMentored: Double, menteeProductivityGain: Double): Double {
        TODO("Return hoursMentored * menteeProductivityGain — investment that compounds over a career")
    }

    // Exercise 3: Craftsmanship manifesto — does this behavior reflect craftsmanship?
    fun demonstratesCraftsmanship(refactorsOpportunistically: Boolean, writesTestsFirst: Boolean, sharesKnowledge: Boolean): Boolean {
        TODO("Return true if ALL three are true — craftsmanship requires all three disciplines together")
    }
}
