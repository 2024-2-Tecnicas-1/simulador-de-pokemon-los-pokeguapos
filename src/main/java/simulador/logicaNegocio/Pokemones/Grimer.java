package simulador.logicaNegocio.Pokemones;

import simulador.logicaNegocio.pokemon.Estados;
import simulador.logicaNegocio.pokemon.Pokemon;
import simulador.logicaNegocio.pokemon.TipoPokemon;

public class Grimer extends Pokemon{

    public Grimer(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, Estados estado){
        
        super(nombre, salud, puntosDeAtaque, tipo, estado);
    }

}
