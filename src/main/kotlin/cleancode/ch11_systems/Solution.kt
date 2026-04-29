package cleancode.ch11_systems

// NOTE: Application, OrderProcessor, ServiceFactory, MyService, Database are defined in Exercise.kt
// (same package). Solution provides its own named versions below for the solution implementations.

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
