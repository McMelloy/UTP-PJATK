package main;

import java.util.ArrayList;
import java.util.List;

public class Container<TElement extends IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>, TAggregateResult>
        implements IContainer<TElement,TAggregateResult> {

    private ArrayList<TElement> list = new ArrayList<>();

    @Override
    public List<TElement> elements() {
        return list;
    }

    @Override
    public TAggregateResult aggregateAllElements() {
        TAggregateResult sum = null;
        for (TElement element : list) {
            sum = element.aggregate(sum);
        }
        return sum;
    }


    @Override
    public TElement cloneElementAtIndex(int index) {
        TElement clone = list.get(index).deepClone();
        return clone;
    }
}
