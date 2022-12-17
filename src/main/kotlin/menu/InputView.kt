package menu

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun requestCoachesName(): String {
        println(REQUEST_COACHES_NAME)

        return Console.readLine()
    }

    fun requestHatingMenus(coachName: String): String {
        println(REQUEST_HATING_FOODS.format(coachName))

        return Console.readLine()
    }

    companion object {
        const val REQUEST_COACHES_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)"
        const val REQUEST_HATING_FOODS = "%s(이)가 못 먹는 메뉴를 입력해 주세요."
    }
}