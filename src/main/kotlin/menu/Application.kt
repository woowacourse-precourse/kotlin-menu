package menu

import camp.nextstep.edu.missionutils.Console
import javax.swing.plaf.LabelUI

fun main() {
    printStartRecommand()
    println(inputName())
    var name = inputName()
    printNotRecommand(name[1])
    println(inputMenu())
}
fun printStartRecommand() {
    println("점심 메뉴 추천을 시작합니다.")
    println("코치의 이름을 입력해 주세요. (, 로 구분)")
}
fun inputName(): List<String> {
    var name = Console.readLine()
    return name.split(",")
}
fun printNotRecommand(name: String) {
    println("${name}(이)가 못 먹는 메뉴를 입력해 주세요.")
}
fun inputMenu(): List<String> {
    var menu = Console.readLine()
    return menu.split(",")
}
fun printRecommandResult() {
    println("메뉴 추천 결과입니다.")
    println("추천을 완료했습니다.")
}