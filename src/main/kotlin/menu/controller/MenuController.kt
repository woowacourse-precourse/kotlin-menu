package menu.controller

import menu.domain.MenuRecommender
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val menuRecommender = MenuRecommender()
    fun startRecommend() {
        inputCoachName()
        inputHateFood()
        pickWeekMenu()
    }

    private fun inputCoachName() {
        print("점심 메뉴 추천을 시작합니다.\n")
        println("코치의 이름을 입력해 주세요. (, 로 구분")
        setCoachName()
    }

    private fun setCoachName() {
        menuRecommender.setCoachNameList(inputView.inputCoachList())
    }

    private fun inputHateFood() {
        for(people in menuRecommender.coachNameList){
            println("${people}(이)가 못 먹는 메뉴를 입력해 주세요.")
            menuRecommender.setHateFoodList(inputView.inputHateFoodList())
        }
    }

    private fun pickWeekMenu() {
        menuRecommender.pickWeekMenu()
    }
}