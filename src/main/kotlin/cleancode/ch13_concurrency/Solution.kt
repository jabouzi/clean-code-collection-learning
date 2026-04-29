package cleancode.ch13_concurrency

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.atomic.AtomicInteger

object Solution {
    // Principle: Producer-Consumer — decouple what is produced from when it is consumed
    fun produceAndConsume(items: List<Int>): List<Int> {
        val queue = LinkedBlockingQueue<Int>(items.size + 1)
        val sentinel = Int.MIN_VALUE

        // Producer thread: enqueue all items then signal done
        val producer = Thread {
            items.forEach { queue.put(it) }
            queue.put(sentinel)
        }

        val result = mutableListOf<Int>()
        // Consumer thread: drain until sentinel
        val consumer = Thread {
            while (true) {
                val item = queue.take()
                if (item == sentinel) break
                result.add(item)
            }
        }

        producer.start()
        consumer.start()
        producer.join()
        consumer.join()
        return result
    }
}

// Principle: Use Thread-Safe Library Classes — AtomicInteger for lock-free counting
class ThreadSafeCounterSolution {
    private val count = AtomicInteger(0)
    fun increment(): Int = count.incrementAndGet()
    fun get(): Int = count.get()
}

// Principle: Limit Scope of Shared Data — return a read-only snapshot, never the mutable internals
class SensorRepositorySolution {
    private val sensors = mutableMapOf("a" to 1.0, "b" to 2.0)
    fun getSnapshot(): Map<String, Double> = HashMap(sensors)
}
