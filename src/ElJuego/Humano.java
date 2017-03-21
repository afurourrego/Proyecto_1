package ElJuego;

/**
 * Created by Afuro on 11/03/2017.
 */
public class Humano {

    protected String Rango;
    protected String Arma;
    protected int PuntosVitalidad;
    protected int PuntosAtaque;
    protected int PuntosDefensa;

    public Humano(String rango, String arma, int puntosVitalidad, int puntosAtaque, int puntosDefensa) {
        Rango = rango;
        Arma = arma;
        PuntosVitalidad = puntosVitalidad;
        PuntosAtaque = puntosAtaque;
        PuntosDefensa = puntosDefensa;
    }

    public Humano() {
        Rango = "";
        Arma = "";
        PuntosVitalidad = 0;
        PuntosAtaque = 0;
        PuntosDefensa = 0;
    }

    public String getRango() {
        return Rango;
    }

    public void setRango(String rango) {
        Rango = rango;
    }

    public String getArma() {
        return Arma;
    }

    public void setArma(String arma) {
        Arma = arma;
    }

    public int getPuntosVitalidad() {
        return PuntosVitalidad;
    }

    public void setPuntosVitalidad(int puntosVitalidad) {
        PuntosVitalidad = puntosVitalidad;
    }

    public void setPuntosVitalidadAtaque(int puntosVitalidad) {
        PuntosVitalidad = PuntosVitalidad - puntosVitalidad;
    }

    public int getPuntosAtaque() {
        return PuntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        PuntosAtaque = puntosAtaque;
    }

    public int getPuntosDefensa() {
        return PuntosDefensa;
    }

    public void setPuntosDefensa(int puntosDefensa) {
        PuntosDefensa = puntosDefensa;
    }
}
