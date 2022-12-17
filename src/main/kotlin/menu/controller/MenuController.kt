package menu.controller

import menu.domain.CategoryGenerator
import menu.model.Coach
import menu.model.Coaches
import menu.view.OutputView
import menu.values.GameMessage
import menu.view.InputView

class MenuController {
    private val outputView = OutputView()
    private val inputView = InputView(outputView)
    private val coaches = Coaches()

    fun run(){
        outputView.printMessage(GameMessage.START_MENU_RECOMMEND)

        //요일마다 랜덤 카테고리 생성
        val categoriesGenerator = CategoryGenerator()
        val weekCategories = categoriesGenerator.generate()


        repeat(weekCategories.size){index->
            println(weekCategories[index].name)
        }

        //코치가 싫어하는 메뉴 입력
        val coachesName = requestCoachName()
        addCoaches(coachesName)

        coaches.recommendCoachesMenu(weekCategories)

        outputView.printMenu(weekCategories,coaches.coaches)

    }

    private fun addCoaches(coachesName:List<String>){
        repeat(coachesName.size) {name ->
            val hateMenu = requestHateMenu(coachesName[name])
            val coach = Coach(coachesName[name],hateMenu)
            coaches.addCoach(coach)
        }
    }
    private fun requestCoachName():List<String>{
        while(true) {
            try {
                return inputView.readCoach()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun requestHateMenu(name:String):List<String>{
        while(true) {
            try {
                return inputView.readHateMenu(name)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}