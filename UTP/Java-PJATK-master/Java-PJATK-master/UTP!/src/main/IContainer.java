package main;

import java.util.List;

public interface IContainer<TElement extends IAggregable<TElement, TResult> & IDeeplyCloneable<TElement>, TResult>
    {
        List<TElement> elements();
        TResult aggregateAllElements();
        TElement cloneElementAtIndex(int index);
    }