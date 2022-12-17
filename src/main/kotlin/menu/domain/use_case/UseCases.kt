package menu.domain.use_case

data class UseCases(
    val validateCoachNameUseCase: ValidateCoachNameUseCase = ValidateCoachNameUseCase(),
    val validateInedibleFoodUseCase: ValidateInedibleFoodUseCase = ValidateInedibleFoodUseCase(),
    val recommendFoodsUseCase: RecommendFoodsUseCase = RecommendFoodsUseCase()
)
