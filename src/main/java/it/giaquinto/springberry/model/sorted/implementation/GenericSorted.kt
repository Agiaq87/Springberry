package it.giaquinto.springberry.model.sorted.implementation

import it.giaquinto.springberry.model.sorted.SortedStrategy

class GenericSorted<T : Comparable<T>?> : SortedStrategy<T> {
    override fun sortDescending(toOrderedDescending: Collection<T>): List<T>? {
        return toOrderedDescending.stream().sorted(Comparator.reverseOrder()).toList()
    }

    override fun sortGrowing(toOrderedGrowing: Collection<T>): List<T>? {
        return toOrderedGrowing.stream().sorted().toList()
    }

    override fun sortDescendingArray(toOrderedDescending: Collection<T>): Array<T> {
        return toOrderedDescending.stream().sorted(Comparator.reverseOrder()).toArray() as Array<T>
    }

    override fun sortGrowingArray(toOrderedGrowing: Collection<T>): Array<T> {
        return toOrderedGrowing.stream().sorted().toArray() as Array<T>
    }
}