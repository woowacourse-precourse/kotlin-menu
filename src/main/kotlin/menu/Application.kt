package menu

import menu.controller.MenuController
import menu.domain.Category
import menu.domain.Menu

fun main() {
    val lines = availableMenus.split(";")
    val availableMenus = mutableListOf<Menu>()
    for (line in lines) {
        if (line.isBlank()) break
        val tmp = line.split(":")
        val category = Category.from(tmp[0])
        val menus = tmp[1].split(",").map { Menu(it.trim(), category) }
        availableMenus.addAll(menus)
    }
    Menu.availableMenus = availableMenus
    MenuController().run()
}

private val availableMenus = """
${JAPANESE_TEXT}: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼;
${KOREAN_TEXT}: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음;
${CHINESE_TEXT}: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채;
${ASIAN_TEXT}: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜;
${WESTERN_TEXT}: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니;
""".trimIndent().replace("\n", "")
