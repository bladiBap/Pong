import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelJuego extends JPanel implements KeyListener, Runnable {

    private Jugadores jugador1;
    private Jugadores jugador2;
    private Pelota pelota;
    //private Pelota pelota2;
    private String sentido;
    private boolean colision1 = false;
    private boolean colision2 = false;
    private boolean empezarJuego = false;
    private boolean terceraPelota = false;
    private JLabel nombre1 = new JLabel();
    private JLabel nombre2 = new JLabel();

    private boolean pararHilo = false;
    private Inicio inicio;



    public void cargarJugador(String nombre1, String nombre2) {
        setSize(1000, 600);
        this.setLayout(null);
        jugador1 = new Jugadores(50, (this.getHeight() / 2) - 50,nombre1);
        jugador2 = new Jugadores(this.getWidth() - 82, (this.getHeight() / 2) - 50,nombre2);
        pelota = new Pelota(this.getHeight(), this.getWidth());
        //pelota2 = new Pelota(this.getHeight(), this.getWidth());

        System.out.println(this.getWidth() + "" + this.getHeight());

        this.nombre1.setText(nombre1);
        this.nombre2.setText(nombre2);
        this.nombre1.setOpaque(true);
        this.nombre2.setOpaque(true);

        this.nombre1.setBackground(Color.GREEN);
        this.nombre2.setBackground(Color.GREEN);

        this.nombre1.setBounds(300,20,100,30);
        this.nombre2.setBounds(600,20,100,30);
        this.nombre1.setFont(new Font("cooper black",0,18));
        this.nombre2.setFont(new Font("cooper black",0,18));
        this.nombre1.setHorizontalAlignment(SwingConstants.CENTER);
        this.nombre2.setHorizontalAlignment(SwingConstants.CENTER);

        add(this.nombre1);
        add(this.nombre2);

    }

    public boolean colisionJugador1(Pelota pelota){
        Rectangle areaJugador1 = new Rectangle(jugador1.getPosx(),jugador1.getPosy(),jugador1.getLargo(),jugador1.getAncho());
        Rectangle areaPelota = new Rectangle(pelota.getPosPelotaX(),pelota.getPosPelotaY(),pelota.getTamaño(),pelota.getTamaño());
        return areaJugador1.intersects(areaPelota);
    }

    public boolean colisionJugador2(Pelota pelota){
        Rectangle areaJugador2 = new Rectangle(jugador2.getPosx(),jugador2.getPosy(),jugador2.getLargo(),jugador2.getAncho());
        Rectangle areaPelota = new Rectangle(pelota.getPosPelotaX(),pelota.getPosPelotaY(),pelota.getTamaño(),pelota.getTamaño());
        return areaJugador2.intersects(areaPelota);
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(30, 0, 30, this.getHeight());
        g.drawLine(this.getWidth() - 30, 0, this.getWidth() - 30, this.getHeight());
        jugador1.cargarRectangulo(g);
        jugador2.cargarRectangulo(g);
        pelota.ubicarPelota(g);
        if(pelota.getPuntos1() == 3 || pelota.getPuntos2()==3){
            terceraPelota = true;
        }
        if (terceraPelota == true){
            //pelota2.ubicarPelota(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("asdasdasdasd");

        if (e.getKeyCode() == KeyEvent.VK_W) {
            empezarJuego = true;
            sentido = "arriba";
            if (jugador1.getPosy() <= 1) {

            } else {
                jugador1.movimiento(sentido);
            }
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            empezarJuego = true;
            sentido = "abajo";
            if (jugador1.getPosy() >= this.getHeight() - 110) {

            } else {
                jugador1.movimiento(sentido);
            }
            System.out.println(this.getHeight());
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            empezarJuego = true;
            sentido = "arriba";
            if (jugador2.getPosy() <= 1) {

            } else {
                jugador2.movimiento(sentido);
            }
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            empezarJuego = true;
            sentido = "abajo";
            if (jugador2.getPosy() >= this.getHeight() - 110) {

            } else {
                jugador2.movimiento(sentido);
            }
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_P){

            pararHilo = true;
            this.setVisible(false);
            inicio = new Inicio();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        System.out.println("asasdasdasdas");
        try {
            while (true) {
                System.out.println("as");
                repaint();
                if (empezarJuego == true) {
                    Thread.sleep(7);
                    colision1 = colisionJugador1(pelota);
                    colision2 = colisionJugador2(pelota);
                    pelota.moverPelota(colision1,colision2);
                    System.out.println(11111111);
                    if (terceraPelota == true){
                        System.out.println("22222222");
                        //colision1 = colisionJugador1(pelota2);
                        //colision2 = colisionJugador2(pelota2);
                        //pelota2.moverPelota(colision1,colision2);
                    }
                    nombre1.setText(jugador1.getNombre()+" "+pelota.getPuntos1());
                    nombre2.setText(jugador2.getNombre()+" "+pelota.getPuntos2());
                    colision1 = false;
                    colision2 = false;
                    repaint();
                }
                if (pararHilo == true){
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

