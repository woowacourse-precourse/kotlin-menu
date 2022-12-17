package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    private val outputView = OutputView()
    private val viewValidate = ViewValidate()

    fun readCoachesName(): List<String> {
        return try{
            outputView.printInputCoachNames()
            val coachNames = Console.readLine()
            viewValidate.coachNamesForm(coachNames)
            coachNames.split(",")
        }catch (e:IllegalArgumentException){
           return readCoachesName()
        }
    }

    fun readExcludedFoods(name: String): List<String> {
        return try {
            outputView.printInputExcludedFood(name)
            val excludedFoods = Console.readLine()
            viewValidate.excludedFoodsForm(excludedFoods)
            excludedFoods.split(",")
        } catch (e:IllegalArgumentException){
            return readExcludedFoods(name)
        }
    }

}