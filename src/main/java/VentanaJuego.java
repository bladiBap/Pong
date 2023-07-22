import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {

    private PanelJuego panelJuego = new PanelJuego();

    public VentanaJuego(String nombre1, String nombre2 ) {
        setTitle("Proyecto de Programacion 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        this.add(panelJuego);
        this.addKeyListener(panelJuego);
        panelJuego.setBackground(Color.BLACK);
        panelJuego.cargarJugador(nombre1,nombre2);
        panelJuego.setVisible(true);
        Thread hilo=new Thread(panelJuego);
        hilo.start();
    }
}


