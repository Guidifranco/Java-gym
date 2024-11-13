package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class ClaseBD {

    private Connection cn;

    public ClaseBD() {
        this.cn = ConexionBD.getConnection();
    }

    // Método para reservar la clase
    public void registrarReservaClase() {
        
        String sql = "INSERT INTO reserva_clases (Fecha_reserva, DNI_Cliente) VALUES (?, ?)";

        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            // Establecemos la fecha actual en la columna Fecha_reserva
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            pst.setTimestamp(1, fechaActual);

            // Obtenemos el DNI del cliente
            String dniCliente = DNI.obtenerDniCliente();
            if (dniCliente == null) {
                JOptionPane.showMessageDialog(null, "Error: No se ha iniciado sesión.");
                return;
            }
            pst.setString(2, dniCliente);

            
            int filasInsertadas = pst.executeUpdate();

            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "Reserva de clase registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la reserva de clase.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
            
        }
    }
}
