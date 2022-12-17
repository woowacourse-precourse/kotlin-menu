package menu

enum class Category(
    private val koreanName: String,
    private val index: Int
) {
    JAPANESE("일식", 0),
    KOREAN("한식", 1),
    CHINESE("중식",2),
    ASIAN("아시안",3),
    WESTERN("양식",4)
}