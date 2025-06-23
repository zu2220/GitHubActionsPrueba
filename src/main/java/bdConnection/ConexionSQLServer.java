package bdConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {
    public Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=prueba;encrypt=false;";
        String user = "sa";  // o el usuario configurado
        String password = "camote";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexión exitosa a SQL Server");
            }
            return conn;
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
        return null;
    }
}
