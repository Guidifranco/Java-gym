package clases;

import baseDatos.InicioBD;
import baseDatos.DNI;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class InicioSesion extends JFrame implements ActionListener {

    //Declaración de variables
    private JLabel ingreso, dni, email, consulta, label_imagen;
    private JTextField field_dni, field_email;
    private JButton ingresar, boton_consulta;
    private InicioBD inicioBD;

    //Constructor
    public InicioSesion() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fuente_titulo = new Font("Arial", Font.BOLD, 24);
        Font fuente_default = new Font("Arial", Font.PLAIN, 14);

        ImageIcon imagen = new ImageIcon("Images/Rev.png");
        label_imagen = new JLabel(imagen);
        label_imagen.setBounds(10, 10, 50, 50);
        add(label_imagen);

        ingreso = new JLabel("Inicia Sesión");
        ingreso.setBounds(125, 60, 200, 30);
        ingreso.setFont(fuente_titulo);
        add(ingreso);

        email = new JLabel("Ingresa tu Email");
        email.setBounds(30, 150, 120, 25);
        email.setFont(fuente_default);
        add(email);

        field_email = new JTextField();
        field_email.setBounds(30, 180, 150, 25);
        add(field_email);

        dni = new JLabel("Ingresa tu DNI");
        dni.setBounds(220, 150, 150, 25);
        dni.setFont(fuente_default);
        add(dni);

        field_dni = new JTextField();
        field_dni.setBounds(220, 180, 150, 25);
        add(field_dni);

        ingresar = new JButton("Ingresar");
        ingresar.setBounds(110, 250, 180, 30);
        ingresar.addActionListener(this);
        add(ingresar);

        consulta = new JLabel("No estás registrado?");
        consulta.setBounds(130, 340, 200, 25);
        consulta.setFont(fuente_default);
        add(consulta);

        boton_consulta = new JButton("Registrate");
        boton_consulta.setBounds(110, 370, 180, 30);
        boton_consulta.addActionListener(this);
        add(boton_consulta);

        inicioBD = new InicioBD();
    }

    //Funcionalidad
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == ingresar) {
                if (field_email.getText().isEmpty() || field_dni.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe completar los campos para iniciar sesión", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String dni = field_dni.getText();
                    String email = field_email.getText();

                    // Verificar DNI y email con la base de datos
                    if (inicioBD.verificarCampos(dni, email)) {
                        DNI.iniciarSesion(dni);  // Guardamos el DNI

                        JOptionPane.showMessageDialog(null, "Sesión iniciada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                        // Traslado hacia el menú
                        Menu interfaz = new Menu();
                        interfaz.setBounds(0, 0, 950, 725);
                        interfaz.setVisible(true);
                        interfaz.setResizable(false);
                        interfaz.setLocationRelativeTo(null);

                        this.setVisible(false);
                    } else {
                        // Mensaje de error ya escrito en InicioBD.verificarCampos
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No es posible acceder a la interfaz, problema de ruta");
        }

        try {
            if (e.getSource() == boton_consulta) {
                Registro interfaz = new Registro();
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
        InicioSesion interfaz = new InicioSesion();
        interfaz.setBounds(0, 0, 400, 535);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
    }
}
