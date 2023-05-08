package DataObjects.DBConnection;
import java.sql.*;

public class mainPruebas {

	public static void main(String[] args) {
		Connection connect = ConnectionDB.getConnection();
		if(connect!=null) {
			System.out.println("Conexion establecida");
		}else {
			System.out.println("Error");
		}

	}

}
