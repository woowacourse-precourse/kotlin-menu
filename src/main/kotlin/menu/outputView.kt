package menu

class outputView {

    fun startService(){
        println("점심 메뉴 추천을 시작합니다")
    }

    fun inputCoach(){
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
    }

    fun inputNotEat(){
        println("(수정해야될곳)(이)가 못 먹는 메뉴를 입력해 주세요.")
    }

    fun menuResult(){
        println("메뉴 추천 결과입니다.")
    }

    fun endService(){
        println("추천을 완료했습니다.")
    }
}