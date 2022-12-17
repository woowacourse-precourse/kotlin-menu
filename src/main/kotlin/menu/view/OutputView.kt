package menu.view

class OutputView {

    fun printStart() {
        println(START_RECOMMEND)
    }

    companion object {
        const val START_RECOMMEND = "점심 메뉴 추천을 시작합니다."
        const val RESULT_RECOMMEND = "메뉴 추천 결과입니다."
        const val END_RECOMMEND = "추천을 완료했습니다."
    }
}