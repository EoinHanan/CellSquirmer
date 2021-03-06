package Facade;
import World.Map;

import java.sql.SQLException;
import java.util.ArrayList;

public class FacadeUtility {

    public FacadeUtility(){

    }

    public static void readMap(Map map, String mapName) throws SQLException {
                MapMapper DBcon = new MapMapper();
                DBcon.readMySqlMap(mapName, map);
    }


    public static void writeMap(Map map, String mapName) throws SQLException {
                MapMapper DBcon = new MapMapper();
                DBcon.writeMySqlMap(map, mapName);
    }

    public static void updateMap(Map map, String mapName)throws SQLException{
                    MapMapper DBcon = new MapMapper();
                    DBcon.updateMySqlMap(map, mapName);
    }

    public static void deleteMap(String mapName) throws SQLException{
                MapMapper DBcon = new MapMapper();
                DBcon.deleteMySqlMap(mapName);
    }
    public static ArrayList<String> getMapNames() throws SQLException {
        MapMapper DBcon = new MapMapper();
        return DBcon.getMapNames();
    }
}

