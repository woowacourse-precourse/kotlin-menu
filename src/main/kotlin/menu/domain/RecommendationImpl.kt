package menu.domain

interface RecommendationImpl {
    fun categoryMenuSelect(category: Category): List<String>
    fun menuRecommendation(category: Category, uneatableMenu: List<String>): String
}