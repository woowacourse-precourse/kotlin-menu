package menu.view

import menu.values.Strings

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
}