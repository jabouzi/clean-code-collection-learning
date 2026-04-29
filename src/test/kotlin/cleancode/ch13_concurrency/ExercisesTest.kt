package cleancode.ch13_concurrency

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class ConcurrencyTest {

    @Test
    fun `thread safe counter increments atomically`() {
        // ThreadSafeCounter is at package level — instantiate directly
        val counter = ThreadSafeCounter()
        assertEquals(1, counter.increment())
    }

    @Test
    fun `thread safe counter get returns current value`() {
        val counter = ThreadSafeCounter()
        counter.increment()
        counter.increment()
        assertEquals(2, counter.get())
    }

    @Test
    fun `sensor repository snapshot returns correct values`() {
        val snapshot = SensorRepository().getSnapshot()
        assertEquals<Double?>(1.0, snapshot["a"])
        assertEquals<Double?>(2.0, snapshot["b"])
    }

    @Test
    fun `sensor repository snapshot is an independent copy`() {
        val repo = SensorRepository()
        val snap1 = repo.getSnapshot()
        // Modifying the snapshot should not affect subsequent snapshots
        val mutableSnap = snap1.toMutableMap()
        mutableSnap["a"] = 99.0
        val snap2 = repo.getSnapshot()
        assertEquals<Double?>(1.0, snap2["a"])
    }

    @Test
    fun `produceAndConsume returns all items`() {
        val result = subject.produceAndConsume(listOf(1, 2, 3))
        assertEquals(3, result.size)
        assertTrue(result.containsAll(listOf(1, 2, 3)))
    }
}
