package menu.domain

enum class Category(
    private val isMatch: ((String) -> Boolean),
    private val isNumMatch: ((Int) -> Boolean)
) {
    KOREA(
        { input ->
            input == "한식"
        },
        { input ->
            input == 2
        }),
    JAPAN(
        { input ->
            input == "일식"
        },
        { input ->
            input == 1
        }),
    CHINA(
        { input ->
            input == "중식"
        },
        { input ->
            input == 3
        }),
    ASIAN(
        { input ->
            input == "아시안"
        },
        { input ->
            input == 4
        }),
    WEST(
        { input ->
            input == "양식"
        },
        { input ->
            input == 5
        });


    companion object {
        fun getMatched(userInput: String): Category? {
            return values().firstOrNull { it.isMatch(userInput) }
        }

        fun getNum(userInput: Int): Category? {
            return values().firstOrNull { it.isNumMatch(userInput) }
        }

        fun print(category: Category): String {
            return when (category) {
                KOREA -> "한식"
                JAPAN -> "일식"
                CHINA -> "중식"
                ASIAN -> "아시안"
                else -> "양식"
            }
        }
    }
}
//일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
//한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
//중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
//아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
//양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니