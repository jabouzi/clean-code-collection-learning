# Chapter 13: Concurrency

## Key Principles

- **Decouple What from When** — concurrency allows what is computed to be separated from when it is computed; this can improve throughput and structure.
- **Shared Data is the Root of All Concurrency Evil** — limit the number of places where shared data can be modified. Prefer immutable objects.
- **Limit Scope of Shared Data** — encapsulate shared data and allow as few places as possible to modify it.
- **Use Copies of Data** — avoid sharing by copying objects that multiple threads read. The cost of creating extra objects is often less than synchronizing access.
- **Threads Should Be as Independent as Possible** — write threaded code so each thread exists in its own world with no shared data.
- **Know Your Library** — use `AtomicInteger`, `ConcurrentHashMap`, `LinkedBlockingQueue` instead of rolling your own.

## Kotlin Notes

- `java.util.concurrent.atomic.AtomicInteger.incrementAndGet()` is the idiomatic lock-free counter.
- `HashMap(existingMap)` creates a shallow copy — sufficient for value types like `Double`.
- `LinkedBlockingQueue` is a clean producer-consumer channel: `put()` blocks when full, `take()` blocks when empty.
- Kotlin coroutines (`Channel`, `Flow`) are the modern alternative but the JUC primitives remain fundamental.

## Exercises

1. **ThreadSafeCounter**: Implement `increment()` with `AtomicInteger.incrementAndGet()` and `get()` with `AtomicInteger.get()`.
2. **SensorRepository.getSnapshot()**: Return `HashMap(sensors)` — an independent copy that callers cannot use to corrupt internal state.
3. **produceAndConsume**: Wire a producer thread (enqueue items + sentinel) to a consumer thread (drain until sentinel) via `LinkedBlockingQueue`.
