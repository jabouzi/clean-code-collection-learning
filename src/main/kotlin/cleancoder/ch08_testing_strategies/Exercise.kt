package cleancoder.ch08_testing_strategies

enum class TestType { UNIT, COMPONENT, INTEGRATION, SYSTEM }

object Exercise {
    // Exercise 1: Classify a test by its characteristics
    fun classifyTest(isolatesDependencies: Boolean, crossesProcessBoundary: Boolean, coversFullSystem: Boolean): TestType {
        TODO("""
            Apply test pyramid classification:
            coversFullSystem -> SYSTEM
            crossesProcessBoundary -> INTEGRATION
            !isolatesDependencies -> COMPONENT
            else -> UNIT
        """)
    }

    // Exercise 2: Is the test pyramid healthy? (unit >> component >> integration >> system)
    fun isPyramidHealthy(unit: Int, component: Int, integration: Int, system: Int): Boolean {
        TODO("Return true if unit > component > integration > system — pyramid shape")
    }

    // Exercise 3: Calculate QA escape rate
    fun qaEscapeRate(bugsFoundByQa: Int, bugsFoundByUsers: Int): Double {
        TODO("Return bugsFoundByUsers.toDouble() / (bugsFoundByQa + bugsFoundByUsers) — goal is 0.0")
    }
}
