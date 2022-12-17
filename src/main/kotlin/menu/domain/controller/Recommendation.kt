package menu.domain.controller

import menu.data.State.categories
import menu.data.State.coachNames
import menu.data.State.inedibleFoods
import menu.domain.CategoryMaker
import menu.domain.CategoryRandomNumberGenerator
import menu.domain.use_case.UseCases

class Recommendation(
    private val useCases: UseCases = UseCases(),
    private val categoryMaker: CategoryMaker = CategoryMaker(CategoryRandomNumberGenerator())
) : RecommendService {

    override fun init() {
        println(START_RECOMMENDATION)
        categoryMaker.makeCategory()
    }

    override fun run() {
        init()

        processCoachName()
        processInedibleFoods()
        processRecommendation()

        end()
    }

    override fun end() {
        println(END_RECOMMENDATION)
    }

    private fun processCoachName() =
        useCases.validateCoachNameUseCase()

    private fun processInedibleFoods() =
        useCases.validateInedibleFoodUseCase()

    private fun processRecommendation() =
        useCases.recommendFoodsUseCase()


    companion object {
        const val START_RECOMMENDATION = "점심 메뉴 추천을 시작합니다.\n"
        const val END_RECOMMENDATION = "추천을 완료했습니다."
    }
}