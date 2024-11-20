package simulador;

import simulador.logicaNegocio.Pokemones.Bulbasaur;
import simulador.logicaNegocio.Pokemones.Charmander;
import simulador.logicaNegocio.batalla.BatallaForm;
import simulador.logicaNegocio.pokemon.Estados;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;

public class Principal {
    public static void main(String[] args) {
        Controller start = new Controller();
        /*
        Pokemon charmander = new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO, Estados.NORMAL);
        Pokemon bulbasaur = new Bulbasaur("Bulbasaur", 45, 49, TipoPokemon.PLANTA, Estados.NORMAL);
        BatallaForm batalla = new BatallaForm(charmander,bulbasaur);
        batalla.setVisible(true);
        */
        start.run();
    }
}
