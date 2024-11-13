package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gym";
    private static final String USUARIO = "root";  // no tengo usuario 
    private static final String CONTRASEÑA = "";  // no tengo contraseña
    private static Connection conexion = null;

    // Método para obtener la conexión
    public static Connection getConnection() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
                System.out.println("Conexión exitosa a la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }

}
