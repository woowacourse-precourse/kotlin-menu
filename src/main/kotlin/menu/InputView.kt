package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCoaches(): List<Coach> {
        println("코치의 이름을 입력해주세요. (, 로 구분)")
        val input = Console.readLine()
        val splitResult = input.split(",")
        val coaches = mutableListOf<Coach>()
        // 코치 이름 길이 확인
        try {
            if(splitResult.size < 2 || splitResult.size > 5) throw IllegalArgumentException("coach-numbers")
            for (name in splitResult) {
                if(name.length < 2 || name.length > 4) throw IllegalArgumentException("coach-name-length")
                coaches.add(Coach(name))
            }
        } catch(e: IllegalArgumentException) {
            when(e.message) {
                "coach-numbers"->println("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께합니다.")
                "coach-name-length"->println("[ERROR] 코치 이름은 최소 2글자, 최대 4글자입니다.")
            }
            return readCoaches()
        }
        return coaches
    }

    private fun readMenu(): List<String> {
        val input = Console.readLine()
        // TODO : 카테고리 속에 없는 메뉴를 예외처리할 것인가? 고민하기
        return input.split(",")
    }


    fun readMenus(coaches: List<Coach>) {
        for (coach in coaches) {
            println("${coach.name}(이)가 못 먹는 메뉴를 입력해주세요.")
            coach.addUneatableMenus(readMenu())
        }
    }

}