package Game.Facade;
import World.Map;

import java.sql.Connection;
import java.sql.SQLException;

public class FacadeUtility {

    public FacadeUtility(){

    }

        public static void readMap(String dbType, Map map, String mapName) throws SQLException {
            //Connection con;
            //Map map;
            //map = play.getMap();
           if(dbType.equals("mysql")){
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

    public static void writeMap(String dbType, Map map, String mapName) throws SQLException {
        //Connection con = null;
        if(dbType.equals("mysql")) {
                SqlDBConnection DBcon = new SqlDBConnection();
                //con = DBcon.getConnection();
                DBcon.writeMySqlMap(map, mapName);
        }
    }

        /*public static enum DBTypes{
            MYSQL,ORACLE;
        }*/
    }

