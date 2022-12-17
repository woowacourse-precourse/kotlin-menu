package menu

class menuRecommend {
    val OV = outputView()
    val IV = inputView()
    val MN = Menu()
    var coachNameCollect= listOf<String>()
    var coachNotEat = mutableListOf<List<String>>()
    var coachsMenuCollection= mutableListOf<List<String>>()
    var categoryNameCollect = listOf<String>()


    constructor(){
        OV.startService()
        OV.inputCoach()
        duringInput()
    }

    fun duringInput(){
        coachNameCollect=IV.inputCoachName()
        for (i in 0 until coachNameCollect.size){
            OV.inputNotEat(coachNameCollect[i])
            coachNotEat.add(IV.inputNotEating())
            println()
        }
    }

    fun categoryMenuSelect(){
        categoryNameCollect=MN.categorySelect()
        eachCoach()
    }

    fun duringMenuSelect(i : Int): List<String>{
        var ctidx=0
        var menuCollect = mutableListOf<String>()
        var menu = ""
        while (true){
            if (menuCollect.size==5) break
            menu = MN.menuRecommend(categoryNameCollect[ctidx])
            if ((coachNotEat[i]).contains(menu)) continue
            if (menuCollect.contains(menu)) continue
            menuCollect.add(menu)
            ctidx+=1
        }
        return menuCollect
    }

    fun eachCoach(){
        var coachMenuCollect= listOf<String>()
        for (i in 0 until coachNameCollect.size){
            coachMenuCollect=duringMenuSelect(i)
            coachsMenuCollection.add(coachMenuCollect)
        }
    }

    fun final(){
        OV.menuResult()
        OV.day()
        OV.category(categoryNameCollect)
        for(i in 0 until coachNameCollect.size){
            OV.coachNameMenu(coachNameCollect[i],coachsMenuCollection[i])
        }
        OV.endService()
    }

}