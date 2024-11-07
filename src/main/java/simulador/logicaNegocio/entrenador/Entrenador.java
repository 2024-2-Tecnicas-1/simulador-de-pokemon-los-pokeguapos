package simulador.logicaNegocio.entrenador;

import java.util.List;

import simulador.View.ListaPokemones;
import simulador.logicaNegocio.pokemon.Pokemon;

public class Entrenador {
    private String nombreEntrenador;
    private List<Pokemon> pokemones;

    public Entrenador(String nombreEntrenador, List<Pokemon> pokemones){
        this.nombreEntrenador = nombreEntrenador;
        this.pokemones = pokemones;

    }

    public void agregarPokemon (Pokemon pokemon){
        pokemones.add(pokemon);
    }
    
    public void mostrarPokemones(){
        if(pokemones.size() == 1){
            System.out.println("! No hay pokemones registrados !");
        } else {
            for(int i = 1; i < pokemones.size(); i++){
                Pokemon pokemon = pokemones.get(i);
                ListaPokemones.Lista(pokemon);
            }
        }
    }
    public void prepararBatalla(){
        //TODO: completar el metodo
    }

    public String getNombre(){
        return this.nombreEntrenador;
    }
    
    public List<Pokemon> getPokemones(){
        return this.pokemones;
    }
}
