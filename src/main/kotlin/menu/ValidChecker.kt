package menu

class ValidChecker {

    fun checkCoachNames(names:String):List<String>{
        var coachNames= names.split(",")
        if(coachNames.size<2 || coachNames.size>5){
            throw IllegalArgumentException()
        }
        for(name in coachNames){
            if(name.length<2 || name.length>4){
                throw IllegalArgumentException()
            }
        }
        return coachNames
    }

    fun checkHateFood(foodName:String):List<String>{
        var hateFood=foodName.split(",")
        if(hateFood.size>2){
            throw IllegalArgumentException()
        }
        return hateFood

    }
}