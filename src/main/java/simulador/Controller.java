package simulador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import simulador.View.Menu;
import simulador.logicaNegocio.entrenador.*;
import simulador.logicaNegocio.pokemon.Pokemon;
 

public class Controller implements Serializable{
    Scanner sc = new Scanner(System.in);

    HashMap<String,Entrenador> entrenadores = new HashMap<>();
    HashMap<String,Pokemon> pokemones = new HashMap<>();

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
            sc.nextLine();
            switch(option){
                case 1:
                    while(true){
                        System.out.print("Escribe el nombre del nuevo entrenador: \n ->  ");
                        String nombre = sc.nextLine();
                        nombre = nombre.toLowerCase();
                        if(entrenadores.containsKey(nombre)){
                            System.out.println("Este nombre ya esta tomado por otro entrenador, elige otro nombre.");
                        } else {
                            entrenadores.put(nombre,new Entrenador(nombre, null));
                            System.out.println("El entrenador fue creado correctamente");
                            break;
                        }
                    }
                    break;
                case 2:
                    for(String entrenador: entrenadores.keySet()){
                        System.out.println("- " + entrenador);
                    }
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
                    // Logica para Mostrar lista de pokemones registrados - DANIEL
                    break;
                case 2:
                    // Logica para registrar nuevo pokemon - LUISA
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


