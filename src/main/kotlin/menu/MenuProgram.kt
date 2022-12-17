package menu

class MenuProgram(val input:InputView, val output:OutputView) {

    private lateinit var coachs:MutableList<Coach>

    fun runProgram(){
        output.printStart()
        makeCoachs()
        findHateFood()
    }

    fun makeCoachs(){
        val coach= input.inputCoachName()
        for(each in coach){
            coachs.add(Coach(each, mutableListOf()))
        }
    }

    fun findHateFood(){
        var hateFood:List<String>
        for(coach in coachs){
            hateFood=input.inputHateFood(coach.name).toMutableList()
            coach.hateFood=hateFood
        }
    }



}