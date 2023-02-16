package it.giaquinto.springberry.model.sorted

interface SortedStrategy<T : Comparable<*>?> {
    fun sortDescending(toOrderedDescending: Collection<T>): List<T>?
    fun sortGrowing(toOrderedGrowing: Collection<T>): List<T>?
    fun sortDescendingArray(toOrderedDescending: Collection<T>): Array<T>
    fun sortGrowingArray(toOrderedGrowing: Collection<T>): Array<T>
}