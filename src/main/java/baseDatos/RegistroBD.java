package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class RegistroBD {
    private Connection cn;


   public RegistroBD() {
        //conexión proporcionada por ConexionDB
         this.cn = ConexionBD.getConnection();
    }

       // Método para verificar si un DNI ya está registrado
    private boolean dniExiste(String dni) {
        String sql = "SELECT 1 FROM cliente WHERE DNI_cliente = ?";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            return rs.next();  // Si hay un resultado, el DNI ya existe
        } catch (SQLException e) {
            System.out.println("Error al verificar si el DNI existe: " + e.getMessage());
            return false;
        }
    }

    // Método para registrar un nuevo cliente en la tabla Clientes
    public boolean registrarCliente(String dni, String nombre, String apellido, String fechaNacimiento, String direccion, String email) {
        // Primero verificamos si el DNI ya está en la base de datos
        if (dniExiste(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI ya está registrado. No se puede registrar el cliente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Si el DNI no existe, realizamos el registro del cliente
        String sql = "INSERT INTO Cliente (DNI_cliente, Nombre, Apellido, FechaNacimiento, Direccion, Email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, dni);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, fechaNacimiento);
            pst.setString(5, direccion);
            pst.setString(6, email);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Iniciar la sesión con el DNI registrado
            DNI.iniciarSesion(dni);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Inserte correctamente la fecha de naciemiento año-mes-dia");
            System.out.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    // Método para iniciar sesión con un DNI existente
    public boolean iniciarSesion(String dni) {
        if (dniExiste(dni)) {
            DNI.iniciarSesion(dni);
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "DNI no registrado. Por favor, regístrese.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}