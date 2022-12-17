package menu

fun main() {
    try{
        val startRecommend = StartRecommend()
        startRecommend.gameStart()
    } catch (e : IllegalArgumentException){
        println(e.message)
    }
}
