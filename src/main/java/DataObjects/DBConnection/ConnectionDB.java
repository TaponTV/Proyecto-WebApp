package DataObjects.DBConnection;

import java.sql.*;

public class ConnectionDB {
	

	private static String user = "postgres";
    private static String pswd = "root123";
    private static String bd = "petcoloria_webapp";
    private static String server = "jdbc:postgresql://localhost:5432/" + bd;
    private static String driver = "org.postgresql.Driver";
    
    public static Connection getConnection(){
    	try {
    		Class.forName(driver);
    		return DriverManager.getConnection(server, user, pswd);
    	}catch(SQLException ex) {
    		System.out.println("Error to connect database: \n"+ex);
    	}catch(ClassNotFoundException ex) {
    		System.out.println(ex);
    	}
    	return null;
    }
    
    protected static void closeDB(ResultSet result){
        try {
            result.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected static void closeDB(Statement state){
        try {
            state.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected static void closeDB(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
}
