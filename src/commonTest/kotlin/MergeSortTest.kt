import pro.ledin.sort.mergeSort
import pro.ledin.sort.mergeSorted
import kotlin.test.Test
import kotlin.test.assertTrue

class MergeSortTest {
    @Test
    fun sorts() {
        assertTrue(arrayOf(1, 3, 2, 4).mergeSorted().contentEquals(arrayOf(1, 2, 3, 4)))
        assertTrue(arrayOf(1, 3, 2, 2, 3, -5, 0).mergeSorted().contentEquals(arrayOf(-5, 0, 1, 2, 2, 3, 3)))
        assertTrue(arrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1).mergeSorted().contentEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
        assertTrue(arrayOf(9, 0, 8, 1, 7, 2, 6, 3, 5, 4).mergeSorted().contentEquals(arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))
    }

    @Test
    fun sortsPartially() {
        assertTrue(arrayOf(4, 3, 2, 1, 9, 8, 7, 6, 5).mergeSorted(0 until 4).contentEquals(arrayOf(1, 2, 3, 4, 9, 8, 7, 6, 5)))
        assertTrue(arrayOf(9, 0, 8, 1, 7, 2, 6, 3, 5, 4).mergeSorted(3..6).contentEquals(arrayOf(9, 0, 8, 1, 2, 6, 7, 3, 5, 4)))
    }

    @Test
    fun sortsInPlace() {
        val original = arrayOf(9, 0, 8, 1, 7, 2, 6, 3, 5, 4)
        original.mergeSort()
        assertTrue(original.contentEquals(arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))
    }

    @Test
    fun sortsWithComparator() {
        data class Value(val a: Int)
        assertTrue(arrayOf(Value(1), Value(2), Value(3)).mergeSorted(Comparator {a, b -> b.a - a.a})
            .contentEquals(arrayOf(Value(3), Value(2), Value(1))))
    }
}