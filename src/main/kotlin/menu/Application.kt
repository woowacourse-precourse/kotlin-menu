package menu

import menu.domain.MenuRecommendation
import menu.view.InputView
import menu.view.OutputView
import java.lang.IllegalArgumentException

fun main() {
   try {
      val inputView = InputView()
      val outputView = OutputView()
      MenuRecommendation(inputView, outputView).start()
   } catch (e: IllegalArgumentException) {
      println(e.message)
      return
   }
}
