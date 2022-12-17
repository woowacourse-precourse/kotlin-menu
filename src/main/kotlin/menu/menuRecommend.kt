package menu

class menuRecommend {
    val OV = outputView()
    val IV = inputView()
    val MN = Menu()
    var coachNameCollect= listOf<String>()
    var coachMenuCollect= mutableListOf<String>()
    var categoryNameCollect = listOf<String>()


    constructor(){
        OV.startService()
        OV.inputCoach()
        duringInput()
    }

    fun duringInput(){
        coachNameCollect=IV.inputCoachName()
        println(coachNameCollect)
        for (i in 0 until coachNameCollect.size){
            OV.inputNotEat(coachNameCollect[i])
            IV.inputNotEating()
            println()
        }
    }

    fun categoryMenuSelect(){
        categoryNameCollect=MN.categorySelect()

    }

    fun duringMenuSelect(){
        var idx=0
        while (true){
            if (coachMenuCollect.size==5) break
            MN.menuRecommend(categoryNameCollect[idx])
            idx+=1
        }

    }

    fun final(){
        OV.menuResult()
        OV.day()
        OV.category(categoryNameCollect)
        for(i in 0 until coachNameCollect.size){
//            OV.coachNameMenu(coachNameCollect[i],"메뉴리스트")
        }
        OV.endService()
    }

}