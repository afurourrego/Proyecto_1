package ElJuego;

import java.awt.dnd.DnDConstants;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Afuro on 10/03/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //variables
        int opcion = 0;
        boolean Turno = true;
        int opcionAtaque = 0;
        int DanioAtaque = 0;
        boolean Defender = false;
        boolean DesicionEnemigo = true;
        int opcionTemp = 0;

        //Instancias de recursos
        EfectosDeTexto mensaje = new EfectosDeTexto();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();


        System.out.println("-CONQUISTA EL REINO-");
        System.out.println();
        System.out.println("Bienvenido a Conquista El Reino, las reglas" +
                        "\nson simples, derroca al rey y apoderate con todo,"+
                        "\ncontaras con un pequeño pero valiente ejercito a tu" +
                        "\nservicio, un caballero leal y valiente al servicio " +
                        "\nde su rey hasta la muerte, antes de atacar al rey" +
                        "\ntendras que acabar con él..."+
                        "\nPero ten cuidado, no podras atacar dos veces seguidas"+
                        "\ncon el mismo guerrero.");

        System.out.println("\n\n[Presiona ENTER para continuar]");

        System.in.read();

        System.out.println("\n");
        System.out.println("¿Como dijiste que se llama tu Reino?");

        String Reino = sc.nextLine();

        if ((Reino.equals(""))||(Reino.equals(" "))) {
            Reino = "Nada";
        }

        //Ejercito
        Rey TheKing = new Rey("Rey","Baston Real", 100, 2,2, Reino);
        Caballero caballero = new Caballero();

        Guerrero guerrero[] = new Guerrero[3];
        for (int NumGuerrero = 0; NumGuerrero <3; NumGuerrero++){
          guerrero[NumGuerrero] = new Guerrero(NumGuerrero+1);
        }

        //Ejercito Enemigo
        Rey ReyEnemigo = new Rey();
        Caballero caballeroEnemigo= new Caballero();

        Guerrero guerreroEnemigo[] = new Guerrero[3];
        for (int NumGuerrero = 0; NumGuerrero <3; NumGuerrero++){
            guerreroEnemigo[NumGuerrero] = new Guerrero(NumGuerrero+1);
        }


        mensaje.PausaPuntosSuspensivos("Fracasa la Paz");
        mensaje.PausaPuntosSuspensivos("La Guerra es Inevitable");
        mensaje.PausaPuntosSuspensivos("Tu Reino se Prepara");
        mensaje.PausaPuntosSuspensivos("Declarando la Guerra");
        mensaje.PausaPuntosSuspensivos("Reclutando tu ejercito");
        mensaje.PausaPuntosSuspensivos("Los Mejores te Siguen");
        mensaje.PausaPuntosSuspensivos("Sale la Carabana");
        mensaje.PausaPuntosSuspensivos("Es un Día Soleado");
        mensaje.PausaPuntosSuspensivos("Los "+TheKing.Pueblo+" estan listos");
        mensaje.PausaPuntosSuspensivos("LA GUERRA INICIA");


        System.out.println("\n\n\n\n");

        do {

            if (Turno) {

                mensaje.PausaPuntosSuspensivos("Tu Turno");
                System.out.println("\n");
                System.out.println("[PANEL DE GUERRA]");
                System.out.println("1.Atacar. \n2.Defender. \n3.Tu Ejercito. \n0.Rendirse");

                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        //Atacar
                        Turno = false;

                        System.out.println("[ELIGE CON QUIERES ATACAR]");

                        System.out.println("0.Rey de "+TheKing.getReino());

                        if (caballero.PuntosVitalidad > 0){
                            System.out.println("1.Caballero");
                        }

                        if (guerrero[0].PuntosVitalidad > 0){
                            System.out.println("2.Guerrero 1");
                        }

                        if (guerrero[1].PuntosVitalidad > 0){
                            System.out.println("3.Guerrero 2");
                        }

                        if (guerrero[2].PuntosVitalidad > 0){
                            System.out.println("4.Guerrero 3");
                        }

//                        System.out.println("5.Atras.");

                        opcionAtaque = sc.nextInt();

                        switch (opcionAtaque){


                            case 0:
                                if (TheKing.PuntosVitalidad > 0) {
                                    DanioAtaque = TheKing.getPuntosAtaque();
                                }

                                break;

                            case 1:
                                if (caballero.PuntosVitalidad > 0) {
                                    DanioAtaque = caballero.getPuntosAtaque();
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, pierdes el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                            case 2:
                                if (guerrero[0].PuntosVitalidad > 0) {
                                    DanioAtaque = guerrero[0].getPuntosAtaque();
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, pierdes el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                            case 3:
                                if (guerrero[1].PuntosVitalidad > 0) {
                                    DanioAtaque = guerrero[1].getPuntosAtaque();
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, pierdes el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                            case 4:
                                if (guerrero[2].PuntosVitalidad > 0) {
                                    DanioAtaque = guerrero[2].getPuntosAtaque();
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, pierdes el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                           /* case 5:
                                Turno = true;

                                break;
                            */
                            default:
                                System.out.println("Opcion Invalida");
                                Turno = true;

                                break;
                        }

                        if (DanioAtaque != 0) {
                            System.out.println("[EJERCITO ENEMIGO - ¿A QUIEN ATACARAS?]");

                            if (caballeroEnemigo.PuntosVitalidad <= 0){
                                System.out.println("0.Rey Enemigo");
                            }

                            if (caballeroEnemigo.PuntosVitalidad > 0){
                                System.out.println("1.Caballero");
                            }else{
                                System.out.println("1.Caballero - [MUERTO]");
                            }

                            if (guerreroEnemigo[0].PuntosVitalidad > 0){
                                System.out.println("2.Guerrero 1");
                            }else{
                                System.out.println("2.Guerrero 1 - [MUERTO]");
                            }

                            if (guerreroEnemigo[1].PuntosVitalidad > 0){
                                System.out.println("3.Guerrero 2");
                            }else{
                                System.out.println("3.Guerrero 2 - [MUERTO]");
                            }

                            if (guerreroEnemigo[2].PuntosVitalidad > 0){
                                System.out.println("4.Guerrero 3");
                            }else{
                                System.out.println("4.Guerrero 3 - [MUERTO]");
                            }
                            System.out.println("5.Atras.");

                            opcionAtaque = sc.nextInt();

                            if (rnd.nextInt(10) == 5) {
                                DanioAtaque = DanioAtaque*2;
                                System.out.println("¡Ha Sido un Ataque Critico!\n DAÑO X 2");
                            }

                            switch (opcionAtaque){


                                case 0:
                                    //rey enemigo
                                    if (caballeroEnemigo.PuntosVitalidad <= 0){

                                        if(Defender){
                                            DanioAtaque = DanioAtaque - ReyEnemigo.getPuntosDefensa();

                                            if (DanioAtaque > 0){
                                                ReyEnemigo.setPuntosVitalidadAtaque(DanioAtaque);
                                                System.out.println("¡Lograste pasar la defensa del Rey!");
                                                System.out.println("- "+DanioAtaque+" de daño.");
                                            }else{
                                                System.out.println("¡Se ha defendido de tu ataque!");
                                            }

                                            Defender = false;

                                        }else{
                                            ReyEnemigo.setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Atacando al Rey!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }

                                    }else {
                                        System.out.println("¡No puedes atacar al Rey sin antes acabar a su caballero!");
                                        mensaje.PausaPuntosSuspensivos("El Caballero se interpone en tu ataque");

                                        if(Defender){
                                            DanioAtaque = DanioAtaque - caballeroEnemigo.getPuntosDefensa();

                                            if (DanioAtaque > 0){
                                                caballeroEnemigo.setPuntosVitalidadAtaque(DanioAtaque);
                                                System.out.println("¡Lograste pasar la defensa del Caballero!");
                                                System.out.println("- "+DanioAtaque+" de daño.");
                                            }else{
                                                System.out.println("¡Se ha defendido de tu ataque!");
                                            }

                                            Defender = false;

                                        }else{
                                            caballeroEnemigo.setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Redirigiendo Ataque al Caballero!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }
                                    }
                                    break;

                                case 1:
                                    //caballero
                                    if (caballeroEnemigo.getPuntosVitalidad() <= 0){
                                        System.out.println("Te regodeas con su cadaver y vuelves a visitarlo");
                                        mensaje.PausaPuntosSuspensivos("Pasas tu turno aqui");
                                    }else if(Defender){
                                        DanioAtaque = DanioAtaque - caballeroEnemigo.getPuntosDefensa();

                                        if (DanioAtaque > 0){
                                            caballeroEnemigo.setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Lograste pasar la defensa del Caballero!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }else{
                                            System.out.println("¡Se ha defendido de tu ataque!");
                                        }

                                        Defender = false;

                                    }else{
                                        caballeroEnemigo.setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Atacando al Caballero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }

                                    break;

                                case 2:
                                    // guerrero 1
                                    if (guerreroEnemigo[0].getPuntosVitalidad() <= 0){
                                        System.out.println("Te regodeas con su cadaver y vuelves a visitarlo");
                                        mensaje.PausaPuntosSuspensivos("Pasas tu turno aqui");
                                    }else if(Defender){
                                        DanioAtaque = DanioAtaque - guerreroEnemigo[0].getPuntosDefensa();

                                        if (DanioAtaque > 0){
                                            guerreroEnemigo[0].setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Lograste pasar la defensa del Guerrero!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }else{
                                            System.out.println("¡Se ha defendido de tu ataque!");
                                        }

                                        Defender = false;

                                    }else{
                                        guerreroEnemigo[0].setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Atacando un Guerrero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }

                                    break;

                                case 3:
                                    //guerrero 2
                                    if (guerreroEnemigo[1].getPuntosVitalidad() <= 0){
                                        System.out.println("Te regodeas con su cadaver y vuelves a visitarlo");
                                        mensaje.PausaPuntosSuspensivos("Pasas tu turno aqui");
                                    }else if(Defender){
                                        DanioAtaque = DanioAtaque - guerreroEnemigo[1].getPuntosDefensa();

                                        if (DanioAtaque > 0){
                                            guerreroEnemigo[1].setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Lograste pasar la defensa del Guerrero!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }else{
                                            System.out.println("¡Se ha defendido de tu ataque!");
                                        }

                                        Defender = false;

                                    }else{
                                        guerreroEnemigo[1].setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Atacando un Guerrero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }

                                    break;

                                case 4:
                                    //guerrero 3
                                    if (guerreroEnemigo[2].getPuntosVitalidad() <= 0){
                                        System.out.println("Te regodeas con su cadaver y vuelves a visitarlo");
                                        mensaje.PausaPuntosSuspensivos("Pasas tu turno aqui");
                                    }else if(Defender){
                                        DanioAtaque = DanioAtaque - guerreroEnemigo[2].getPuntosDefensa();

                                        if (DanioAtaque > 0){
                                            guerreroEnemigo[2].setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Lograste pasar la defensa del Guerrero!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }else{
                                            System.out.println("¡Se ha defendido de tu ataque!");
                                        }

                                        Defender = false;

                                    }else{
                                        guerreroEnemigo[2].setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Atacando un Guerrero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }

                                    break;

                                case 5:
                                    Turno = true;

                                    break;

                                default:
                                    System.out.println("Opcion Invalida");
                                    Turno = true;

                                    break;
                            }

                        }

                        break;

                    case 2:
                        //Defender
                        mensaje.PausaPuntosSuspensivos("Preparas tu defensa");
                        Defender = true;
                        Turno = false;

                        break;

                    case 3:
                        //Tu Ejercito
                        TheKing.getVer();
                        Thread.sleep(500);
                        caballero.getVer();
                        Thread.sleep(500);
                        for (int NumGuerrero = 0; NumGuerrero < 3; NumGuerrero++) {
                            guerrero[NumGuerrero].getVer();
                            Thread.sleep(500);
                        }

                        System.out.println("[Presiona ENTER para continuar]");

                        System.in.read();

                        break;

                    case 2017:
                        //Ejercito Enemigo
                        ReyEnemigo.getVer();
                        Thread.sleep(500);
                        caballeroEnemigo.getVer();
                        Thread.sleep(500);
                        for (int NumGuerrero = 0; NumGuerrero < 3; NumGuerrero++) {
                            guerreroEnemigo[NumGuerrero].getVer();
                            Thread.sleep(500);
                        }

                        System.out.println("[Presiona ENTER para continuar]");

                        System.in.read();


                        break;

                    case 0:
                        //Rendirse

                        System.out.println("\n\n\n\n\n\n[GAME OVER]\n\n");
                        mensaje.PausaPuntosSuspensivos("Pierdes tu Reino");
                        opcion = 0;

                        break;
                    default:
                        System.out.println("Opcion Invalida");

                        break;
                }
            }else if(!Turno){
                if (ReyEnemigo.getPuntosVitalidad() > 0)
                {
                    Turno = true;

                    mensaje.PausaPuntosSuspensivos("Turno del Enemigo");

                    switch (rnd.nextInt(5)){

                        case 0:
                            //ataca
                            DesicionEnemigo = true;
                            break;

                        case 1:
                            //defiende
                            if (Defender){
                                DesicionEnemigo = true;
                            }else
                            {
                                DesicionEnemigo = false;
                            }
                            break;

                        case 2:
                            //ataca
                            DesicionEnemigo = true;
                            break;

                        case 3:
                            //defiende
                            if (Defender){
                                DesicionEnemigo = true;
                            }else
                            {
                                DesicionEnemigo = false;
                            }
                            break;

                        case 4:
                            //ataca
                            DesicionEnemigo = true;
                            break;
                    }

                    if (DesicionEnemigo)
                    {
                        mensaje.PausaPuntosSuspensivos("El Rey Enemigo prepara su estrategia");

                        //elige con quien atacar

                        opcionTemp = rnd.nextInt(5);

                        if ((opcionTemp == 4) && (guerreroEnemigo[2].getPuntosVitalidad() <= 0)) {
                            opcionTemp = 3;
                        } else if ((opcionTemp == 3) && (guerreroEnemigo[1].getPuntosVitalidad() <= 0)) {
                            opcionTemp = 2;
                        } else if ((opcionTemp == 2) && (guerreroEnemigo[0].getPuntosVitalidad() <= 0)) {
                            opcionTemp = 1;
                        } else if ((opcionTemp == 1) && (caballeroEnemigo.getPuntosVitalidad() <= 0)) {
                            opcionTemp = 0;
                        }

                        switch (opcionTemp){

                            case 0:
                                //Rey enemigo
                                DanioAtaque = ReyEnemigo.getPuntosAtaque()*2;
                                break;

                            case 1:
                                //caballero
                                if (caballeroEnemigo.PuntosVitalidad > 0) {
                                    DanioAtaque = caballeroEnemigo.getPuntosAtaque()*2;
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, el enemigo pierde el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                            case 2:
                                //Guerrero 1
                                if (guerreroEnemigo[0].PuntosVitalidad > 0) {
                                    DanioAtaque = guerreroEnemigo[0].getPuntosAtaque()*2;
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, el enemigo pierde el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                            case 3:
                                //Guerrero 2
                                if (guerreroEnemigo[1].PuntosVitalidad > 0) {
                                    DanioAtaque = guerreroEnemigo[1].getPuntosAtaque()*2;
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, el enemigo pierde el turno");
                                    DanioAtaque = 0;
                                }

                                break;

                            case 4:
                                //Guerrero 3
                                if (guerreroEnemigo[2].PuntosVitalidad > 0) {
                                    DanioAtaque = guerreroEnemigo[2].getPuntosAtaque()*2;
                                }else{
                                    System.out.println("Opcion Invalida");
                                    mensaje.PausaPuntosSuspensivos("Los muertos no atacan, el enemigo pierde el turno");
                                    DanioAtaque = 0;
                                }

                                break;
                        }

                        //elige a quien atacar

                        opcionTemp = rnd.nextInt(5);

                        if ((opcionTemp == 4) && (guerreroEnemigo[2].getPuntosVitalidad() <= 0)) {
                            opcionTemp = 3;
                        } else if ((opcionTemp == 3) && (guerreroEnemigo[1].getPuntosVitalidad() <= 0)) {
                            opcionTemp = 2;
                        } else if ((opcionTemp == 2) && (guerreroEnemigo[0].getPuntosVitalidad() <= 0)) {
                            opcionTemp = 1;
                        } else if ((opcionTemp == 1) && (caballeroEnemigo.getPuntosVitalidad() <= 0)) {
                            opcionTemp = 0;
                        }

                        switch (opcionTemp){

                            case 0:
                                //rey jugador
                                if (caballero.PuntosVitalidad <= 0){

                                    if(Defender){
                                        DanioAtaque = DanioAtaque - TheKing.getPuntosDefensa();

                                        if (DanioAtaque > 0){
                                            TheKing.setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Logro pasar la defensa de tu rey!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }else{
                                            System.out.println("¡Te has defendido!");
                                        }

                                        Defender = false;

                                    }else{
                                        TheKing.setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Atacan tu Rey!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }

                                }else {
                                    System.out.println("¡Intentan atacarte Rey de "+TheKing.Reino+"!");
                                    mensaje.PausaPuntosSuspensivos("Tu Caballero responde");

                                    if(Defender){
                                        DanioAtaque = DanioAtaque - caballero.getPuntosDefensa();

                                        if (DanioAtaque > 0){
                                            caballero.setPuntosVitalidadAtaque(DanioAtaque);
                                            System.out.println("¡Lograron pasar la defensa de tu Caballero!");
                                            System.out.println("- "+DanioAtaque+" de daño.");
                                        }else{
                                            System.out.println("¡Te has defendido!");
                                        }

                                        Defender = false;

                                    }else{
                                        caballero.setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Redirigen el ataque a tu Caballero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }
                                }
                                break;

                            case 1:
                                //caballero
                                if (caballero.getPuntosVitalidad() <= 0){
                                    System.out.println("Festejan con el cadaver de tu caballero y vuelven a visitarlo");
                                    mensaje.PausaPuntosSuspensivos("Pasan su turno aqui");
                                }else if(Defender){
                                    DanioAtaque = DanioAtaque - caballero.getPuntosDefensa();

                                    if (DanioAtaque > 0){
                                        caballero.setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Lograron pasar la defensa de tu Caballero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }else{
                                        System.out.println("¡Te has defendido!");
                                    }

                                    Defender = false;

                                }else{
                                    caballero.setPuntosVitalidadAtaque(DanioAtaque);
                                    System.out.println("¡Atacan tu Caballero!");
                                    System.out.println("- "+DanioAtaque+" de daño.");
                                }

                                break;

                            case 2:
                                // guerrero 1
                                if (guerrero[0].getPuntosVitalidad() <= 0){
                                    System.out.println("Festejan con el cadaver de tu guerrero y vuelven a visitarlo");
                                    mensaje.PausaPuntosSuspensivos("Pasan su turno aqui");
                                }else if(Defender){
                                    DanioAtaque = DanioAtaque - guerrero[0].getPuntosDefensa();

                                    if (DanioAtaque > 0){
                                        guerrero[0].setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Logran pasar la defensa del Guerrero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }else{
                                        System.out.println("¡Te has defendido!");
                                    }

                                    Defender = false;

                                }else{
                                    guerrero[0].setPuntosVitalidadAtaque(DanioAtaque);
                                    System.out.println("¡Atacan tu Guerrero!");
                                    System.out.println("- "+DanioAtaque+" de daño.");
                                }

                                break;

                            case 3:
                                //guerrero 2
                                if (guerrero[1].getPuntosVitalidad() <= 0){
                                    System.out.println("Festejan con el cadaver de tu guerrero y vuelven a visitarlo");
                                    mensaje.PausaPuntosSuspensivos("Pasan su turno aqui");
                                }else if(Defender){
                                    DanioAtaque = DanioAtaque - guerrero[1].getPuntosDefensa();

                                    if (DanioAtaque > 0){
                                        guerrero[1].setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Logran pasar la defensa del Guerrero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }else{
                                        System.out.println("¡Te has defendido!");
                                    }

                                    Defender = false;

                                }else{
                                    guerrero[1].setPuntosVitalidadAtaque(DanioAtaque);
                                    System.out.println("¡Atacan tu Guerrero!");
                                    System.out.println("- "+DanioAtaque+" de daño.");
                                }

                                break;

                            case 4:
                                //guerrero 3
                                if (guerrero[2].getPuntosVitalidad() <= 0){
                                    System.out.println("Festejan con el cadaver de tu guerrero y vuelven a visitarlo");
                                    mensaje.PausaPuntosSuspensivos("Pasan su turno aqui");
                                }else if(Defender){
                                    DanioAtaque = DanioAtaque - guerrero[2].getPuntosDefensa();

                                    if (DanioAtaque > 0){
                                        guerrero[2].setPuntosVitalidadAtaque(DanioAtaque);
                                        System.out.println("¡Logran pasar la defensa del Guerrero!");
                                        System.out.println("- "+DanioAtaque+" de daño.");
                                    }else{
                                        System.out.println("¡Te has defendido!");
                                    }

                                    Defender = false;

                                }else{
                                    guerrero[2].setPuntosVitalidadAtaque(DanioAtaque);
                                    System.out.println("¡Atacan tu Guerrero!");
                                    System.out.println("- "+DanioAtaque+" de daño.");
                                }

                                break;
                        }
                    }else{
                        mensaje.PausaPuntosSuspensivos("El Rey Enemigo decide defenderse");
                        Defender = true;
                    }
                }
            }

            if((TheKing.getPuntosVitalidad() <= 0)||(ReyEnemigo.getPuntosVitalidad() <= 0)) {
                opcion = 0;
            }

        }while(opcion != 0);

        if (TheKing.getPuntosVitalidad() <= 0){
            System.out.println("\n\n\n\n\n\n[GAME OVER]\n\n");
            mensaje.PausaPuntosSuspensivos("Pierdes tu Reino");
        }else if (ReyEnemigo.getPuntosVitalidad() <= 0){
            System.out.println("\n\n\n\n\n\n[GAME OVER]\n\n");
            System.out.println("¡VICTORIA!");
            mensaje.PausaPuntosSuspensivos("Liberas al Pueblo de la mano de aquel tirano rey");
        }



    }
}