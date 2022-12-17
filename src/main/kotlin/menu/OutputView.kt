package menu

class OutputView {

    fun printServiceStart(){
        println(SERVICE_START_MESSAGE)

    }

    companion object{
        const val SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다."
    }
}