package menu.data

enum class Category(private val korean: String) {
    JAPANESE("일식"), KOREAN("한식"), CHINESE("중식"), ASIAN("아시안"), WESTERN("양식");

    override fun toString() = korean
}