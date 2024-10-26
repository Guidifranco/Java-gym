package clases;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class Menu extends JFrame implements ActionListener {

    //Declaración de variables
    private JLabel titulo, label_imagen;
    private JButton membresias, clases, historial, contacto;

    //Constructor
    public Menu() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Font fuente_titulo = new Font("Verdana", Font.BOLD, 32);
        Font fuente_subtitulo = new Font("Times New Roman", Font.BOLD, 24);
        
        ImageIcon imagen = new ImageIcon("Images/Rev.png");
        label_imagen = new JLabel(imagen);
        label_imagen.setBounds(10, 10, 150, 150);
        add(label_imagen);
        
        titulo = new JLabel("REVOLUTION GYM");
        titulo.setBounds(295, 125, 350, 55);
        titulo.setFont(fuente_titulo);
        add(titulo);
        
        membresias = new JButton("MEMBRESIAS");
        membresias.setBounds(275, 250, 155, 75);
        membresias.addActionListener(this);
        add(membresias);
        
        clases = new JButton("CLASES");
        clases.setBounds(275, 400, 155, 75);
        clases.addActionListener(this);
        add(clases);
        
        historial = new JButton("HISTORIAL");
        historial.setBounds(475, 250, 155, 75);
        historial.addActionListener(this);
        add(historial);
        
        contacto = new JButton("CONTACTO");
        contacto.setBounds(475, 400, 155, 75);
        contacto.addActionListener(this);
        add(contacto);
        
    }
    //Funcionalidad

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == historial) {
            JOptionPane.showMessageDialog(null, "Estamos trabajando en ello", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (e.getSource() == contacto) {
            JOptionPane.showMessageDialog(null, "Estamos trabajando en ello", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        
        try {
            if (e.getSource() == clases) {
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
        
        try {
            if (e.getSource() == membresias) {
            Membresias interfaz = new Membresias();
            interfaz.setBounds(0, 0, 950, 725);
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
        Menu interfaz = new Menu();
        interfaz.setBounds(0, 0, 950, 725);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
    }
    
}
