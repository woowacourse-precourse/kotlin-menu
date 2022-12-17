package menu.model

enum class Days {
    월요일, 화요일, 수요일, 목요일, 금요일;

    companion object {
        fun getDays() = Days.values().map { it }
    }
}