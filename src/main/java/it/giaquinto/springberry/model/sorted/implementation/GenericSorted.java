package it.giaquinto.springberry.model.sorted.implementation;

import it.giaquinto.springberry.model.sorted.SortedStrategy;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class GenericSorted<T extends Comparable<T>> implements SortedStrategy<T> {
    @Override
    public List<T> sortDescending(Collection<T> toOrderedDescending) {
        return toOrderedDescending.stream().sorted(Comparator.reverseOrder()).toList();
    }

    @Override
    public List<T> sortGrowing(Collection<T> toOrderedGrowing) {
        return toOrderedGrowing.stream().sorted().toList();
    }

    @Override
    public T[] sortDescendingArray(Collection<T> toOrderedDescending) {
        return (T[]) toOrderedDescending.stream().sorted(Comparator.reverseOrder()).toArray();
    }

    @Override
    public T[] sortGrowingArray(Collection<T> toOrderedGrowing) {
        return (T[]) toOrderedGrowing.stream().sorted().toArray();
    }
}
