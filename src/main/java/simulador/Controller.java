package simulador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import simulador.View.ListaPokemones;
import simulador.View.Menu;
import simulador.logicaNegocio.entrenador.Entrenador;
import simulador.logicaNegocio.pokemon.Estados;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;
 

public class Controller implements Serializable{
    Scanner sc = new Scanner(System.in);
    
    //HashMap<Pokemon,Boolean> disponiblesRegistroMap = new HashMap<>();
    List<Pokemon> disponiblesRegistro = new ArrayList<>();

    HashMap<String,Entrenador> entrenadores = new HashMap<>();
    List<Entrenador> entrenadoresList = new ArrayList<>();     

    //HashMap<String,Pokemon> pokemones = new HashMap<>();
    List<Pokemon> pokemonesList = new ArrayList<>();
    
    HashMap<Pokemon,Boolean> disponiblesEntrenadorMap = new HashMap<>();
    List<Pokemon> disponiblesEntrenador = new ArrayList<>();

    // BASES
    List<Pokemon> pokemonesBase = new ArrayList<>();
    Entrenador entrenador = new Entrenador("Base", null);
    Pokemon pokBase = new Pokemon(null, 0, 0, null, null);

    public Controller(){
        pokemonesBase.add(pokBase);
        entrenadoresList.add(entrenador);
        pokemonesList.add(pokBase);
        agregarPokemones();
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
                        //nombre = nombre.toLowerCase();
                        if(entrenadores.containsKey(nombre)){
                            System.out.println("Este nombre ya esta tomado por otro entrenador, elige otro nombre.");
                        } else {
                            entrenadores.put(nombre,new Entrenador(nombre, pokemonesBase));
                            entrenadoresList.add(new Entrenador(nombre, pokemonesBase));
                            System.out.println("El entrenador fue creado correctamente");
                            break;
                        }
                    }
                    break;
                case 2:
                    if(entrenadoresList.size() == 1){
                        System.out.println("! No hay entrenadores registrados !");
                    } else {
                        MostrarEntrenadores();
                    }
                    break;
                case 3:
                    if(entrenadoresList.size() == 1){
                        System.out.println("! No hay entrenadores registrados !");
                    } else {
                        MostrarEntrenadores();
                        while(true){
                            System.out.print("Elija un entrenador ->\n");
                            int value = sc.nextInt();
                            if(value > 0 && value < entrenadoresList.size()){
                                Entrenador entrenador = entrenadoresList.get(value);
                                ConsoleEntrenadorEspecifico(entrenador);
                                break;
                            } else{
                                System.out.println("Error, intentelo de nuevo");
                            }
                        }
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error, intentelo de nuevo...");
                    break;
            }
        }
    }

    public void ConsoleEntrenadorEspecifico(Entrenador entrenador){
        Menu.MenuEntrenadorEspecifico(entrenador.getNombre());
        int value = 0;
        while(value != 4){
            value = sc.nextInt();
            switch (value) {
                case 1:
                    // Logica de ver equipo de pokemones;
                    break;
                case 2:
                    // logica de Agregar Pokémon al equipo
                case 3:
                    // Logica de Entrenar Pokémon
                case 4:
                    break;
                default:
                    System.out.println("Error, intentelo de nuevo");
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
                    if(pokemonesList.size() == 1){
                        System.out.println("! No hay pokemones registrados !");
                    } else {
                        mostrarPokemonesRegistrados();
                    }
                    break;
                case 2:
                    if(disponiblesRegistro.size() == 1){
                        System.out.println("! No hay pokemones disponibles para registrar !");
                    } else {
                        while(true){
                            mostrarPokemonesRegistro();
                            int value = sc.nextInt();
                            if(value > 0 && value < disponiblesRegistro.size()){
                                Pokemon nuevoPokemon = disponiblesRegistro.get(value);
                                pokemonesList.add(nuevoPokemon);
                                disponiblesEntrenador.add(nuevoPokemon);
                                disponiblesRegistro.remove(value);
                                break;
                            } else {
                                System.out.println("Error, intente de nuevo");
                            }
                        }
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

    public void agregarPokemones(){
        disponiblesRegistro.add(pokBase);
        Pokemon nuevoPokemon = new Pokemon("Charmander", 39, 52, TipoPokemon.FUEGO, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Squirtle", 44, 48, TipoPokemon.AGUA, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Bulbasaur", 45, 49, TipoPokemon.PLANTA, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Pikachu", 45, 49, TipoPokemon.ELECTRICO, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Abra", 25, 80, TipoPokemon.PSIQUICO, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Geodude", 40, 80, TipoPokemon.TIERRA, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Pidgey", 40,45, TipoPokemon.NORMAL,Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Jigglypuff",115,45,TipoPokemon.HADA,Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Machop",70,80, TipoPokemon.LUCHA,Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Grimer", 80, 80, TipoPokemon.VENENO,Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
    }

    void MostrarEntrenadores(){
        for(int i = 1; i < entrenadoresList.size(); i++){
            System.out.println(i + ". | " + entrenadoresList.get(i).getNombre() + " | ");
        }
    }

    void mostrarPokemonesRegistro(){
        for(int i = 1; i < disponiblesRegistro.size(); i++){
            System.out.println(i + ". | " + disponiblesRegistro.get(i).getNombre());
        }
    }

    void mostrarPokemonesRegistrados(){
        for(int i = 1; i < pokemonesList.size(); i++){
            Pokemon pokemon = pokemonesList.get(i);
            ListaPokemones.Lista(pokemon);
        }
    }
}


