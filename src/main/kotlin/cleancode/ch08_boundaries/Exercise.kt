package cleancode.ch08_boundaries

// ── File-scope types shared between Exercise and Solution ──────────────────────

// Exercise 1: Wrap a raw Map to provide a safe, typed boundary
class SensorMap {
    private val sensors = mutableMapOf<String, Sensor>()
    fun getById(id: String): Sensor? = TODO("Return sensor or null — don't expose raw map")
    fun add(id: String, sensor: Sensor): Unit = TODO("Delegate to internal map")
}

// Exercise 2: Define an interface for a dependency that doesn't exist yet
interface Transmitter {
    fun transmit(frequency: Double, stream: String): Boolean
}

// ──────────────────────────────────────────────────────────────────────────────

object Exercise {
    // Exercise 3: Write a learning test — verify your understanding of the boundary
    fun verifyLoggerBehavior(messages: List<String>): Boolean {
        TODO("Return true if all messages are non-blank (simulates verifying 3rd-party logger contract)")
    }
}

data class Sensor(val id: String, val value: Double)
