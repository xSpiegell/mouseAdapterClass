package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*; // paquete que se encarga de los eventos
import java.awt.event.*;

// extends es la palabra para heredar
public class GUI_Presentacion extends JFrame {
    //atributos
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos; //Componente que agrupa otros componentes graficos
    private Titulos titulo;
    private JLabel labelImagen; // componente para hacer visible las imagenes
    private JTextArea textoExpectativas;
    private Escucha escucha;
    //metodos
    public GUI_Presentacion(){
        initGui();

        //configuacion base de la ventana
        //el this me sirve para acceder a los metodos de JFrame
        this.setTitle("Mi Presentacion"); // titulo de la ventana
        this.setSize(600,540); // tamaño de la ventana
        this.setLocationRelativeTo(null);
        this.setVisible(true); // permite que la ventana se vea
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // define un boton para cerrar la ventana
    }

    private void initGui() {
        //Definir Container y Layout del JFrame
        //Crear objetos Escucha y Control
        escucha = new Escucha();

        //Configurar JComponents
        titulo = new Titulos("Hola soy Brayan, oprime los botones :)", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH); // agrega el titulo en la zona donde se le indique

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...",
                            TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                            new Font("Calibri", Font.PLAIN, 20), Color.BLACK));

        panelDatos.addMouseListener(escucha);
        panelDatos.addMouseListener(escucha);
        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);

        this.add(panelDatos, BorderLayout.CENTER); // se muestra el panel de datos en la ventana

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha); // sirve para que cada boton escuche a cada interaccion del usuario

        miHobby = new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);

        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();

        // se agregan los botones en el orden que uno quiera
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH); // se muestra el panel de botones en la ventana

        labelImagen = new JLabel(); // solo se crea un objeto y se reutiliza para varias imagenes
        textoExpectativas = new JTextArea(10, 12);
    }

    public static void main(String[] args){
        // objeto que me permite manejar eventos, es la cola de eventos
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // creacion del objeto de la ventana
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha implements MouseListener, KeyListener{
        private ImageIcon image;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            panelDatos.removeAll();
            if (e.getKeyChar() == 'm' ){
                textoExpectativas.append("En unos años cumplire mis metas a corto plazo\n" +
                        "y asi dar paso a otros objetivos. Tengo muchas\n" +
                        "expectativas positivas de mi mismo en el futuro\n" +
                        "ya que soy una persona que no le gusta rendirse\n" +
                        "facilmente, ademas me gusta aprender cosas nuevas\n" +
                        "cada dia ya que la juventud es una etapa que debo\n" +
                        "aprovechar para cultivar mis conocimientos y ver\n" +
                        "los frutos con el paso de los años. La tecnologia\n" +
                        "sera lo mas importante en el futuro, por eso aprender\n" +
                        "programacion ha sido mi eleccion.");
                textoExpectativas.setBackground(null);
                textoExpectativas.setFont(new Font("Calibri", Font.ITALIC,20));
                panelDatos.add(textoExpectativas);
            }
            revalidate();
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if (e.getSource() == miFoto & e.getClickCount() == 1){
                image = new ImageIcon(getClass().getResource("/recursos/hola.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else {
                if (e.getSource() == miHobby & e.getClickCount() == 2) {
                    image = new ImageIcon(getClass().getResource("/recursos/movies.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
