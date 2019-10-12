package eu.glowacki.utp.assignment01.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlbumTest {

    private static final String[] SONGS = {"Overture", "Interlude", "Outro"};

    private Album _album;

    @Before
    public void before() {
        _album = new Album(SONGS);
        Assert.assertEquals(SONGS.length, _album.count());
        Assert.assertEquals(SONGS[0], _album.intro());
    }

    @Test
    public void aggregate() {
        int aggregate = _album.aggregate(null);
        Assert.assertEquals(SONGS.length, aggregate);
        final int init = 20;
        Assert.assertEquals((int) (SONGS.length + init), (int) (_album.aggregate(init)));
    }

    @Test
    public void deepClone() {
        Album clone = _album.deepClone();
        Assert.assertEquals(_album.count(), clone.count());
        Assert.assertEquals(_album.intro(), clone.intro());
        Assert.assertNotSame(_album, clone);
    }

}