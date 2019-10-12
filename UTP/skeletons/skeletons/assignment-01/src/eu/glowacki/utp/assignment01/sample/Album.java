package eu.glowacki.utp.assignment01.sample;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;


public class Album implements IAggregable<Album, Integer>, IDeeplyCloneable<Album> {
    String[] songs;

    public Album(){

    }

    public Album(String[] songs){
        if(songs==null)
            throw new NullPointerException("Your album is empty!");
        this.songs = songs;
    }

    public int count(){
        return songs.length;
    }
    public String intro(){
        try {
            return songs[0];
        }catch (NullPointerException e){
            System.out.println("Album is empty");
            return null;
        }
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {
        if  (intermediateResult == null)
            return songs.length;
        else
            return songs.length + intermediateResult;
    }

    @Override
    public Album deepClone() {
        Album clone = new Album();
        clone.songs = new String[songs.length];
        for(int i=0;i<songs.length;i++){
            clone.songs[i]=this.songs[i];
        }
        return clone;
    }
}
