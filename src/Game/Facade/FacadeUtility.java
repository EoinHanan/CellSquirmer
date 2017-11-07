package Game.Facade;
import World.Map;

import java.sql.SQLException;

public class FacadeUtility {

    public FacadeUtility(){

    }

    public static void readMap(Map map, String mapName) throws SQLException {
                SqlDBConnection DBcon = new SqlDBConnection();
                DBcon.readMySqlMap(mapName, map);
    }


    public static void writeMap(Map map, String mapName) throws SQLException {
                SqlDBConnection DBcon = new SqlDBConnection();
                DBcon.writeMySqlMap(map, mapName);
    }

    public static void updateMap(Map map, String mapName)throws SQLException{
                    SqlDBConnection DBcon = new SqlDBConnection();
                    DBcon.updateMySqlMap(map, mapName);
    }

    public static void deleteMap(String mapName) throws SQLException{
                SqlDBConnection DBcon = new SqlDBConnection();
                DBcon.deleteMySqlMap(mapName);
    }
}

