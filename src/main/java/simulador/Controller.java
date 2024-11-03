package simulador;

import java.io.Serializable;
import java.util.*;

import simulador.View.Menu;
import simulador.logicaNegocio.Pokemones.Abra;
import simulador.logicaNegocio.Pokemones.Bulbasaur;
import simulador.logicaNegocio.Pokemones.Charmander;
import simulador.logicaNegocio.Pokemones.Geodude;
import simulador.logicaNegocio.Pokemones.Grimer;
import simulador.logicaNegocio.Pokemones.Jigglypuff;
import simulador.logicaNegocio.Pokemones.Machop;
import simulador.logicaNegocio.Pokemones.Pidgey;
import simulador.logicaNegocio.Pokemones.Pikachu;
import simulador.logicaNegocio.Pokemones.Squirtle;
import simulador.logicaNegocio.entrenador.*;
import simulador.logicaNegocio.pokemon.Estados;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;
 

public class Controller implements Serializable{
    Scanner sc = new Scanner(System.in);

    HashMap<String,Entrenador> entrenadores = new HashMap<>();
    HashMap<String,Pokemon> pokemones = new HashMap<>();
    LinkedList<String> Pokemones = new LinkedList<>();
    
    public Controller(){
        Pokemones.add("1. Abra");
        Pokemones.add("2. Bulbasaur");
        Pokemones.add("3. Charmander");
        Pokemones.add("4. Geodude");
        Pokemones.add("5. Grimer");
        Pokemones.add("6. Jigglypuff");
        Pokemones.add("7. Machop");
        Pokemones.add("8. Pidgey");
        Pokemones.add("9. Pikachu");
        Pokemones.add("10. Squirtle");     
    }

    public void seleccionarPokemon(){

        System.out.println("Seleccione una opción: ");
        for (String pokemon : Pokemones) {
            System.out.println(pokemon); }
        int opcion = sc.nextInt();
        
        switch (opcion) {
            
            case 1:
            pokemones.put("Abra", new Abra("Abra", 25, 20, TipoPokemon.PSIQUICO, null));
                break;
            case 2:
            pokemones.put("Bulbasaur", new Bulbasaur("Bulbasaur", 45, 49, TipoPokemon.PLANTA, null));
                break;
            case 3:
            pokemones.put ("Charmander", new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO, null ));
                break;
            case 4:
            pokemones.put("Geodude", new Geodude("Geodude", 40, 80, TipoPokemon.ROCA, null ));
                break;
            case 5:
            pokemones.put("Grimer", new Grimer("Grimer", 80, 80, TipoPokemon.VENENO, null));
                break;
            case 6:
            pokemones.put("Jigglypuff", new Jigglypuff("Jigglypuff", 115, 45, TipoPokemon.HADA, null));
                break;
            case 7:
            pokemones.put("Machop", new Machop("Machop", 70, 80, TipoPokemon.LUCHA, null));
                break;
            case 8: 
            pokemones.put("Pidgey", new Pidgey("Pidgey", 40, 45, TipoPokemon.VOLADOR, null));
                break;
            case 9:
            pokemones.put("Pikachu", new Pikachu("Pikachu", 35, 55, TipoPokemon.ELECTRICO, null));
                break;
            case 10:
            pokemones.put("Squirtle", new Squirtle("Squirtle", 44, 48, TipoPokemon.AGUA, null));
            break;

            default:
                throw new AssertionError();
        }
    }





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

                    }
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


