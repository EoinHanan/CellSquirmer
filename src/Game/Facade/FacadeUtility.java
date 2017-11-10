package Game.Facade;
import World.Map;

import java.sql.SQLException;
import java.util.ArrayList;

public class FacadeUtility implements Facade {

    public FacadeUtility(){

    }

    public void readMap(Map map, String mapName) {
                MapMapper DBcon = new MapMapper();
        try {
            DBcon.readMySqlMap(mapName, map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void writeMap(Map map, String mapName) {
                MapMapper DBcon = new MapMapper();
        try {
            DBcon.writeMySqlMap(map, mapName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMap(Map map, String mapName){
                    MapMapper DBcon = new MapMapper();
        try {
            DBcon.updateMySqlMap(map, mapName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMap(String mapName){
                MapMapper DBcon = new MapMapper();
        try {
            DBcon.deleteMySqlMap(mapName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getMapNames() {
        ArrayList<String> names = new ArrayList<>();
        MapMapper DBcon = new MapMapper();
        try {
            names = DBcon.getMapNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
}

