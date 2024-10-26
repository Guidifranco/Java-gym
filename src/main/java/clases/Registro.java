package clases;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class Registro extends JFrame implements ActionListener {

    //Declaración de variables
    private JLabel registro, nombre, apellido, direccion, dni, fecha_nacimiento, email, consulta, label_imagen;
    private JButton registrar, ingresar;
    private JTextField field_nombre, field_apellido, field_dni, field_direccion, field_fecha, field_email;

    //Constructor
    public Registro() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fuente_titulo = new Font("Arial", Font.BOLD, 24);
        Font fuente_default = new Font("Arial", Font.PLAIN, 14);

        ImageIcon imagen = new ImageIcon("Images/Rev.png");
        label_imagen = new JLabel(imagen);
        label_imagen.setBounds(10, 10, 50, 50);
        add(label_imagen);

        registro = new JLabel("Registrate");
        registro.setBounds(135, 45, 200, 30);
        registro.setFont(fuente_titulo);
        add(registro);

        nombre = new JLabel("Nombre");
        nombre.setBounds(30, 95, 100, 25);
        nombre.setFont(fuente_default);
        add(nombre);

        apellido = new JLabel("Apellido");
        apellido.setBounds(30, 165, 100, 25);
        apellido.setFont(fuente_default);
        add(apellido);

        email = new JLabel("Email");
        email.setBounds(225, 235, 100, 25);
        email.setFont(fuente_default);
        add(email);

        direccion = new JLabel("Direccion");
        direccion.setBounds(225, 95, 100, 25);
        direccion.setFont(fuente_default);
        add(direccion);

        dni = new JLabel("DNI");
        dni.setBounds(30, 235, 100, 25);
        dni.setFont(fuente_default);
        add(dni);

        fecha_nacimiento = new JLabel("Fecha de nacimiento");
        fecha_nacimiento.setBounds(225, 165, 150, 25);
        fecha_nacimiento.setFont(fuente_default);
        add(fecha_nacimiento);

        consulta = new JLabel("Ya estas registrado?");
        consulta.setBounds(135, 390, 200, 25);
        consulta.setFont(fuente_default);
        add(consulta);

        registrar = new JButton("Registrar");
        registrar.setBounds(125, 345, 150, 30);
        registrar.addActionListener(this);
        add(registrar);

        ingresar = new JButton("Iniciar Sesión");
        ingresar.setBounds(140, 415, 120, 20);
        ingresar.addActionListener(this);
        add(ingresar);

        field_nombre = new JTextField();
        field_nombre.setBounds(30, 125, 150, 25);
        add(field_nombre);

        field_apellido = new JTextField();
        field_apellido.setBounds(30, 195, 150, 25);
        add(field_apellido);

        field_dni = new JTextField();
        field_dni.setBounds(30, 265, 150, 25);
        add(field_dni);

        field_direccion = new JTextField();
        field_direccion.setBounds(225, 125, 150, 25);
        add(field_direccion);

        field_fecha = new JTextField();
        field_fecha.setBounds(225, 195, 150, 25);
        add(field_fecha);

        field_email = new JTextField();
        field_email.setBounds(225, 265, 150, 25);
        add(field_email);

    }

    //Funcionalidad
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == registrar) {

                // Si algún campo está vacío, mostramos el mensaje de error
                if (field_nombre.getText().isEmpty() || field_apellido.getText().isEmpty() || field_dni.getText().isEmpty()
                        || field_direccion.getText().isEmpty() || field_fecha.getText().isEmpty() || field_email.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Debes completar todos los campos para registrarte", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Si todos los campos están completos, registramos el usuario
                    JOptionPane.showMessageDialog(null, "Registro exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    //traslado hacia el menú
                    Menu interfaz = new Menu();
                    interfaz.setBounds(0, 0, 950, 725);
                    interfaz.setVisible(true);
                    interfaz.setResizable(false);
                    interfaz.setLocationRelativeTo(null);

                    this.setVisible(false);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No es posible acceder a la interfaz, problema de ruta");
        }

        //Boton de inicio de sesión
        try {
            if (e.getSource() == ingresar) {
                InicioSesion interfaz = new InicioSesion();
                interfaz.setBounds(0, 0, 400, 535);
                interfaz.setVisible(true);
                interfaz.setResizable(false);
                interfaz.setLocationRelativeTo(null);

                this.setVisible(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No es posible acceder a la interfaz, problema de ruta");
        }

    }
    //Main

    public static void main(String args[]) {
        Registro interfaz = new Registro();
        interfaz.setBounds(0, 0, 400, 535);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
    }
}
