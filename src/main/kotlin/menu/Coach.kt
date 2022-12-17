package menu

class Coach {
    private var name = ""
    var hateFood = mutableListOf<String>()

    fun setName(name : String){
        this.name = name
    }
    fun getName():String{
        return this.name
    }
}