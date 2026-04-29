package cleancode.ch13_concurrency

object Exercise {
    // Exercise 3: Producer-consumer handoff using a blocking queue
    fun produceAndConsume(items: List<Int>): List<Int> {
        TODO("Put items into LinkedBlockingQueue, drain from another thread, return consumed list")
    }
}

// Exercise 1: Thread-safe counter using AtomicInteger
class ThreadSafeCounter {
    private val count = java.util.concurrent.atomic.AtomicInteger(0)
    fun increment(): Int = TODO("Atomically increment and return new value")
    fun get(): Int = TODO("Return current value")
}

// Exercise 2: Limit scope — return immutable copy, not reference to mutable shared state
class SensorRepository {
    private val sensors = mutableMapOf("a" to 1.0, "b" to 2.0)
    fun getSnapshot(): Map<String, Double> = TODO("Return unmodifiable copy of sensors")
}
