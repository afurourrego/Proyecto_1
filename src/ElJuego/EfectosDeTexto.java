package ElJuego;

/**
 * Created by Afuro on 10/03/2017.
 */
public class EfectosDeTexto {

    public EfectosDeTexto() {
    }

    public void PausaPuntosSuspensivos(String mensaje) throws InterruptedException {
        System.out.print(mensaje);

        Thread.sleep(300);

        System.out.print(".");

        Thread.sleep(300);

        System.out.print(".");

        Thread.sleep(300);

        System.out.print(".");

        Thread.sleep(300);

        System.out.print("\n\n");
    }
}
