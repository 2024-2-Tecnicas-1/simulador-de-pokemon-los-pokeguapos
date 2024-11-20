package simulador;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import persistencia.ArchivosConexion;

import simulador.View.ListaPokemones;
import simulador.View.Menu;
import simulador.logicaNegocio.ArchivosControlador;
import simulador.logicaNegocio.batalla.BatallaForm;
import simulador.logicaNegocio.entrenador.Entrenador;
import simulador.logicaNegocio.pokemon.Estados;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;

public class Controller implements Serializable {

    ArchivosControlador controlador = new ArchivosControlador();

    final String POKEMONES_DISPONIBLES_G = "pokemonesDisponibles.game"; // (G) Pokemones que nos tocaron
    final String ENTRENADORES_D_G = "entrenadoresD.game"; // (G)  Entrenadores diccionario
    final String ENTRENADORES_L_G = "entrenadoresL.game"; // (G) Entrenadores que ya estan registrados
    final String POKEMONES_REGISTRADOS_G = "pokemonesRegistrados.game"; // (G) pokemones registrados global
    final String POKEMONES_ENTRENADOR_G = "pokemonesEntrendor.game"; // (G) pokemones disponibles para eleccion a los entrenadores

    // Pokemones que nos tocaron
    List<Pokemon> disponiblesRegistro = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    HashMap<String, Entrenador> entrenadores = new HashMap<>(); // Entrenadores diccionario
    List<Entrenador> entrenadoresList = new ArrayList<>(); // Entrenadores que ya estan registrados

    // pokemones registrados global
    List<Pokemon> pokemonesList = new ArrayList<>();

    // pokemones disponibles para eleccion a los entrenadores
    List<Pokemon> disponiblesEntrenador = new ArrayList<>();

    // BASES
    List<Pokemon> pokemonesBase = new ArrayList<>();
    Entrenador entrenador = new Entrenador("Base", null);
    Pokemon pokBase = new Pokemon(null, 0, 0, null, null);

    public Controller() {
        pokemonesBase.add(pokBase);
        entrenadoresList.add(entrenador);
        pokemonesList.add(pokBase);
        disponiblesEntrenador.add(pokBase);
        agregarPokemones();
        File archivo = new File("datos/", POKEMONES_DISPONIBLES_G);
        System.out.println("archivo: " + archivo.getAbsolutePath());
        if (!archivo.exists()) {
            controlador.guardar(disponiblesRegistro, POKEMONES_DISPONIBLES_G);
        }

        archivo = new File("datos/", ENTRENADORES_D_G);
        if (!archivo.exists()) {
            controlador.guardar(entrenadores, ENTRENADORES_D_G);
        }

        archivo = new File("datos/", ENTRENADORES_L_G);
        if (!archivo.exists()) {
            controlador.guardar(entrenadoresList, ENTRENADORES_L_G);
        }

        archivo = new File("datos/", POKEMONES_REGISTRADOS_G);
        if (!archivo.exists()) {
            controlador.guardar(pokemonesList, POKEMONES_REGISTRADOS_G);
        }

        archivo = new File("datos/", POKEMONES_ENTRENADOR_G);
        if (!archivo.exists()) {
            controlador.guardar(disponiblesEntrenador, POKEMONES_ENTRENADOR_G);
        }
    }

    public void run() {

        Object object = controlador.leer(POKEMONES_DISPONIBLES_G);
        disponiblesRegistro = (ArrayList<Pokemon>) object;

        object = controlador.leer(ENTRENADORES_D_G);
        entrenadores = (HashMap<String, Entrenador>) object;

        object = controlador.leer(ENTRENADORES_L_G);
        entrenadoresList = (ArrayList<Entrenador>) object;

        object = controlador.leer(POKEMONES_REGISTRADOS_G);
        pokemonesList = (ArrayList<Pokemon>) object;

        object = controlador.leer(POKEMONES_ENTRENADOR_G);
        disponiblesEntrenador = (ArrayList<Pokemon>) object;

        ConsoleMenuPrincipal();
        // Mejorar salida del juego
        System.out.println("Salida");
    }

    public void ConsoleMenuPrincipal() {
        int option = 0;
        while (option != 4) {
            Menu.MenuPrincipal();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    ConsoleGestionarEntrenador();
                    break;
                case 2:
                    ConsoleGestionarPokemones();
                case 3:
                    if (entrenadoresList.size() >= 3) {
                        ConsoleBatalla();
                    } else {
                        System.out.println("No hay entrenadores suficientes para hacer una batalla");
                    }
                case 4:
                    break;
                default:
                    System.out.println("Error, intentelo de nuevo...");
                    break;
            }
        }
    }

    public void ConsoleGestionarEntrenador() {
        int option = 0;
        while (option != 4) {
            Menu.MenuGestionarEntrenadores();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    while (true) {
                        System.out.print("Escribe el nombre del nuevo entrenador: \n ->  ");
                        String nombre = sc.nextLine();
                        //nombre = nombre.toLowerCase();
                        if (entrenadores.containsKey(nombre)) {
                            System.out.println("Este nombre ya esta tomado por otro entrenador, elige otro nombre.");
                        } else {
                            entrenadores.put(nombre, new Entrenador(nombre, pokBase));
                            entrenadoresList.add(new Entrenador(nombre, pokBase));
                            System.out.println("El entrenador fue creado correctamente");
                            break;
                        }
                    }
                    controlador.guardar(entrenadores, ENTRENADORES_D_G);
                    controlador.guardar(entrenadoresList, ENTRENADORES_L_G);
                    break;
                case 2:
                    if (entrenadoresList.size() == 1) {
                        System.out.println("! No hay entrenadores registrados !");
                    } else {
                        MostrarEntrenadores();
                    }
                    break;
                case 3:
                    if (entrenadoresList.size() == 1) {
                        System.out.println("! No hay entrenadores registrados !");
                    } else {
                        MostrarEntrenadores();
                        while (true) {
                            System.out.print("Elija un entrenador ->\n");
                            int value = sc.nextInt();
                            if (value > 0 && value < entrenadoresList.size()) {
                                Entrenador entrenador = entrenadoresList.get(value);
                                ConsoleEntrenadorEspecifico(entrenador);
                                break;
                            } else {
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

    public void ConsoleEntrenadorEspecifico(Entrenador entrenador) {
        int value = 0;
        while (value != 4) {
            Menu.MenuEntrenadorEspecifico(entrenador.getNombre());
            value = 0;
            value = sc.nextInt();
            switch (value) {
                case 1:
                    entrenador.mostrarPokemones();
                    break;
                case 2:
                    if (disponiblesEntrenador.size() == 1) {
                        System.out.println("! No hay pokemones disponibles !");
                    } else {
                        mostrarPokemonesDisponiblesEntrenador();
                        while (true) {
                            int option = sc.nextInt();
                            if (option > 0 && option < disponiblesEntrenador.size()) {
                                Pokemon pokemon = disponiblesEntrenador.get(option);
                                disponiblesEntrenador.remove(option);
                                entrenador.agregarPokemon(pokemon);
                                break;
                            } else {
                                System.out.println("Error, intentelo de nuevo.");
                            }
                        }
                        controlador.guardar(entrenadoresList, ENTRENADORES_L_G);
                        controlador.guardar(entrenadores, ENTRENADORES_D_G);
                        controlador.guardar(disponiblesEntrenador, POKEMONES_ENTRENADOR_G);
                    }
                    break;
                case 3:
                    if (entrenador.getPokemones().size() <= 1) {
                        System.out.println("No hay pokemones disponibles para entrenar");
                    } else {
                        entrenador.mostrarPokemones();
                        while (true) {
                            System.out.print("Seleccione el pokemon que desea entrenar \n ->");
                            int pokemonSeleccionado = sc.nextInt();
                            if (pokemonSeleccionado > 0 && pokemonSeleccionado < entrenador.getPokemones().size()) {
                                Pokemon pokemon = entrenador.getPokemones().get(pokemonSeleccionado);
                                int salud = pokemon.getSalud();
                                int ataque = pokemon.getPuntosDeAtaque();
                                salud += 5;
                                ataque += 2;
                                pokemon.setPuntosDeAtaque(ataque);
                                pokemon.setSalud(salud);
                                System.out.println("¡Entrenamiento completado!");
                                System.out.println("Salud: " + pokemon.getSalud() + ", Puntos de Ataque: " + pokemon.getPuntosDeAtaque());
                                break;
                            } else {
                                System.out.println("Error, intentelo de nuevo.");
                            }
                        }
                        controlador.guardar(entrenadoresList, ENTRENADORES_L_G);
                        controlador.guardar(entrenadores, ENTRENADORES_D_G);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error, intentelo de nuevo.");
                    break;
            }
        }
    }

    public void ConsoleGestionarPokemones() {
        int option = 0;
        while (option != 3) {
            Menu.MenuGestionarPokemones();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    if (pokemonesList.size() == 1) {
                        System.out.println("! No hay pokemones registrados !");
                    } else {
                        mostrarPokemonesRegistrados();
                    }
                    break;
                case 2:
                    if (disponiblesRegistro.size() == 1) {
                        System.out.println("! No hay pokemones disponibles para registrar !");
                    } else {
                        while (true) {
                            mostrarPokemonesRegistro();
                            int value = sc.nextInt();
                            if (value > 0 && value < disponiblesRegistro.size()) {
                                Pokemon nuevoPokemon = disponiblesRegistro.get(value);
                                pokemonesList.add(nuevoPokemon);
                                disponiblesEntrenador.add(nuevoPokemon);
                                disponiblesRegistro.remove(value);
                                break;
                            } else {
                                System.out.println("Error, intente de nuevo");
                            }
                        }
                        controlador.guardar(disponiblesRegistro, POKEMONES_DISPONIBLES_G);
                        controlador.guardar(pokemonesList, POKEMONES_REGISTRADOS_G);
                        controlador.guardar(disponiblesEntrenador, POKEMONES_ENTRENADOR_G);
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

    public void ConsoleBatalla() {
        int option = 0;
        int value = 0;
        Entrenador entrenador1 = null;
        Pokemon pokemon1 = null;
        Entrenador entrenador2 = null;
        Pokemon pokemon2 = null;
        while (option != 6) {
            Menu.MenuBatalla();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    while (true) {
                        MostrarEntrenadores();
                        value = sc.nextInt();
                        entrenador1 = entrenadoresList.get(value);
                        if (value >= 1 && value <= entrenadoresList.size()) {
                            if (entrenador2 != null) {
                                if (entrenador1.getNombre() == entrenador2.getNombre()) {
                                    System.out.println("Este entrenador ya ha sido seleccionado. Intente de nuevo");
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Error, intente de nuevo");
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        MostrarEntrenadores();
                        value = sc.nextInt();
                        entrenador2 = entrenadoresList.get(value);
                        if (value >= 1 && value <= entrenadoresList.size()) {
                            if (entrenador1 != null) {
                                if (entrenador1.getNombre() == entrenador2.getNombre()) {
                                    System.out.println("Este entrenador ya ha sido seleccionado. Intente de nuevo");
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Error, intente de nuevo");
                        }
                    }
                    break;
                case 3:
                    if (entrenador1 != null) {
                        if (entrenador1.getPokemones().size() <= 1) {
                            System.out.println("No hay pokemones disponibles");
                        } else {
                            entrenador1.mostrarPokemones();
                            while (true) {
                                System.out.print("Seleccione el pokemon con el que desea luchar \n ->");
                                int pokemonSeleccionado = sc.nextInt();
                                if (pokemonSeleccionado > 0 && pokemonSeleccionado < entrenador1.getPokemones().size()) {
                                    pokemon1 = entrenador1.getPokemones().get(pokemonSeleccionado);
                                    break;
                                } else {
                                    System.out.println("Error, intentelo de nuevo.");
                                }
                            }
                        }
                    } else {
                        System.out.println("El entrenador 1 no ha sido selecciondo");
                    }
                    break;
                case 4:
                    if (entrenador2 != null) {
                        if (entrenador2.getPokemones().size() <= 1) {
                            System.out.println("No hay pokemones disponibles");
                        } else {
                            entrenador2.mostrarPokemones();
                            while (true) {
                                System.out.print("Seleccione el pokemon con el que desea luchar \n ->");
                                int pokemonSeleccionado = sc.nextInt();
                                if (pokemonSeleccionado > 0 && pokemonSeleccionado < entrenador2.getPokemones().size()) {
                                    pokemon2 = entrenador2.getPokemones().get(pokemonSeleccionado);
                                    break;
                                } else {
                                    System.out.println("Error, intentelo de nuevo.");
                                }
                            }
                        }
                    } else {
                        System.out.println("El entrenador 1 no ha sido selecciondo");
                    }
                    break;
                case 5:
                    if (entrenador1 == null || entrenador2 == null || pokemon1 == null || pokemon2 == null) {
                        System.out.println("ERROR, para poder batallar debe haber seleccionado los 2 entrenadores y los 2 pokemones que lucharan");
                    } else {
                        BatallaForm batalla = new BatallaForm(pokemon1, pokemon2);
                        batalla.setVisible(true);
                    }
                    break;
                case 6:
                    break;
            }
        }

    }

    public void agregarPokemones() {
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
        nuevoPokemon = new Pokemon("Pidgey", 40, 45, TipoPokemon.NORMAL, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Jigglypuff", 115, 45, TipoPokemon.HADA, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Machop", 70, 80, TipoPokemon.LUCHA, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
        nuevoPokemon = new Pokemon("Grimer", 80, 80, TipoPokemon.VENENO, Estados.NORMAL);
        disponiblesRegistro.add(nuevoPokemon);
    }

    void MostrarEntrenadores() {
        for (int i = 1; i < entrenadoresList.size(); i++) {
            System.out.println(i + ". | " + entrenadoresList.get(i).getNombre() + " | ");
        }
    }

    void mostrarPokemonesRegistro() {
        for (int i = 1; i < disponiblesRegistro.size(); i++) {
            System.out.println(i + ". | " + disponiblesRegistro.get(i).getNombre());
        }
    }

    void mostrarPokemonesRegistrados() {
        for (int i = 1; i < pokemonesList.size(); i++) {
            Pokemon pokemon = pokemonesList.get(i);
            ListaPokemones.Lista(pokemon);
        }
    }

    void mostrarPokemonesDisponiblesEntrenador() {
        for (int i = 1; i < disponiblesEntrenador.size(); i++) {
            Pokemon pokemon = disponiblesEntrenador.get(i);
            ListaPokemones.Lista(pokemon);
        }
    }

    void mostrarPokemonesEntrenadorEspecifico(List<Pokemon> pokemones) {
        for (int i = 1; i < pokemones.size(); i++) {
            Pokemon pokemon = pokemones.get(i);
            ListaPokemones.Lista(pokemon);
        }
    }
}
