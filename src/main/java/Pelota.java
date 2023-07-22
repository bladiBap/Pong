import java.awt.*;

public class Pelota {
    private  int tamaño = 20;
    private int posPelotaX;
    private int posPelotaY;
    private int aumentoX = 3;
    private int aumentoY = 3;
    private int puntos1 = 0;
    private int puntos2 = 0;
    private int anchoPanel;
    private int altoPanel;

    public Pelota (int alto, int ancho){
        this.posPelotaX = ancho/2;
        this.posPelotaY = alto/2;
        this.anchoPanel = ancho;
        this.altoPanel = alto;
    }

    public void ubicarPelota (Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(posPelotaX, posPelotaY,tamaño,tamaño);

    }

    public void moverPelota (boolean col1 , boolean col2){
        posPelotaX += aumentoX;
        posPelotaY += aumentoY;

        if ( col1 == true){
            aumentoX = -aumentoX;
            posPelotaX = 70;
        }

        if (col2 == true){
            aumentoX = -aumentoX;
            posPelotaX = 890;
        }

        if (posPelotaX >= (anchoPanel-35)){
            aumentoX = -aumentoX;
            posPelotaX =anchoPanel/2;
            posPelotaY = altoPanel/2;
            puntos1++;
        }
        if (posPelotaX <= 0){
            aumentoX = -aumentoX;
            posPelotaX = anchoPanel/2;
            posPelotaY = altoPanel/2;
            puntos2++;
            System.out.println(aumentoX);
        }
        if (posPelotaY >= (altoPanel-55)){
            aumentoY = -aumentoY;
        }
        if (posPelotaY <= 0){
            aumentoY = -aumentoY;
        }
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPuntos1() {
        return puntos1;
    }

    public void setPuntos1(int puntos1) {
        this.puntos1 = puntos1;
    }

    public int getPuntos2() {
        return puntos2;
    }

    public void setPuntos2(int puntos2) {
        this.puntos2 = puntos2;
    }

    public int getPosPelotaX() {
        return posPelotaX;
    }

    public void setPosPelotaX(int posPelotaX) {
        this.posPelotaX = posPelotaX;
    }

    public int getPosPelotaY() {
        return posPelotaY;
    }

    public void setPosPelotaY(int posPelotaY) {
        this.posPelotaY = posPelotaY;
    }
}
