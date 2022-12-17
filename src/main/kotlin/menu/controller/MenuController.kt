package menu.controller

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Category
import menu.utils.CATEGOTY
import menu.utils.DAYS
import menu.view.InputView

class MenuController {
    fun run() {
        val coaches = InputView.readCoaches().names()
        val weekend = mutableMapOf<String, String>()
        val categories = CATEGOTY.split(", ")
        val days = DAYS.split(", ")
        var tryNumber = 1
        while (tryNumber <= 5) {
            val category = categories.get(Randoms.pickNumberInRange(1, 5))
            if (weekend.values.filter { it == category }.size >= 2) {
                continue
            }
            weekend[days[tryNumber]] = category
            tryNumber++
        }
    }
}