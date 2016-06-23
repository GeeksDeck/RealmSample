package net.geeksdeck.realmsample.model;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Required;


public class Building extends RealmObject {

    /**
     * Realm supports:
     * - fields with public, private and protected access.
     * - primitive type fields(int, long etc.) and boxed types (Integer, Long etc.)
     * - types which extends RealmObjects/RealmList< ? extends RealmObject>
     * - null values
     */

    protected RealmList<Room> rooms;
    private Address address;
    /**
     * With Realm we can Annotate that this field cannot be null, like android @NonNull
     */
    @Required
    public String name;

    public String getName() {
        return name;
    }

    public RealmList<Room> getRooms() {
        return rooms;
    }

    /**
     * Get List of Rooms for passed parameter
     * @param onlyOccupied - determinate either list will contain only occupied or free rooms
     * @return - list of rooms
     */
    public List<Room> getSpecificRooms(boolean onlyOccupied){
        List<Room> result = new ArrayList<>();
        for(Room room : rooms){
            if(onlyOccupied == room.isOccupied()) result.add(room);
        }
        return result;
    }

    public static List<Building> getBuildingsWithMinRoomsCount(Realm realm, int count){
        RealmResults<Building> results = realm.where(Building.class).greaterThan("rooms", count).findAll();
        return results.subList(0, results.size()-1);
    }

}
