package menu.model

enum class Days {
    월, 화, 수, 목, 금;

    companion object {
        fun getDays() = Days.values().map { it }
    }
}