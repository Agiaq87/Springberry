package it.giaquinto.springberry.model.sorted;

import java.util.Collection;
import java.util.List;

public interface SortedStrategy<T extends Comparable> {
    List<T> sortDescending(final Collection<T> toOrderedDescending);

    List<T> sortGrowing(final Collection<T> toOrderedGrowing);

    T[] sortDescendingArray(final Collection<T> toOrderedDescending);

    T[] sortGrowingArray(final Collection<T> toOrderedGrowing);


}
