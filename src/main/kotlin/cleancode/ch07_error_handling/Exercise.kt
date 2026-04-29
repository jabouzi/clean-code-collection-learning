package cleancode.ch07_error_handling

object Exercise {
    // Exercise 1: Replace return-code style with exceptions
    fun sendShutDown(device: Device) {
        TODO("Throw DeviceException instead of checking status codes")
    }

    // Exercise 2: Special Case pattern — never return null
    fun getEmployees(): List<Employee> {
        TODO("Return emptyList() instead of null when no employees")
    }

    // Exercise 3: Wrap multiple exceptions into one
    fun openPort(portNumber: Int): Port {
        TODO("Wrap DeviceResponseException, ATM1212UnlockedException, GMXError into PortDeviceFailure")
    }
}

data class Device(val isValid: Boolean, val isSuspended: Boolean)
data class Employee(val name: String)
data class Port(val number: Int)
class DeviceException(msg: String) : Exception(msg)
class PortDeviceFailure(cause: Throwable) : Exception(cause)
class DeviceResponseException : Exception()
class ATM1212UnlockedException : Exception()
class GMXError : Exception()
