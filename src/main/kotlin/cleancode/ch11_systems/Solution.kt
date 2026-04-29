package cleancode.ch11_systems

object Solution {
    // Principle: Separation of Concerns — concurrency lives in its own class
    fun isConcernSeparated(hasDedicatedThreadClass: Boolean, businessLogicHasThreadCode: Boolean): Boolean =
        hasDedicatedThreadClass && !businessLogicHasThreadCode
}

// Principle: Separate Construction from Use — factory handles object creation
class ApplicationSolution(private val factory: ServiceFactory) {
    fun run(): String = factory.makeService().execute()
}

// Principle: Dependency Injection — inject collaborators, don't create them
class OrderProcessorSolution(private val db: Database) {
    fun process(orderId: Int): Boolean = db.find(orderId) != null
}
