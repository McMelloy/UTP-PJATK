package eu.glowacki.utp.assignment01.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ContainerTest {
    private static final String[] songs1 = {"Overture", "Interlude", "Outro"};
    private static final String[] songs2 = {"Bohemian Rhapsody", "Killer Queen", "Innuendo", "Show Must Go On"};
    private static final String[] songs3 = {"Sheep", "Dogs", "Pigs (Three Different Ones)", "High Hopes", "Hey You"};
    private static final String[] songs4 = {"temp"};

    private Album classic;
    private Album queen;
    private Album pinkfloyd;

    private Container<Album,Integer> _Container;

    @Before
    public void before() {
        _Container = new Container<>();
        classic = new Album(songs1);
        queen = new Album(songs2);
        pinkfloyd = new Album(songs3);
        _Container.add(classic);
        _Container.add(queen);
        _Container.add(pinkfloyd);
    }

    @Test
    public void elements() {
        ArrayList<Album> tmp = new ArrayList<>();
        tmp.add(classic);
        tmp.add(queen);
        tmp.add(pinkfloyd);
        Assert.assertEquals(tmp, _Container.elements());
    }


    @Test
    public void aggregateAllElements() {
        int aggregate = _Container.aggregateAllElements();
        Assert.assertEquals(songs1.length + songs2.length + songs3.length, aggregate);
    }

    @Test
    public void cloneElementAtIndex() {
        Album clone = _Container.cloneElementAtIndex(0);
        Assert.assertEquals(_Container.elements().get(0).count(), clone.count());
        Assert.assertNotSame(_Container.elements().get(0), clone);
    }

    @Test
    public void add(){
        Album check = new Album(songs4);
        System.out.print(_Container.elements().size());
        _Container.add(check);
        System.out.println(" -> "+_Container.elements().size());
    }
}
