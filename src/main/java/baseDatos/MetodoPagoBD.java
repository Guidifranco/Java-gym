package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MetodoPagoBD {
    private Connection cn;


   public MetodoPagoBD() {
        //conexión proporcionada por ConexionDB
         this.cn = ConexionBD.getConnection();
    }
   
    // Método para insertar datos en la tabla metodo_de_pago
    public void insertarMetodoPago(String NombreTitular, String FechaVencimiento, String NumeroTarjeta, 
                                   String CodigoSeguridad, double Monto) {
        String sql = "INSERT INTO metodo_de_pago (NombreTitular, FechaVencimiento, NumeroTarjeta, CodigoSeguridad, Monto) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            // Establecemos los valores 
            pst.setString(1, NombreTitular);
            pst.setString(2, FechaVencimiento);
            pst.setString(3, NumeroTarjeta);
            pst.setString(4, CodigoSeguridad);
            pst.setDouble(5, Monto);

          
            int insertado = pst.executeUpdate();   //Para corroborar que se insertaron los datos en la BD
            if (insertado > 0) {
                JOptionPane.showMessageDialog(null, "Método de pago registrado exitosamente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el método de pago: " + e.getMessage());
        }
    }
    
        // Método para guardar el idMembresia en la base de datos
    public void guardarMembresia(int idMembresia) {
        String query = "INSERT INTO membresia (idMembresia) VALUES (?)";  

        try (PreparedStatement pst = cn.prepareStatement(query)) {
            pst.setInt(1, idMembresia);

            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Membresía guardada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la membresía.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        }
    }
}