package menu.view

import menu.values.Strings
import java.io.BufferedReader
import java.io.InputStreamReader

class input {



   fun printStart(){
       println(Strings.START.message)
       println()
   }


   fun InputName() : List<String>{
       val br = BufferedReader(InputStreamReader(System.`in`))
       var coachName = ArrayList<String>()
       println(Strings.INPUT_NAME.message)
       coachName = br.readLine().split(",").map { it } as ArrayList<String>

       return  coachName
   }
}