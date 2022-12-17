package menu.view

class OutputView {
    fun printStartAnnouncement() {
        println(START_ANNOUNCEMENT)
    }

    companion object {
        const val START_ANNOUNCEMENT = "점심 메뉴 추천을 시작합니다."
    }
}