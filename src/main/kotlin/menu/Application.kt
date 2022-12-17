package menu

fun main() {
    try {
        World()
    } catch (e: Exception) {
        when (e) {
            is IllegalArgumentException, is IllegalStateException -> {
                println("[ERROR] ${e.message}")
            }
        }
    }
}
