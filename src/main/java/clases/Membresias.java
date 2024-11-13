package clases;

import baseDatos.MetodoPagoBD; 
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class Membresias extends JFrame implements ActionListener {

    //Declaración de variables
    private JLabel titulo, gym3, gym_libre, funcional;
    private JButton boton_home, boton_clases, boton_historial, boton_contacto, boton_gym3, boton_gym_libre, boton_funcional;
    private JTextArea area_gym3, area_gym_libre, area_funcional;
    

    //Constructor
    public Membresias() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fuente_titulo = new Font("Verdana", Font.BOLD, 32);
        Font fuente_subtitulo = new Font("Times New Roman", Font.ITALIC, 24);
        Font fuente_default = new Font("Arial", Font.PLAIN, 14);

        titulo = new JLabel("Seleccioná una membresía");
        titulo.setBounds(210, 125, 500, 70);
        titulo.setFont(fuente_titulo);
        add(titulo);

        boton_home = new JButton("Inicio");
        boton_home.setBounds(50, 40, 180, 40);
        boton_home.addActionListener(this);
        add(boton_home);

        boton_clases = new JButton("Reservar clase");
        boton_clases.setBounds(260, 40, 180, 40);
        boton_clases.addActionListener(this);
        add(boton_clases);

        boton_historial = new JButton("Historial de pagos");
        boton_historial.setBounds(470, 40, 180, 40);
        boton_historial.addActionListener(this);
        add(boton_historial);

        boton_contacto = new JButton("Contacto");
        boton_contacto.setBounds(680, 40, 180, 40);
        boton_contacto.addActionListener(this);
        add(boton_contacto);

        // Primera tarjeta
        gym3 = new JLabel("Gimnasio 3 dias a la semana");
        gym3.setBounds(20, 220, 300, 30); // Columna 1
        gym3.setFont(fuente_subtitulo);
        add(gym3);

        area_gym3 = new JTextArea("3 Dias de musculación a elección y acceso"
                + " a rutinas personalizadas por nuestros entrenadores");
        area_gym3.setBounds(50, 260, 200, 250);
        area_gym3.setFont(fuente_default);
        area_gym3.setLineWrap(true);
        area_gym3.setWrapStyleWord(true); //que no corte las palabras
        area_gym3.setEditable(false);
        add(area_gym3);

        boton_gym3 = new JButton("Elegir");
        boton_gym3.setBounds(150, 530, 100, 30);
        boton_gym3.addActionListener(this);
        add(boton_gym3);

        // Segunda tarjeta
        gym_libre = new JLabel("Gimnasio libre todos los días.");
        gym_libre.setBounds(335, 220, 300, 30); 
        gym_libre.setFont(fuente_subtitulo);
        add(gym_libre);

        area_gym_libre = new JTextArea("6 Dias de musculación a elección y acceso"
                + " a rutinas personalizadas por nuestros entrenadores");
        area_gym_libre.setBounds(370, 260, 200, 250);
        area_gym_libre.setFont(fuente_default);
        area_gym_libre.setLineWrap(true); 
        area_gym_libre.setWrapStyleWord(true); //que no corte las palabras
        area_gym_libre.setEditable(false);
        add(area_gym_libre);

        boton_gym_libre = new JButton("Elegir");
        boton_gym_libre.setBounds(470, 530, 100, 30);
        boton_gym_libre.addActionListener(this);
        add(boton_gym_libre);

        // Tercera tarjeta
        funcional = new JLabel("Funcional");
        funcional.setBounds(740, 220, 300, 30); 
        funcional.setFont(fuente_subtitulo);
        add(funcional);

        area_funcional = new JTextArea("Clases de funcional con disponibilidad horaria"
                + " y reserva a gusto");
        area_funcional.setBounds(690, 260, 200, 250);
        area_funcional.setFont(fuente_default);
        area_funcional.setLineWrap(true);
        area_funcional.setWrapStyleWord(true); //que no corte las palabras
        area_funcional.setEditable(false);
        add(area_funcional);

        boton_funcional = new JButton("Elegir");
        boton_funcional.setBounds(760, 530, 100, 30);
        boton_funcional.addActionListener(this);
        add(boton_funcional);
   
    }
    //Funcionalidad

    @Override
    public void actionPerformed(ActionEvent e) {

        //Menu
        try {
            if (e.getSource() == boton_home) {
                Menu interfaz = new Menu();
                interfaz.setBounds(0, 0, 950, 725);
                interfaz.setVisible(true);
                interfaz.setResizable(false);
                interfaz.setLocationRelativeTo(null);

                this.setVisible(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No es posible acceder a la interfaz, problema de ruta");
        }

        //Clases
        try {
            if (e.getSource() == boton_clases) {
                Clases interfaz = new Clases();
                interfaz.setBounds(0, 0, 950, 725);
                interfaz.setVisible(true);
                interfaz.setResizable(false);
                interfaz.setLocationRelativeTo(null);

                this.setVisible(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No es posible acceder a la interfaz, problema de ruta");
        }

        //Historial
        if (e.getSource() == boton_historial) {
            JOptionPane.showMessageDialog(null, "Estamos trabajando en ello", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        //Contacto
        if (e.getSource() == boton_contacto) {
            JOptionPane.showMessageDialog(null, "Estamos trabajando en ello", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        if(e.getSource() == boton_gym3 || e.getSource() == boton_funcional || e.getSource() == boton_gym_libre ){ 
            
            MetodoPago interfaz = new MetodoPago();
            interfaz.setBounds(0, 0, 950, 725);
            interfaz.setVisible(true);
            interfaz.setResizable(false);
            interfaz.setLocationRelativeTo(null);

            this.setVisible(false);
        }
       

    }

    //Main
    public static void main(String args[]) {
        Membresias interfaz = new Membresias();
        interfaz.setBounds(0, 0, 950, 725);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
    }

}
