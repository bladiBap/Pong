import java.awt.*;

public class Jugadores {

    private int posx;
    private int posy;
    private int largo;
    private int ancho;
    private String nombre;
    private int puntos;

    public Jugadores(int posx, int posy,String nombre) {
        this.posx = posx;
        this.posy = posy;
        this.nombre = nombre;
        this.largo = 15;
        this.ancho = 100;
    }

    public void cargarRectangulo (Graphics g){
        g.setColor(Color.RED
        );
        g.fillRect(posx,posy,largo,ancho);
    }

    public void movimiento (String sentido){
        switch (sentido){
            case "arriba":
                this.posy -=60;
                break;
            case "abajo":
                this.posy +=60;
        }
    }


    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
