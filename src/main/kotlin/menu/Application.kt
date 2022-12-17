package menu

fun main() {
    try {
        World()
    } catch (e: Exception) {
        println("[ERROR] ${e.message}")
    }
}
