package menu.utils

import menu.values.Strings
import menu.view.Input

class Validator {

    fun checkInputName(list: ArrayList<String>){
        for (i in 0 until list.size){
            if (list[i].length < 2 || list[i].length > 4){
                throw IllegalArgumentException(Strings.INPUT_NAME_ERROR.message)
            }
        }
    }

    fun checkInputGROUP(list: ArrayList<String>){
       if(list.size < 2 || list.size > 5){
           throw IllegalArgumentException(Strings.INPUT_GROUP_ERROR.message)
       }
    }
}