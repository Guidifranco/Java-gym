package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InicioBD {
    private Connection cn;

    public InicioBD() {
        // conexión proporcionada por ConexionBD
        this.cn = ConexionBD.getConnection();
    }

    // Método para verificar que el DNI y el email coincidan en la base de datos
    public boolean verificarCampos(String dni, String email) {
        String sql = "SELECT Email FROM cliente WHERE DNI_cliente = ?";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) { // Si existe el DNI
                String emailEnBD = rs.getString("Email");
                
                // Comparamos el email recuperado con el proporcionado
                if (emailEnBD.equals(email)) {
                    DNI.iniciarSesion(dni);
                    return true;  // Coinciden
                } else {
                    JOptionPane.showMessageDialog(null, "El email proporcionado no coincide con el registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El DNI no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar DNI y email: " + e.getMessage());
            return false;
        }
    }
}
