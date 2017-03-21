package ElJuego;

import java.util.Random;

/**
 * Created by Afuro on 11/03/2017.
 */
public class Guerrero extends Humano{

    public Guerrero(int numGuerrero) {
        String[] arma = new String[5];
        arma[0] ="Espada";
        arma[1] ="Mazo";
        arma[2] ="Arco";
        arma[3] ="Lanza";
        arma[4] ="Hacha Pequeña";

        Random rnd = new Random();

        this.setRango("Guerrero "+numGuerrero);
        this.setArma(arma[(rnd.nextInt(5))]);
        this.setPuntosVitalidad(30);
        this.setPuntosAtaque((rnd.nextInt(2)+5));
        this.setPuntosDefensa((rnd.nextInt(2)+5));
    }

    public void getVer(){
        System.out.println(getRango());
        System.out.println("Arma: "+getArma());
        System.out.println("Salud: "+getPuntosVitalidad());
        System.out.println("Ataque: "+getPuntosAtaque());
        System.out.println("Defensa: "+getPuntosDefensa());
        System.out.println();
    }
}
