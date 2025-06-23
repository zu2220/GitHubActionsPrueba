package dao;

import bdConnection.ConexionSQLServer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;

public class ClientsDAO {

    public static void main( String[] args) {
        ConexionSQLServer conn = new ConexionSQLServer();
        try {
            Statement stmt = conn.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("exec CreateJSONFromClientes");

            if(rs.next()){
                String json = rs.getString(1);
                System.out.println(json);
                try{
                    FileWriter file = new FileWriter("clientes.json");
                    file.write(json);
                    file.close();
                    System.out.println("JSON exportado exitosamente a clientes.json");
                }catch (IOException e){
                    System.err.println("Error al escribir el archivo: " + e.getMessage());
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
