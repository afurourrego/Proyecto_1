package ElJuego;

/**
 * Created by Afuro on 11/03/2017.
 */
public class Rey extends Humano {

protected String Reino;
protected String Pueblo;

    public Rey(String rango, String arma, int puntosVitalidad, int puntosAtaque, int puntosDefensa, String reino) {
        super(rango, arma, puntosVitalidad, puntosAtaque, puntosDefensa);

        this.Reino = reino;
        this.Pueblo = reino+"nienses";
    }

    public Rey() {
        this.setRango("Rey Enemigo");
        this.setArma("Baston Real");
        this.setPuntosVitalidad(100);
        this.setPuntosAtaque(2);
        this.setPuntosDefensa(2);
        this.Reino = "";
        this.Pueblo = "";
    }

    public void getVer(){

        if (this.Rango == "Rey") {
            System.out.println(getRango() + " de " + this.Reino);
        }else{
            System.out.println(getRango());
        }
        System.out.println("Arma: "+getArma());
        System.out.println("Salud: "+getPuntosVitalidad());
        System.out.println("Ataque: "+getPuntosAtaque());
        System.out.println("Defensa: "+getPuntosDefensa());
        System.out.println();
    }

    public String getReino() {
        return Reino;
    }

    public void setReino(String reino) {
        Reino = reino;
    }

    public String getPueblo() {
        return Pueblo;
    }

    public void setPueblo(String pueblo) {
        Pueblo = pueblo;
    }
}
