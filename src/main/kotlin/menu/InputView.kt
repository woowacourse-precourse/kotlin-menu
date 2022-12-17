package menu

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputCoach() : List<String>{
        println("점심 메뉴 추천을 시작합니다.")

        println()
        println("코치의 이름을 입력해 주세요. (, 로 구분)")
        var input = Console.readLine()
        val user = input.split(",")

        inputCoachException(user)

        println()

        return user
    }

    private fun inputCoachException(user: List<String>) {
        // 코치 숫자 예외처리
        if (user.size < 2 || user.size > 5) {
            throw IllegalArgumentException("[ERROR]코치는 최소 2명 최대 5명이 같이 식사를 할 수 있습니다.")
        }

        // 코치 이름 예외처리
        for (i in user.indices) {
            if (user[i].length < 2 || user[i].length > 4) {
                throw IllegalArgumentException("[ERROR]이름 형식에 맞춰주세요(이름은 2글자에서 4글자).")
            }
        }
    }

    fun inputCantEatMenu(user : MutableList<String>) : MutableList<MutableList<String>>{
        var avoid = mutableListOf<MutableList<String>>()
        for (i in 0 until user.size) {
            println(user[i] + "(이)가 못 먹는 메뉴를 입력해 주세요.")
            var menu = Console.readLine()
            if (menu == "") {
                avoid[i].add("nothing")
                println()
                continue
            }
            if (menu.contains(",")) {
                var cantEat = menu.split(",")
                if (cantEat.size > 2) {
                    throw IllegalArgumentException("[ERROR] 먹지 못하는 메뉴는 최대 2개 입니다.")
                }
                avoid.add(cantEat as MutableList<String>)
                println()
                continue
            }
//            if(menu != null){
//                avoid[i].add(menu)
//                println()
//            }
        }
        return avoid
    }
}