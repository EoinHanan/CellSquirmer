package Facade;

import World.Cell;
import World.CellFactory;
import World.Map;

import java.sql.*;
import java.util.ArrayList;

public class MapMapper {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;



    public MapMapper() {

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

    public void updateMySqlMap(Map map, String mapName) throws SQLException {
        String query;
        int i, j;
        query = "SELECT MapId FROM maps WHERE Name = \"" + mapName + "\";";
        resultSet = statement.executeQuery(query);
        resultSet.last();
        int mapId = resultSet.getInt("MapId");
        for (i = 0; i < map.getSize(); i++) {
            for (j = 0; j < map.getSize(); j++) {
                //query = "UPDATE `cells` SET 'EnemyCount' = \"" + map.getCell(i,j).getEnemyCount() + "\" WHERE 'CellId' = " + resultSet.getInt("MapId") + " AND 'IntX' = " + map.getCell(i, j).getPositionX() + " AND 'IntY' = " + map.getCell(i, j).getPositionY() +";";
                query = "UPDATE `cells` SET `EnemyCount` = " + map.getCell(i,j).getEnemyCount() + " WHERE `CellId` = (SELECT `CellId` where `MapId` = " + mapId + " AND `IntX` = " + map.getCell(i, j).getPositionX()+ " AND `IntY` = " + map.getCell(i, j).getPositionY() +")";
                try {
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void deleteMySqlMap(String mapName) throws SQLException{
        String queryCell, queryMap;
        queryCell = "DELETE FROM `cells` WHERE MapId = (select MapId from maps where Name = \"" + mapName + "\");";
        queryMap = "DELETE FROM `maps` WHERE MapId = (select MapId where Name = \"" + mapName + "\");";

        statement.executeUpdate(queryCell);
        statement.executeUpdate(queryMap);
    }

    public ArrayList<String> getMapNames() throws SQLException {
        ArrayList<String> mapNames = new ArrayList<>();
        String query;
        query = "SELECT Name FROM maps;";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            mapNames.add(resultSet.getString("Name"));
        }

        return mapNames;
    }
}
