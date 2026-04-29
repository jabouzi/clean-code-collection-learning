package cleancoder.ch08_testing_strategies

object Solution {
    // Principle: Test Pyramid — system tests at top (few), unit tests at base (many)
    fun classifyTest(isolatesDependencies: Boolean, crossesProcessBoundary: Boolean, coversFullSystem: Boolean): TestType {
        return when {
            coversFullSystem -> TestType.SYSTEM
            crossesProcessBoundary -> TestType.INTEGRATION
            !isolatesDependencies -> TestType.COMPONENT
            else -> TestType.UNIT
        }
    }

    // Principle: QA Should Find Nothing — maintain a healthy pyramid with many unit tests
    fun isPyramidHealthy(unit: Int, component: Int, integration: Int, system: Int): Boolean {
        return unit > component && component > integration && integration > system
    }

    // Principle: QA escape rate measures how many bugs slip past QA to real users
    fun qaEscapeRate(bugsFoundByQa: Int, bugsFoundByUsers: Int): Double {
        return bugsFoundByUsers.toDouble() / (bugsFoundByQa + bugsFoundByUsers)
    }
}
