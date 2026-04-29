package cleancode.ch06_objects_and_data_structures

import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class ObjectsAndDataStructuresTest {

    @Test
    fun `getScratchFilePath delegates to ctxt instead of navigating internals`() {
        val ctxt = AppContext("/tmp")
        assertEquals("/tmp/Foo.tmp", subject.getScratchFilePath(ctxt, "Foo"))
    }

    @Test
    fun `Car getPercentFuelRemaining returns ratio of gallons to capacity`() {
        val car = subject.Car(gallons = 5.0, capacity = 10.0)
        assertEquals(0.5, car.getPercentFuelRemaining())
    }

    @Test
    fun `Square area returns side squared`() {
        val square = subject.Square(4.0)
        assertEquals(16.0, square.area())
    }

    @Test
    fun `Circle area returns PI times radius squared`() {
        val circle = subject.Circle(1.0)
        assertEquals(PI, circle.area(), absoluteTolerance = 1e-9)
    }
}
