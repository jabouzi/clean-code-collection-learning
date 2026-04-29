package cleancode.ch11_systems

object Exercise {
    // Exercise 1: Separate construction — use a factory instead of new inside logic
    class Application(private val factory: ServiceFactory) {
        fun run(): String = TODO("Call factory.makeService().execute() — don't construct directly")
    }

    // Exercise 2: DI — inject the dependency instead of creating it
    class OrderProcessor(private val db: Database) {
        fun process(orderId: Int): Boolean = TODO("Call db.find(orderId) != null")
    }

    // Exercise 3: Naive scaling — show that single-thread concern and concurrency concern are separate
    fun isConcernSeparated(hasDedicatedThreadClass: Boolean, businessLogicHasThreadCode: Boolean): Boolean {
        TODO("Return true only if dedicated thread class exists AND business logic has no thread code")
    }
}

interface ServiceFactory { fun makeService(): MyService }
interface MyService { fun execute(): String }
interface Database { fun find(id: Int): Any? }
