package simulador.View;

import simulador.logicaNegocio.entrenador.Entrenador;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;

public class ListaPokemones {
    public static void Lista(Pokemon pokemon){
        String nombre = pokemon.getNombre();
        int salud = pokemon.getSalud();
        int daño = pokemon.getPuntosDeAtaque();            
        TipoPokemon tipo = pokemon.getTipo();


        switch (pokemon.getNombre()) {
            case "Charmander":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "              ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "              ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Abra":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "              ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╚═══════════════════════════════════════╝");
            default:
                break;
        }
    }
}
