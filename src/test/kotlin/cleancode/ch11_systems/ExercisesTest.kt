package cleancode.ch11_systems

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

// ─── Swap this line to check against the solution ─────────────────────────────
val subject = Exercise   // ← your work (default)
// val subject = Solution  // ← reference answer
// ──────────────────────────────────────────────────────────────────────────────

class SystemsTest {

    // Note: Application and OrderProcessor are at file scope — construct them directly.
    // Only isConcernSeparated is dispatched through `subject` (pure function, no class instantiation needed)

    @Test
    fun `application delegates service creation to factory`() {
        val factory = object : ServiceFactory {
            override fun makeService(): MyService = object : MyService {
                override fun execute(): String = "ok"
            }
        }
        val app = Application(factory)
        assertEquals("ok", app.run())
    }

    @Test
    fun `orderProcessor returns true when order exists`() {
        val db = object : Database {
            override fun find(id: Int): Any? = if (id == 1) "order" else null
        }
        val processor = OrderProcessor(db)
        assertTrue(processor.process(1))
    }

    @Test
    fun `orderProcessor returns false when order does not exist`() {
        val db = object : Database {
            override fun find(id: Int): Any? = null
        }
        val processor = OrderProcessor(db)
        assertFalse(processor.process(99))
    }

    @Test
    fun `concern is separated when dedicated thread class exists and business logic is clean`() {
        assertTrue(subject.isConcernSeparated(hasDedicatedThreadClass = true, businessLogicHasThreadCode = false))
    }

    @Test
    fun `concern is not separated when business logic contains thread code`() {
        assertFalse(subject.isConcernSeparated(hasDedicatedThreadClass = true, businessLogicHasThreadCode = true))
    }

    @Test
    fun `concern is not separated when no dedicated thread class exists`() {
        assertFalse(subject.isConcernSeparated(hasDedicatedThreadClass = false, businessLogicHasThreadCode = false))
    }
}
