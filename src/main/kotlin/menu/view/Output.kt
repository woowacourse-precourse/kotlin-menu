package menu.view

import menu.values.Strings
import java.lang.StringBuilder

class Output {


    fun printStart() {
        println(Strings.START.message)
        println()
    }

    fun printInputCoachName(){
        println(Strings.INPUT_NAME.message)
    }

    fun printInputHateFoo(coach : String){
        println("${coach}" + Strings.INPUT_HATEFOOD.message)
    }

    fun printResultPhrases(){
        println(Strings.RESULT.message)
    }

    fun printStandard(){
        println(Strings.DAY.message)
    }

    fun printFoodCategory(foodType : ArrayList<String>) : String{
        val sb = StringBuilder()
        sb.append("[ 카테고리 | ").append(foodType.joinToString(" | ")).append("]")

        return sb.toString()
    }

    fun printFoodGroup(food : ArrayList<String>,name : String) : String{
        val sb = StringBuilder()
        sb.append("[ ${name} | ").append(food.joinToString(" | ")).append("]")

        return sb.toString()
    }

    fun printEnd(){
        println(Strings.COMPLETE.message)
    }
}