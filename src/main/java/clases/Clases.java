package clases;

import baseDatos.ClaseBD;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class Clases extends JFrame implements ActionListener {

    //Declaración de variables
    private JLabel titulo, lunes, martes, miercoles, jueves, viernes, sabado;
    private JButton boton_membresia, boton_inicio, boton_historial, boton_contacto, boton_reserva, horario_l1,
            horario_l2, horario_l3, horario_l4, horario_l5, horario_l6, horario_ma1, horario_ma2,
            horario_ma3, horario_ma4, horario_ma5, horario_ma6, horario_mi1, horario_mi2, horario_mi3,
            horario_mi4, horario_mi5, horario_mi6, horario_j1, horario_j2, horario_j3, horario_j4,
            horario_j5, horario_j6, horario_v1, horario_v2, horario_v3, horario_v4, horario_v5, horario_v6,
            horario_s1, horario_s2, horario_s3, horario_s4, horario_s5, horario_s6;
    private ClaseBD claseBD;

//Constructor
    public Clases() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fuente_titulo = new Font("Arial", Font.BOLD, 32);
        Font fuente_subtitulo = new Font("Arial", Font.BOLD, 24);
        Font fuente_default = new Font("Arial", Font.PLAIN, 14);

        boton_inicio = new JButton("Inicio");
        boton_inicio.setBounds(50, 40, 180, 40);
        boton_inicio.addActionListener(this);
        add(boton_inicio);

        boton_membresia = new JButton("Elegir Membresía");
        boton_membresia.setBounds(260, 40, 180, 40);
        boton_membresia.addActionListener(this);
        add(boton_membresia);

        boton_historial = new JButton("Historial de pagos");
        boton_historial.setBounds(470, 40, 180, 40);
        boton_historial.addActionListener(this);
        add(boton_historial);

        boton_contacto = new JButton("Contacto");
        boton_contacto.setBounds(680, 40, 180, 40);
        boton_contacto.addActionListener(this);
        add(boton_contacto);

        boton_reserva = new JButton("Reservar");
        boton_reserva.setBounds(790, 600, 90, 30);
        boton_reserva.addActionListener(this);
        add(boton_reserva);

        titulo = new JLabel("Selecciona tu clase");
        titulo.setBounds(300, 110, 350, 50);
        titulo.setFont(fuente_titulo);
        add(titulo);

        lunes = new JLabel("Lunes");
        lunes.setBounds(30, 220, 100, 30);
        lunes.setFont(fuente_subtitulo);
        add(lunes);

        martes = new JLabel("Martes");
        martes.setBounds(30, 320, 100, 30);
        martes.setFont(fuente_subtitulo);
        add(martes);

        miercoles = new JLabel("Miércoles");
        miercoles.setBounds(30, 420, 150, 30);
        miercoles.setFont(fuente_subtitulo);
        add(miercoles);

        jueves = new JLabel("Jueves");
        jueves.setBounds(480, 220, 100, 30);
        jueves.setFont(fuente_subtitulo);
        add(jueves);

        viernes = new JLabel("Viernes");
        viernes.setBounds(480, 320, 100, 30);
        viernes.setFont(fuente_subtitulo);
        add(viernes);

        sabado = new JLabel("Sábado");
        sabado.setBounds(480, 420, 100, 30);
        sabado.setFont(fuente_subtitulo);
        add(sabado);

        // Horarios para lunes
        horario_l1 = new JButton("07:30 hs");
        horario_l1.setBounds(150, 220, 90, 30);
        horario_l1.addActionListener(this);
        add(horario_l1);

        horario_l2 = new JButton("09:30 hs");
        horario_l2.setBounds(250, 220, 90, 30);
        horario_l2.addActionListener(this);
        add(horario_l2);

        horario_l3 = new JButton("11:30 hs");
        horario_l3.setBounds(350, 220, 90, 30);
        horario_l3.addActionListener(this);
        add(horario_l3);

        horario_l4 = new JButton("15:00 hs");
        horario_l4.setBounds(150, 260, 90, 30);
        horario_l4.addActionListener(this);
        add(horario_l4);

        horario_l5 = new JButton("17:00 hs");
        horario_l5.setBounds(250, 260, 90, 30);
        horario_l5.addActionListener(this);
        add(horario_l5);

        horario_l6 = new JButton("19:00 hs");
        horario_l6.setBounds(350, 260, 90, 30);
        horario_l6.addActionListener(this);
        add(horario_l6);

        // Horarios para martes
        horario_ma1 = new JButton("08:00 hs");
        horario_ma1.setBounds(150, 320, 90, 30);
        horario_ma1.addActionListener(this);
        add(horario_ma1);

        horario_ma2 = new JButton("10:00 hs");
        horario_ma2.setBounds(250, 320, 90, 30);
        horario_ma2.addActionListener(this);
        add(horario_ma2);

        horario_ma3 = new JButton("12:00 hs");
        horario_ma3.setBounds(350, 320, 90, 30);
        horario_ma3.addActionListener(this);
        add(horario_ma3);

        horario_ma4 = new JButton("16:00 hs");
        horario_ma4.setBounds(150, 360, 90, 30);
        horario_ma4.addActionListener(this);
        add(horario_ma4);

        horario_ma5 = new JButton("18:00 hs");
        horario_ma5.setBounds(250, 360, 90, 30);
        horario_ma5.addActionListener(this);
        add(horario_ma5);

        horario_ma6 = new JButton("20:00 hs");
        horario_ma6.setBounds(350, 360, 90, 30);
        horario_ma6.addActionListener(this);
        add(horario_ma6);

        // Horarios para miércoles
        horario_mi1 = new JButton("07:30 hs");
        horario_mi1.setBounds(150, 420, 90, 30);
        horario_mi1.addActionListener(this);
        add(horario_mi1);

        horario_mi2 = new JButton("09:30 hs");
        horario_mi2.setBounds(250, 420, 90, 30);
        horario_mi2.addActionListener(this);
        add(horario_mi2);

        horario_mi3 = new JButton("11:30 hs");
        horario_mi3.setBounds(350, 420, 90, 30);
        horario_mi3.addActionListener(this);
        add(horario_mi3);

        horario_mi4 = new JButton("15:00 hs");
        horario_mi4.setBounds(150, 460, 90, 30);
        horario_mi4.addActionListener(this);
        add(horario_mi4);

        horario_mi5 = new JButton("17:00 hs");
        horario_mi5.setBounds(250, 460, 90, 30);
        horario_mi5.addActionListener(this);
        add(horario_mi5);

        horario_mi6 = new JButton("19:00 hs");
        horario_mi6.setBounds(350, 460, 90, 30);
        horario_mi6.addActionListener(this);
        add(horario_mi6);

        // Horarios para jueves
        horario_j1 = new JButton("08:00 hs");
        horario_j1.setBounds(590, 220, 90, 30);
        horario_j1.addActionListener(this);
        add(horario_j1);

        horario_j2 = new JButton("10:00 hs");
        horario_j2.setBounds(690, 220, 90, 30);
        horario_j2.addActionListener(this);
        add(horario_j2);

        horario_j3 = new JButton("12:00 hs");
        horario_j3.setBounds(790, 220, 90, 30);
        horario_j3.addActionListener(this);
        add(horario_j3);

        horario_j4 = new JButton("16:00 hs");
        horario_j4.setBounds(590, 260, 90, 30);
        horario_j4.addActionListener(this);
        add(horario_j4);

        horario_j5 = new JButton("18:00 hs");
        horario_j5.setBounds(690, 260, 90, 30);
        horario_j5.addActionListener(this);
        add(horario_j5);

        horario_j6 = new JButton("20:00 hs");
        horario_j6.setBounds(790, 260, 90, 30);
        horario_j6.addActionListener(this);
        add(horario_j6);

        // Horarios para viernes
        horario_v1 = new JButton("07:30 hs");
        horario_v1.setBounds(590, 320, 90, 30);
        horario_v1.addActionListener(this);
        add(horario_v1);

        horario_v2 = new JButton("09:30 hs");
        horario_v2.setBounds(690, 320, 90, 30);
        horario_v2.addActionListener(this);
        add(horario_v2);

        horario_v3 = new JButton("11:30 hs");
        horario_v3.setBounds(790, 320, 90, 30);
        horario_v3.addActionListener(this);
        add(horario_v3);

        horario_v4 = new JButton("15:00 hs");
        horario_v4.setBounds(590, 360, 90, 30);
        horario_v4.addActionListener(this);
        add(horario_v4);

        horario_v5 = new JButton("17:00 hs");
        horario_v5.setBounds(690, 360, 90, 30);
        horario_v5.addActionListener(this);
        add(horario_v5);

        horario_v6 = new JButton("19:00 hs");
        horario_v6.setBounds(790, 360, 90, 30);
        horario_v6.addActionListener(this);
        add(horario_v6);

        // Horarios para sábado
        horario_s1 = new JButton("08:00 hs");
        horario_s1.setBounds(590, 420, 90, 30);
        horario_s1.addActionListener(this);
        add(horario_s1);

        horario_s2 = new JButton("10:00 hs");
        horario_s2.setBounds(690, 420, 90, 30);
        horario_s2.addActionListener(this);
        add(horario_s2);

        horario_s3 = new JButton("12:00 hs");
        horario_s3.setBounds(790, 420, 90, 30);
        horario_s3.addActionListener(this);
        add(horario_s3);

        horario_s4 = new JButton("16:00 hs");
        horario_s4.setBounds(590, 460, 90, 30);
        horario_s4.addActionListener(this);
        add(horario_s4);

        horario_s5 = new JButton("18:00 hs");
        horario_s5.setBounds(690, 460, 90, 30);
        horario_s5.addActionListener(this);
        add(horario_s5);

        horario_s6 = new JButton("20:00 hs");
        horario_s6.setBounds(790, 460, 90, 30);
        horario_s6.addActionListener(this);
        add(horario_s6);

        claseBD = new ClaseBD();
    }
    //Funcionalidad

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == boton_inicio) {
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

        //Membresias
        try {
            if (e.getSource() == boton_membresia) {
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

        //Historial
        if (e.getSource() == boton_historial) {
            JOptionPane.showMessageDialog(null, "Estamos trabajando en ello", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        //Contacto
        if (e.getSource() == boton_contacto) {
            JOptionPane.showMessageDialog(null, "Estamos trabajando en ello", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        //DIAS DE CLASES
        // LUNES
        if (e.getSource() == horario_l1) {
            if (horario_l1.getBackground().equals(java.awt.Color.GREEN)) {
                horario_l1.setBackground(null);
            } else {
                horario_l1.setBackground(java.awt.Color.GREEN);
            }

        } else if (e.getSource() == horario_l2) {
            if (horario_l2.getBackground().equals(java.awt.Color.GREEN)) {
                horario_l2.setBackground(null);
            } else {
                horario_l2.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_l3) {
            if (horario_l3.getBackground().equals(java.awt.Color.GREEN)) {
                horario_l3.setBackground(null);
            } else {
                horario_l3.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_l4) {
            if (horario_l4.getBackground().equals(java.awt.Color.GREEN)) {
                horario_l4.setBackground(null);
            } else {
                horario_l4.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_l5) {
            if (horario_l5.getBackground().equals(java.awt.Color.GREEN)) {
                horario_l5.setBackground(null);
            } else {
                horario_l5.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_l6) {
            if (horario_l6.getBackground().equals(java.awt.Color.GREEN)) {
                horario_l6.setBackground(null);
            } else {
                horario_l6.setBackground(java.awt.Color.GREEN);
            }
        }

        // MARTES
        if (e.getSource() == horario_ma1) {
            if (horario_ma1.getBackground().equals(java.awt.Color.GREEN)) {
                horario_ma1.setBackground(null);
            } else {
                horario_ma1.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_ma2) {
            if (horario_ma2.getBackground().equals(java.awt.Color.GREEN)) {
                horario_ma2.setBackground(null);
            } else {
                horario_ma2.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_ma3) {
            if (horario_ma3.getBackground().equals(java.awt.Color.GREEN)) {
                horario_ma3.setBackground(null);
            } else {
                horario_ma3.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_ma4) {
            if (horario_ma4.getBackground().equals(java.awt.Color.GREEN)) {
                horario_ma4.setBackground(null);
            } else {
                horario_ma4.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_ma5) {
            if (horario_ma5.getBackground().equals(java.awt.Color.GREEN)) {
                horario_ma5.setBackground(null);
            } else {
                horario_ma5.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_ma6) {
            if (horario_ma6.getBackground().equals(java.awt.Color.GREEN)) {
                horario_ma6.setBackground(null);
            } else {
                horario_ma6.setBackground(java.awt.Color.GREEN);
            }
        }

        // MIERCOLES
        if (e.getSource() == horario_mi1) {
            if (horario_mi1.getBackground().equals(java.awt.Color.GREEN)) {
                horario_mi1.setBackground(null);
            } else {
                horario_mi1.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_mi2) {
            if (horario_mi2.getBackground().equals(java.awt.Color.GREEN)) {
                horario_mi2.setBackground(null);
            } else {
                horario_mi2.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_mi3) {
            if (horario_mi3.getBackground().equals(java.awt.Color.GREEN)) {
                horario_mi3.setBackground(null);
            } else {
                horario_mi3.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_mi4) {
            if (horario_mi4.getBackground().equals(java.awt.Color.GREEN)) {
                horario_mi4.setBackground(null);
            } else {
                horario_mi4.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_mi5) {
            if (horario_mi5.getBackground().equals(java.awt.Color.GREEN)) {
                horario_mi5.setBackground(null);
            } else {
                horario_mi5.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_mi6) {
            if (horario_mi6.getBackground().equals(java.awt.Color.GREEN)) {
                horario_mi6.setBackground(null);
            } else {
                horario_mi6.setBackground(java.awt.Color.GREEN);
            }
        }

        // JUEVES
        if (e.getSource() == horario_j1) {
            if (horario_j1.getBackground().equals(java.awt.Color.GREEN)) {
                horario_j1.setBackground(null);
            } else {
                horario_j1.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_j2) {
            if (horario_j2.getBackground().equals(java.awt.Color.GREEN)) {
                horario_j2.setBackground(null);
            } else {
                horario_j2.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_j3) {
            if (horario_j3.getBackground().equals(java.awt.Color.GREEN)) {
                horario_j3.setBackground(null);
            } else {
                horario_j3.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_j4) {
            if (horario_j4.getBackground().equals(java.awt.Color.GREEN)) {
                horario_j4.setBackground(null);
            } else {
                horario_j4.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_j5) {
            if (horario_j5.getBackground().equals(java.awt.Color.GREEN)) {
                horario_j5.setBackground(null);
            } else {
                horario_j5.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_j6) {
            if (horario_j6.getBackground().equals(java.awt.Color.GREEN)) {
                horario_j6.setBackground(null);
            } else {
                horario_j6.setBackground(java.awt.Color.GREEN);
            }
        }

        // VIERNES
        if (e.getSource() == horario_v1) {
            if (horario_v1.getBackground().equals(java.awt.Color.GREEN)) {
                horario_v1.setBackground(null);
            } else {
                horario_v1.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_v2) {
            if (horario_v2.getBackground().equals(java.awt.Color.GREEN)) {
                horario_v2.setBackground(null);
            } else {
                horario_v2.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_v3) {
            if (horario_v3.getBackground().equals(java.awt.Color.GREEN)) {
                horario_v3.setBackground(null);
            } else {
                horario_v3.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_v4) {
            if (horario_v4.getBackground().equals(java.awt.Color.GREEN)) {
                horario_v4.setBackground(null);
            } else {
                horario_v4.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_v5) {
            if (horario_v5.getBackground().equals(java.awt.Color.GREEN)) {
                horario_v5.setBackground(null);
            } else {
                horario_v5.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_v6) {
            if (horario_v6.getBackground().equals(java.awt.Color.GREEN)) {
                horario_v6.setBackground(null);
            } else {
                horario_v6.setBackground(java.awt.Color.GREEN);
            }
        }

        // SABADO
        if (e.getSource() == horario_s1) {
            if (horario_s1.getBackground().equals(java.awt.Color.GREEN)) {
                horario_s1.setBackground(null);
            } else {
                horario_s1.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_s2) {
            if (horario_s2.getBackground().equals(java.awt.Color.GREEN)) {
                horario_s2.setBackground(null);
            } else {
                horario_s2.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_s3) {
            if (horario_s3.getBackground().equals(java.awt.Color.GREEN)) {
                horario_s3.setBackground(null);
            } else {
                horario_s3.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_s4) {
            if (horario_s4.getBackground().equals(java.awt.Color.GREEN)) {
                horario_s4.setBackground(null);
            } else {
                horario_s4.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_s5) {
            if (horario_s5.getBackground().equals(java.awt.Color.GREEN)) {
                horario_s5.setBackground(null);
            } else {
                horario_s5.setBackground(java.awt.Color.GREEN);
            }
        } else if (e.getSource() == horario_s6) {
            if (horario_s6.getBackground().equals(java.awt.Color.GREEN)) {
                horario_s6.setBackground(null);
            } else {
                horario_s6.setBackground(java.awt.Color.GREEN);
            }
        }

if (e.getSource() == boton_reserva) {
   
        // array con todos los horarios disponibles
        Object[] horariosDisponibles = {horario_l1, horario_l2, horario_l3, horario_l4, horario_l5, horario_l6,
            horario_ma1, horario_ma2, horario_ma3, horario_ma4, horario_ma5, horario_ma6,
            horario_mi1, horario_mi2, horario_mi3, horario_mi4, horario_mi5, horario_mi6,
            horario_j1, horario_j2, horario_j3, horario_j4, horario_j5, horario_j6,
            horario_v1, horario_v2, horario_v3, horario_v4, horario_v5, horario_v6,
            horario_s1, horario_s2, horario_s3, horario_s4, horario_s5, horario_s6};

        boolean claseSeleccionada = false;

        // Recorremos los horarios para verificar cuál fue el que se seleccionó
        for (Object horario : horariosDisponibles) {

            // Verificar si el horario tiene el color verde de fondo
            if (horario instanceof JButton) {
                JButton btnHorario = (JButton) horario;
                if (btnHorario.getBackground().equals(java.awt.Color.GREEN)) {
                    claseSeleccionada = true;
                    break;
                }
            }
        }

        // Si se seleccionó alguna clase
        if (claseSeleccionada) {
            try {
                //llamamos a claseBD para registrar la reserva 
                claseBD.registrarReservaClase();
                
                this.setVisible(false); 

                Menu interfaz = new Menu();
                interfaz.setBounds(0, 0, 950, 725);
                interfaz.setVisible(true);
                interfaz.setResizable(false);
                interfaz.setLocationRelativeTo(null);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al realizar la reserva: " + ex.getMessage());
            }
        } else {
            // Si no se seleccionó ninguna clase
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un horario para realizar la reserva.");
        }
    }


    }

    //Main
    public static void main(String args[]) {
        Clases interfaz = new Clases();
        interfaz.setBounds(0, 0, 950, 725);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);
    }

}
