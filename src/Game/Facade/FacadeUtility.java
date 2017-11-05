package Game.Facade;
import World.Map;

import java.sql.Connection;
import java.sql.SQLException;

public class FacadeUtility {

        public static void readMap(DBTypes dbType, int mapId, String mapName, Map map) throws SQLException {
            Connection con;
            //Map map;
            //map = play.getMap();
            switch (dbType){
                case MYSQL:
                    SqlDBConnection DBcon = new SqlDBConnection();
                    //con = DBcon.getConnection();
                    map.changeMap(DBcon.readMySqlMap(mapName, map));

                /*case ORACLE:
                 *  con = OracleHelper.getOracleDBConnection();
                 *   OracleHelper oracleHelper = new OracleHelper();
                 *   switch(reportType){
                 *
                 *        case HTML:
                            oracleHelper.generateOracleHTMLReport(tableName, con);
                            break;
                        case PDF:
                            oracleHelper.generateOraclePDFReport(tableName, con);
                            break;
                    }
                   break;*/
            }
        }

    public static void writeMap(DBTypes dbType, Map map) throws SQLException {
        Connection con = null;
        switch (dbType) {
            case MYSQL:
                SqlDBConnection DBcon = new SqlDBConnection();
                con = DBcon.getConnection();

                DBcon.writeMySqlMap(map);
        }
    }

        public static enum DBTypes{
            MYSQL,ORACLE;
        }

        public static enum ReportTypes{
            HTML,PDF;
        }
    }

