package simulador;

import java.io.Serializable;
import java.util.Scanner;

import simulador.View.Menu;

public class Controller implements Serializable{
    Scanner sc = new Scanner(System.in);

    public void run(){
        ConsoleMenuPrincipal();
        // Mejorar salida del juego
        System.out.println("Salida");
    }

    public void ConsoleMenuPrincipal(){
        int option = 0;
        while(option != 4){
            Menu.MenuPrincipal();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    ConsoleGestionarEntrenador();
                    break;
                case 2:
                    ConsoleGestionarPokemones();
                case 3:
                    // Logica de Batalla con Batalla.java
                case 4:
                    break;
                default:
                    System.out.println("Error, intentelo de nuevo...");
                    break;
            }
        }
    }

    public void ConsoleGestionarEntrenador(){
        int option = 0;
        while(option != 4){
            Menu.MenuGestionarEntrenadores();
            option = sc.nextInt();
            switch(option){
                case 1:
                    // Logica para registrar nuevo entrenador
                    break;
                case 2:
                    // Logica para mostrar lista de entrenadores
                    break;
                case 3:
                    // Logica para seleccionar entrenador
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error, intentelo de nuevo...");
                    break;
            }
        }
    }

    public void ConsoleGestionarPokemones(){
        int option = 0;
        while(option != 3){
            Menu.MenuGestionarPokemones();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    // Logica para Mostrar lista de pokemones registrados
                    break;
                case 2:
                    // Logica para registrar nuevo pokemon
                    break;
                case 3:
                    break;    
                default:
                    System.out.println("Error, intentelo de nuevo...");
                    break;
            }
        }
    } 
}


