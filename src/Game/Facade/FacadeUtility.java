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
}

