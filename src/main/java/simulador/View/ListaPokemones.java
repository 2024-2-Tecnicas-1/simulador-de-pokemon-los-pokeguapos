package simulador.View;

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
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "      ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case    "Abra":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                    ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "   ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Bulbasaur":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "     ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Geodude":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                 ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "     ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Grimer":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                  ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "     ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Jigglypuff":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "              ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "              ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "       ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Machop":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                  ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "      ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Pidgey":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                  ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "     ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Pikachu":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                 ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "  ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;
            case "Squirtle":
                System.out.println("╔═══════════════════════════════════════╗");
                System.out.println("║               " + nombre +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Salud: " + salud +  "               ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║               Daño: " + daño +  "                ║");
                System.out.println("╠═══════════════════════════════════════╣");
                System.out.println("║           Tipo de pokémon: " + tipo +  "       ║");
                System.out.println("╚═══════════════════════════════════════╝");
                break;


            default:
                break;
        }
    }
}
