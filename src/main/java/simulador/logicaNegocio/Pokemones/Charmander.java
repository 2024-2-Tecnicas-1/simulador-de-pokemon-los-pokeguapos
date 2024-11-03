package simulador.logicaNegocio.Pokemones;

import simulador.logicaNegocio.pokemon.Estados;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;

public class Charmander extends Pokemon {
    
    public Charmander(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, Estados estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);
    }
    
}
