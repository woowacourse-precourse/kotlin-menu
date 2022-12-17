package menu.common

enum class DayOfTheWeek(val day: String) {
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일");

    companion object {
        fun getDays(): List<String> {
            return values().map { it.day }
        }
    }
}
