package Game.Facade;

import World.Cell;
import World.CellFactory;
import World.Map;

import java.sql.*;

public class SqlDBConnection extends FacadeUtility {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private boolean exists;


    public SqlDBConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cellsquirmermaps", "root", "");

            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        //get MySql DB connection using connection parameters
    }

    public void readMySqlMap(String mapName, Map map) throws SQLException {
        String query;
        exists = false;
        query = "SELECT * FROM `Cells` WHERE MapId = (select MapId from maps where Name = \"" + mapName + "\");";
        resultSet = statement.executeQuery(query);
        resultSet.last();
        int size = resultSet.getRow();
        if(size > 0) {
            int i = 0;
            int j = 0;
            resultSet.beforeFirst();
            Cell[][] cells = new Cell[size][size];
            CellFactory loadMap = new CellFactory();

            while (resultSet.next()) {
                //System.out.print(resultSet.getInt("ColumnName"));
                //System.out.print(resultSet.getString("AnotherColumnName"));
                cells[i][j] = loadMap.makeCell(resultSet.getInt("CellType"), resultSet.getInt("IntX"), resultSet.getInt("IntY"), resultSet.getInt("enemyCount") > 0, resultSet.getInt("enemyCount"));
                if (j == map.getSize() - 1) {
                    i++;
                    j = 0;
                } else
                    j++;
            }
            //get data from table and generate pdf report
            map.changeMap(cells);
        }
        else
            System.out.println("Table not found.");
    }

    public void writeMySqlMap(Map map, String mapName) throws SQLException {
        int i, j;
        int mapId;
        String query;

        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `maps` (`MapId`,`Name`) VALUES (null, ?)");
        pstmt.setString(1, mapName);
        //pstmt.setString(2, info);

        pstmt.executeUpdate();
        //System.out.println("SELECT MapId FROM `maps` WHERE Name = `" + mapName + );
        query = "SELECT * FROM `maps` WHERE Name = \"" + mapName + "\"";

        resultSet = statement.executeQuery(query);
        System.out.println("Getting here");
        resultSet.next();
        mapId = resultSet.getInt("MapId");
        int boolToTiny = 0;

        for (i = 0; i < map.getSize(); i++) {
            for (j = 0; j < map.getSize(); j++) {
                boolToTiny = 0;
                if (map.getCell(i, j).getIsEnemy() == true)
                    boolToTiny = 1;
                //System.out.println("Cell:" + mapId + ", " + map.getCell(i, j).getType() + ", " + map.getCell(i, j).getPositionX() + ", " + map.getCell(i, j).getPositionY() + ", " + map.getCell(i, j).getEnemyCount());
                PreparedStatement pstmt2 = connection.prepareStatement("INSERT INTO `cells` (`CellId`,`MapId`, `CellType`, `IntX`, `IntY`, `EnemyCount`) VALUES (NULL, ?, ?, ?, ?, ?);");
                pstmt2.setInt(1, mapId);
                pstmt2.setInt(2, map.getCell(i, j).getType());
                pstmt2.setInt(3, map.getCell(i, j).getPositionX());
                pstmt2.setInt(4, map.getCell(i, j).getPositionY());
                pstmt2.setInt(5, map.getCell(i, j).getEnemyCount());
                pstmt2.executeUpdate();
            }
        }
    }

}