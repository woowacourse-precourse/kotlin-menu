package menu

class menuRecommend {
    val OV = outputView()
    val IV = inputView()
    val MN = Menu()
    var coachNameCollect= listOf<String>()
    var coachMenuCollect= mutableListOf<String>()
    var coachsMenuCollection= mutableListOf<List<String>>()
    var categoryNameCollect = listOf<String>()


    constructor(){
        OV.startService()
        OV.inputCoach()
        duringInput()
    }

    fun duringInput(){
        coachNameCollect=IV.inputCoachName()
//        println(coachNameCollect)
        for (i in 0 until coachNameCollect.size){
            OV.inputNotEat(coachNameCollect[i])
            IV.inputNotEating()
            println()
        }
    }

    fun categoryMenuSelect(){
        categoryNameCollect=MN.categorySelect()
        eachCoach()
    }

    fun duringMenuSelect(): List<String>{
        var idx=0
        var menu = mutableListOf<String>()
        while (true){
            if (menu.size==5) break
            menu.add(MN.menuRecommend(categoryNameCollect[idx]))
            idx+=1
        }
        return menu
    }

    fun eachCoach(){
        var coachMenuCollect= listOf<String>()
        for (i in 0 until coachNameCollect.size){
            coachMenuCollect=duringMenuSelect()
            coachsMenuCollection.add(coachMenuCollect)
        }
    }

    fun final(){
        OV.menuResult()
        OV.day()
        OV.category(categoryNameCollect)
        for(i in 0 until coachNameCollect.size){
            // 얘때문에 코치별 이름, 메뉴 뜨는거
            OV.coachNameMenu(coachNameCollect[i],coachsMenuCollection[i])
        }
        OV.endService()
    }

}