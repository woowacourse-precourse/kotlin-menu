Progress & MileStones
---
## Model
- CategoryRepository
  - Make recommended category
  - Test
- MenuRepository
  - Make recommended menu (according to category and coach info)
  - Test

## View
- InputView
  - ~~Get coach name~~
  - Get coach's hate menu
  
- OutputView
  - Print process start
  - Print result

## Service
- ValidateService
  - Validate coach name
  - Validate coach's hate menu

## Controller
- UIController
  - Get coach name (with error handling)
  - Get coach's hate menu (with error handling)
  - Print Result
  - Test error handling

- RecommendController
    - Run recommendation process
    - Set input using UIController
    - Recommend menu
    - Test recommendation process
