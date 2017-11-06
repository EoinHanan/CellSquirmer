package Game.Facade;


import java.sql.Connection;

public class MongoDBConnection {
    //private Connection connection;
    //private Statement statement;
    //private ResultSet resultSet;
    //private PreparedStatement preparedStatement;
    public MongoDBConnection(){
        try {

            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //connection = DriverManager.getConnection(
            //        "jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
            //statement = connection.createStatement();

        } catch (Exception e) {

            System.out.println(e);
            e.printStackTrace();
        }

    }

    public void readOracleMap(String tableName, Connection con){
        //get data from table and generate pdf report
    }

    public void generateOracleHTMLReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }
}
