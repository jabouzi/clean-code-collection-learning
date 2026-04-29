package cleancode.ch07_error_handling

object Solution {
    // Principle: Use Exceptions Rather Than Return Codes — throw when something goes wrong
    // instead of returning sentinel values that callers can ignore.
    fun sendShutDown(device: Device) {
        if (!device.isValid) throw DeviceException("Device is not valid")
        if (device.isSuspended) throw DeviceException("Device is suspended")
    }

    // Principle: Don't Return Null / Special Case Pattern — return an empty list instead of
    // null so callers can safely iterate without null checks.
    fun getEmployees(): List<Employee> = emptyList()

    // Principle: Wrap Third-Party APIs — consolidate multiple low-level exceptions into a
    // single domain exception so callers only need one catch clause.
    fun openPort(portNumber: Int): Port {
        if (portNumber < 0) {
            try {
                throw DeviceResponseException()
            } catch (e: DeviceResponseException) {
                throw PortDeviceFailure(e)
            }
        }
        return Port(portNumber)
    }
}
