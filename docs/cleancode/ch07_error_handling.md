# Chapter 7: Error Handling

## Key Principles

- **Use Exceptions Rather Than Return Codes** — return codes clutter callers and are easy to ignore. Throwing an exception forces the caller to handle the failure path.
- **Write Your Try-Catch-Finally First** — start with the exceptional path; it defines the contract of a function in terms of what can go wrong.
- **Use Unchecked Exceptions** — checked exceptions create hidden coupling between layers. In Kotlin all exceptions are unchecked by design.
- **Provide Context with Exceptions** — include enough information in the message or cause chain to diagnose the problem without a debugger.
- **Special Case Pattern** — return a neutral object (e.g. empty list) instead of null so callers need no null checks; the object handles the special case itself.
- **Don't Return Null / Don't Pass Null** — returning null forces null checks everywhere. Passing null is worse — it shifts the crash to a random call site far from the source.
- **Wrap Third-Party APIs** — define one domain exception that wraps all low-level third-party exceptions so callers write a single `catch` clause.

## Kotlin Notes

- Kotlin's `null`-safety makes "don't return null" easy: return `List<Employee>` not `List<Employee>?`
- `emptyList()` is the idiomatic Special Case value for collections
- The `cause` constructor parameter on `Exception` enables wrapping: `PortDeviceFailure(cause = e)`

## Exercises

1. **sendShutDown** — throw `DeviceException` instead of silently doing nothing when the device is invalid or suspended.
2. **getEmployees** — return `emptyList()` (Special Case Pattern) so callers never get null.
3. **openPort** — wrap low-level exceptions (`DeviceResponseException`, `ATM1212UnlockedException`, `GMXError`) into a single `PortDeviceFailure` so callers write one catch clause.
