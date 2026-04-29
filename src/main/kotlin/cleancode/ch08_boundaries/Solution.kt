package cleancode.ch08_boundaries

object Solution {
    // Principle: Wrap Third-Party APIs — SensorMap hides the raw Map behind a typed interface,
    // limiting the surface area of the dependency and making future replacements easy.
    class SensorMap {
        private val sensors = mutableMapOf<String, Sensor>()

        // Principle: Encapsulation — callers get a typed result or null, never a raw map
        fun getById(id: String): Sensor? = sensors[id]

        fun add(id: String, sensor: Sensor) {
            sensors[id] = sensor
        }
    }

    // Principle: Using Code That Does Not Yet Exist — define the interface we WISH we had
    // so we can write code against it before the third-party implementation is available.
    interface Transmitter {
        fun transmit(frequency: Double, stream: String): Boolean
    }

    // Principle: Learning Tests — write tests that verify your understanding of the
    // third-party API contract. If a new version breaks the contract, the test fails.
    fun verifyLoggerBehavior(messages: List<String>): Boolean =
        messages.all { it.isNotBlank() }
}
