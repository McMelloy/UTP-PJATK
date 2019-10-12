package eu.glowacki.utp.assignment01.sample;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IContainer;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

import java.util.ArrayList;
import java.util.List;

public class Container<TElement extends IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>, TAggregateResult>
        implements IContainer<TElement,TAggregateResult> {

    private ArrayList<TElement> elements;

    Container(){
        elements = new ArrayList<>();
    }

    public void add(TElement elem){
        elements.add(elem);
    }

    public List<TElement> elements() {
        return elements;
    }

    public TAggregateResult aggregateAllElements() {
        TAggregateResult res = null;
        for(TElement elem: elements)
            res = elem.aggregate(res);
        return res;
    }

    public TElement cloneElementAtIndex(int index) {
        if(elements.get(index)==null) throw new NullPointerException("No such index");
        return elements.get(index).deepClone();
    }
}
