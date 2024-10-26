package clases;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class MetodoPago extends JFrame implements ActionListener {
    //Declaración de variables

    private JLabel titulo, nombre, fechaVencimiento, numeroTarjeta, codigoSeguridad, monto;
    private JTextField field_nombre, field_vencimiento, field_num_tarjeta, field_codigo, field_monto;
    private JButton pagar;

    //Constructor
    public MetodoPago() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fuente_titulo = new Font("Arial", Font.BOLD, 32);
        Font fuente_default = new Font("Arial", Font.PLAIN, 14);

        titulo = new JLabel("Método de pago");
        titulo.setBounds(335, 110, 250, 40);
        titulo.setFont(fuente_titulo);
        add(titulo);

        nombre = new JLabel("Nombre Titular");
        nombre.setBounds(300, 250, 100, 25);
        nombre.setFont(fuente_default);
        add(nombre);

        field_nombre = new JTextField();
        field_nombre.setBounds(300, 280, 150, 25);
        add(field_nombre);

        fechaVencimiento = new JLabel("Fecha de vencimiento");
        fechaVencimiento.setBounds(300, 330, 150, 25);
        fechaVencimiento.setFont(fuente_default);
        add(fechaVencimiento);

        field_vencimiento = new JTextField();
        field_vencimiento.setBounds(300, 360, 150, 25);
        add(field_vencimiento);

        numeroTarjeta = new JLabel("Numero de la tarjeta");
        numeroTarjeta.setBounds(495, 250, 150, 25);
        numeroTarjeta.setFont(fuente_default);
        add(numeroTarjeta);

        field_num_tarjeta = new JTextField();
        field_num_tarjeta.setBounds(495, 280, 150, 25);
        add(field_num_tarjeta);

        codigoSeguridad = new JLabel("Código de seguridad");
        codigoSeguridad.setBounds(495, 330, 150, 25);
        codigoSeguridad.setFont(fuente_default);
        add(codigoSeguridad);

        field_codigo = new JTextField();
        field_codigo.setBounds(495, 360, 150, 25);
        add(field_codigo);

        monto = new JLabel("Monto a pagar");
        monto.setBounds(405, 430, 150, 25);
        monto.setFont(fuente_default);
        add(monto);

        field_monto = new JTextField();
        field_monto.setBounds(400, 460, 150, 25);
        add(field_monto);

        pagar = new JButton("Pagar");
        pagar.setBounds(580, 460, 100, 25);
        pagar.addActionListener(this);
        add(pagar);

    }

    //Funcionalidad
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == pagar) {
                if (field_nombre.getText().isEmpty() || field_vencimiento.getText().isEmpty()
                        || field_num_tarjeta.getText().isEmpty() || field_codigo.getText().isEmpty()
                        || field_monto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Pago confirmado", "Éxito", JOptionPane.INFORMATION_MESSAGE);

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

    }

    //Main
    public static void main(String args[]) {
        MetodoPago interfaz = new MetodoPago();
        interfaz.setBounds(0, 0, 950, 725);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
    }
}
