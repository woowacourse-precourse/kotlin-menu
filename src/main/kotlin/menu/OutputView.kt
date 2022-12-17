package menu

class OutputView {

    fun printServiceStart(){
        println(SERVICE_START_MESSAGE)
    }

    fun printServiceEnd(){
        print(SERVICE_END_MESSAGE)
    }

    fun printRecommendationResult(result:String){
        print(result)
    }

    companion object{
        const val SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다."
        const val SERVICE_END_MESSAGE = "추천을 완료했습니다."
    }
}