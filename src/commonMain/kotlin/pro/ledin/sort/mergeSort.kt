package pro.ledin.sort

fun <T : Comparable<T>> Array<out T>.mergeSorted(range: IntRange = this.indices): Array<out T> {
    val c = this.copyOf()
    c.mergeSort(range)
    return c
}

fun <T : Comparable<T>> Array<out T>.mergeSort(range: IntRange = this.indices) {
    mergeSort(Comparator { a, b -> if (a < b) -1 else if (a > b) 1 else 0 }, range)
}

fun <T> Array<T>.mergeSorted(comparator: Comparator<T>, range: IntRange = this.indices): Array<out T> {
    val c = this.copyOf()
    c.mergeSort(comparator, range)
    return c
}

fun <T> Array<T>.mergeSort(comparator: Comparator<T>, range: IntRange = this.indices) {
    if (range.first < range.last) {
        val m = range.first + (range.last + 1 - range.first) / 2
        mergeSort(comparator, range.first until m)
        mergeSort(comparator, m..range.last)
        merge(this, range, m, comparator)
    }
}

private fun <T> merge(a: Array<T>, range: IntRange, middle: Int, comparator: Comparator<T>) {
    val left = a.sliceArray(range.first until middle)
    val right = a.sliceArray(middle..range.last)
    var i = 0
    var j = 0
    var k = range.first
    while (i < left.size && j < right.size) {
        if (comparator.compare(left[i], right[j]) <= 0) {
            a[k] = left[i++]
        } else {
            a[k] = right[j++]
        }
        k++
    }
    while (i < left.size) {
        a[k++] = left[i++]
    }
    while (j < right.size) {
        a[k++] = right[j++]
    }
}

