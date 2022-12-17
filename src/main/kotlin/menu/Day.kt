package menu

enum class Day(private val korean: String) {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    fun byKorean(): String {
        return korean
    }
}