import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame implements ActionListener {
    //private Image fondo = new ImageIcon("imagenPong.png").getImage();
    private ImageIcon fondo = new ImageIcon("imagenPong2.png");
    private VentanaJuego ventana;
    //private Image fondo;
    private JButton botonGo = new JButton("Comenzar");
    private JLabel nombre1 = new JLabel("JUGADOR 1 NAME:");
    private JLabel nombre2 = new JLabel("JUGADOR 2 NAME:");
    private JLabel imagenLabel = new JLabel();
    private JTextField txtNombre1 = new JTextField();
    private JTextField txtNombre2 = new JTextField();
    private JLabel reglas = new JLabel();
    private JPanel panelInicio = new JPanel();

    public Inicio() {
        setTitle("Proyecto de Programacion 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        cargarElementos();

    }

    public void cargarElementos() {

        panelInicio.setLayout(null);
        panelInicio.setBackground(Color.YELLOW);
        panelInicio.setSize(1000, 600);
        reglas.setText("<html>Para el jugador 1 las teclas para moverse son W(Arriba) y S(Abajo).<p>"+
                "Para el jugador 2 las teclas para moverse son UP(Arriba) y DOWN(Abajo).<p>"+
                "Presiona P para volver a esta ventana.<html>");

        imagenLabel.setBounds(500,0,500,600);
        //imagenLabel.setOpaque(true);
        //imagenLabel.setBackground(Color.GREEN);
        imagenLabel.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(500,600,Image.SCALE_SMOOTH)));
        botonGo.setBounds(100,20,300,50);
        botonGo.setFont(new Font("cooper black",0,45));
        reglas.setFont(new Font("cooper black",0,25));
        nombre1.setBounds(100,90,150,30);
        txtNombre1.setBounds(260,90,150,30);
        nombre2.setBounds(100,130,150,30);
        txtNombre2.setBounds(260,130,150,30);
        reglas.setBounds(50,200,400,300);

        botonGo.setBackground(Color.ORANGE);
        nombre1.setHorizontalAlignment(SwingConstants.CENTER);
        nombre2.setHorizontalAlignment(SwingConstants.CENTER);
        //reglas.setHorizontalAlignment(SwingConstants.CENTER);
        nombre1.setOpaque(true);
        nombre2.setOpaque(true);
        reglas.setOpaque(true);
        nombre1.setBackground(Color.orange);
        nombre2.setBackground(Color.orange);
        reglas.setBackground(Color.orange);


        panelInicio.add(botonGo);
        panelInicio.add(nombre1);
        panelInicio.add(nombre2);
        panelInicio.add(txtNombre1);
        panelInicio.add(txtNombre2);
        panelInicio.add(imagenLabel);
        panelInicio.add(reglas);

        botonGo.addActionListener(this);
        this.add(panelInicio);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //fondo = new ImageIcon(getClass().getResource("fondo.jpg")).getImage();
        //g.drawImage(fondo,20,20,null);
        //g.drawImage(fondo, 0, 0, 1000, 600, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonGo) {
            if (txtNombre2.getText().equals("") || txtNombre1.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe rellenar los nombres");
            }else{
                ventana = new VentanaJuego(txtNombre1.getText(),txtNombre2.getText());
                this.dispose();
                System.out.println("asd");
            }
        }
    }
}
