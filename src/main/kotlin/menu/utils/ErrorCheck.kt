package menu.utils

inline fun <T> infinityRead(call: () -> T): T {
    while (true) {
        try {
            return call()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
