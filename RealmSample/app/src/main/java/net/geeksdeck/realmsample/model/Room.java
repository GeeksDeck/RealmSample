package net.geeksdeck.realmsample.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Room extends RealmObject {

    @PrimaryKey
    public int number;
    private boolean occupied;


    public boolean isOccupied(){
        return occupied;
    }
}
