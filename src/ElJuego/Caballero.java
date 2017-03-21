package ElJuego;

import java.util.Random;

/**
 * Created by Afuro on 11/03/2017.
 */
public class Caballero extends Humano {


    public Caballero() {
        // super(rango, arma, puntosVitalidad, puntosAtaque, puntosDefensa);

        String[] arma = new String[5];
        arma[0] ="Espada";
        arma[1] ="Katana";
        arma[2] ="Sable de Luz";
        arma[3] ="Cortauñas";
        arma[4] ="Hacha Gigante";

        Random rnd = new Random();

        this.setRango("Caballero");
        this.setArma(arma[(rnd.nextInt(5))]);
        this.setPuntosVitalidad(60);
        this.setPuntosAtaque((rnd.nextInt(3)+9));
        this.setPuntosDefensa((rnd.nextInt(3)+9));
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
