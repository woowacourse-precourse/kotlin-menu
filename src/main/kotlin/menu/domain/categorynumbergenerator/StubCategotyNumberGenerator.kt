package menu.domain.categorynumbergenerator

class StubCategotyNumberGenerator(private val testCategoryList: MutableList<Int>) : CategoryNumberGenerator {

    override fun generate(): Int = testCategoryList.removeAt(0)
}
