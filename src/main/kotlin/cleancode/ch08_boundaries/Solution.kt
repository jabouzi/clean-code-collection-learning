package cleancode.ch08_boundaries

// NOTE: SensorMap, Transmitter, and Sensor are defined at file scope in Exercise.kt (same package).
// Solution does not redefine them.

object Solution {
    // Principle: Learning Tests — write tests that verify your understanding of the
    // third-party API contract. If a new version breaks the contract, the test fails.
    fun verifyLoggerBehavior(messages: List<String>): Boolean =
        messages.all { it.isNotBlank() }
}

// Principle: Wrap Third-Party APIs — SensorMap hides the raw Map behind a typed interface,
// limiting the surface area of the dependency and making future replacements easy.
// Solution for SensorMap:
//   fun getById(id: String): Sensor? = sensors[id]
//   fun add(id: String, sensor: Sensor) { sensors[id] = sensor }

// Principle: Using Code That Does Not Yet Exist — define the interface we WISH we had
// so we can write code against it before the third-party implementation is available.
// Transmitter interface is defined at file scope in Exercise.kt.
