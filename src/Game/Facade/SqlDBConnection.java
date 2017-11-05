package Game.Facade;

import World.Cell;
import World.CellFactory;
import World.Map;

import java.sql.*;

public class SqlDBConnection {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public SqlDBConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CellSquirmerMap", "root", "");

            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        //get MySql DB connection using connection parameters
    }

    public Cell[][] readMySqlMap(String mapName, Map map) throws SQLException {
        String query;
        query = "SELECT * FROM `Cells` WHERE MapId = (select MapId from map where name = " + mapName + ");";
        resultSet = statement.executeQuery(query);
        resultSet.last();
        int size = resultSet.getRow();
        int i = 0;
        int j = 0;
        resultSet.beforeFirst();
        Cell[][] cells = new Cell[size][size];
        CellFactory loadMap = new CellFactory();

        while (resultSet.next()){
                //System.out.print(resultSet.getInt("ColumnName"));
                //System.out.print(resultSet.getString("AnotherColumnName"));
                cells[i][j] = loadMap.makeCell(resultSet.getInt("CellType"), resultSet.getInt("XValue"), resultSet.getInt("YValue"), resultSet.getBoolean("createEnemy"), resultSet.getInt("enemyCount"));

            if (j == map.getSize() - 1)
            {
                i++;
                j = 0;
            }
            else
                j++;
        }
        //get data from table and generate pdf report
        return cells;
    }

    public void writeMySqlMap(Map map, String mapName) throws SQLException {
        int i, j;
        int mapId;
        String query;

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `table` (`mapId`,`mapName`) VALUES (?, ?)");
            pstmt.setString(2, mapName);
            //pstmt.setString(2, info);

            pstmt.executeUpdate();

        query = "SELECT MapId FROM `maps` WHERE Name = " + mapName;

        resultSet = statement.executeQuery(query);
        mapId = resultSet.getInt("MapId");

        for(i = 0; i < map.getSize(); i++){
            for(j = 0; j < map.getSize(); j++){
                PreparedStatement pstmt2 = connection.prepareStatement("INSERT INTO `table` ('CellId',`MapId`, `CellType`, `IntX`, `IntY`, `CreateEnemy`, `EnemyCount`, `mapName`) VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
