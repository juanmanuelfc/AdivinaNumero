package EjerciciosRandom;/*
Hecho dia lun. 14/12/2020
Creado por: Juanma
Paquete: EjerciciosRandom
Descripcion:
*/

import java.util.*;
public class JuegoCincoIntentos {
    private int saldoTotal = 20;
    private int saldoJugador = 0;

    public void Jugar(){
        Scanner consola = new Scanner(System.in);
        System.out.println("Introduzca 1€ por favor.");
        int insertarEuro = consola.nextInt();
        if (insertarEuro == 1){
            this.saldoTotal++;
            Random random = new Random();
            int numeroRandom = random.nextInt(99 + 1);
            ArrayList<Integer> intentos = new ArrayList<>();
            boolean bool = true;
            int i = 5;
            while (bool) {
                System.out.println("Te quedan " + i + " intentos.");
                System.out.println("Introduce un numero del 1 al 100.");
                int numero = consola.nextInt();
                intentos.add(numero);
                if (i == 1 && numero != numeroRandom){
                    System.out.println("Ha perdido la partida.");
                    bool = false;
                }
                else {
                    if (numero == numeroRandom){
                        System.out.println("Has ganado la partida, enhorabuena.");
                        this.saldoJugador += 5;
                        bool = false;
                    }
                    else if (numero < numeroRandom){
                        System.out.println("El numero es mas grande.");
                    }
                    else{
                        System.out.println("El numero es mas pequeño");
                    }
                }
                i--;
            }
            System.out.println("El numero era " + numeroRandom + "!");
            System.out.print("Sus intentos han sido: ");
            for (Integer intento : intentos) {
                System.out.print(intento + " ");
            }
            MenuPrincipal();
        }
        else {
            System.out.println("No ha introducido la cantidad requerida.");
            Jugar();
        }
    }

    public void apagarConsola(){
        boolean juegoActivo = true;
        while (juegoActivo){
            Scanner consola = new Scanner(System.in);
            System.out.println("Introduce la contraseña para apagar.");
            String apagar = consola.nextLine();
            if (apagar.equals("qwerty1234")) {
                juegoActivo = false;
            } else {
                System.out.println("Contrasena incorrecta.");
            }
        }
    }

    public int getSaldoTotal(){
        return this.saldoTotal;
    }

    public void retirarDineroJugador(){
        this.saldoTotal -= this.saldoJugador;
        this.saldoJugador = 0;
    }

    public void MenuPrincipal(){
        Scanner consolaMenu = new Scanner(System.in);
        System.out.println("\nMENU");
        System.out.println("1. Jugar.");
        System.out.println("2. Dejar de jugar y retirar ganancias.");
        System.out.println("3. Consultar el saldo ganado hoy.");
        System.out.println("4. Apagar. (ADMINISTRADOR)");
        int menu = consolaMenu.nextInt();
        switch (menu){
            case 1:
                Jugar();
                break;
            case 2:
                if (this.saldoJugador > 0){
                    System.out.println("Ha ganado " + this.saldoJugador + "€.");
                    System.out.println("Retirando dinero...");
                    retirarDineroJugador();
                    MenuPrincipal();
                }
                else {
                    System.out.println("Usted no ha tenido ninguna ganancia...");
                    MenuPrincipal();
                }
                break;
            case 3:
                System.out.println("Ganancias de hoy : " + getSaldoTotal() + "€.");
                MenuPrincipal();
                break;
            case 4:
                apagarConsola();
                break;
        }
    }
}
