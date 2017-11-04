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

    public Cell[] readMySqlMap(String mapName, int mapId) throws SQLException {
        String query;
        query = "SELECT * FROM `Cells` WHERE" + mapId + " = (select" + mapId + "from map where name = " + mapName + ");";
        resultSet = statement.executeQuery(query);
        resultSet.last();
        int size = resultSet.getRow();
        int i = 0;
        resultSet.beforeFirst();
        Cell[] cells = new Cell[size];
        CellFactory loadMap = new CellFactory();

        while (resultSet.next()){
            //System.out.print(resultSet.getInt("ColumnName"));
            //System.out.print(resultSet.getString("AnotherColumnName"));
            cells[i] = loadMap.makeCell(resultSet.getInt("CellType") , resultSet.getInt("XValue"),resultSet.getInt("YValue"), resultSet.getBoolean("createEnemy"), resultSet.getInt("enemyCount"));

            i++;
        }
        //get data from table and generate pdf report
        return cells;
    }

    public void writeMySqlMap(Map map){
        try{
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO `table` (`id`,`Info`) VALUES (?, ?)");
            pstmt.setInt(1, 1);
            //pstmt.setString(2, info);

            pstmt.executeUpdate();
        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
