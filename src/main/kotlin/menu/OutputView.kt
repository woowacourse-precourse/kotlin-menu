package menu

class OutputView {

    private fun printCategories(categories: List<Category>) {
        print("[ 카테고리 | ")
        for(index in categories.indices) {
            print("${categories[index].name} ")
            if (index != categories.lastIndex) print("| ")
        }
        println("]")
    }
    private fun printRecommendations(recommendations: Map<String, List<String>>) {
        for(key in recommendations.keys) {
            print("[ $key | ")
            for (index in recommendations[key]!!.indices) {
                print("${recommendations[key]!![index]} ")
                if (index != recommendations[key]!!.lastIndex) print("| ")
            }
            println("]")
        }
    }
    fun printResult(menuResult: MenuResult) {
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        printCategories(menuResult.categories)
        printRecommendations(menuResult.recommendations)
        println()
        println("추천을 완료했습니다.")
    }
}