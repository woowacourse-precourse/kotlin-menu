package menu

fun main() {
    try {
        RecommendMenu().run()
    } catch (e: Exception) {
        when (e) {
            is IllegalArgumentException -> throw IllegalStateException(e.message)
            is IllegalStateException -> throw IllegalStateException(e.message)
        }
    }

}
