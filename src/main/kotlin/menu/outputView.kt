package menu

class outputView {

    fun startService(){
        println("점심 메뉴 추천을 시작합니다.")
        println()
    }

    fun inputCoach(){
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
    }

    fun inputNotEat(coachName : String){
        println("${coachName}(이)가 못 먹는 메뉴를 입력해 주세요.")
    }

    fun menuResult(){
        println("메뉴 추천 결과입니다.")
    }

    fun endService(){
        println()
        println("추천을 완료했습니다.")
    }

    fun day(){
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
    }

    fun coachNameMenu(coachName: String, menuCollect: List<String>) {
        println("[ ${coachName} | ${menuCollect[0]} | ${menuCollect[1]} | ${menuCollect[2]} | ${menuCollect[3]} | ${menuCollect[4]} ]")
    }

    fun category(categoryName: List<String>){
        println("[ 카테고리 | ${categoryName[0]} | ${categoryName[1]} | ${categoryName[2]} | ${categoryName[3]} | ${categoryName[4]} ]")
    }

}