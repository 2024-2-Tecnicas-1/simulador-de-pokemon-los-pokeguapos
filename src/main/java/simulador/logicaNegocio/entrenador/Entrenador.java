package simulador.logicaNegocio.entrenador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import simulador.View.ListaPokemones;
import simulador.logicaNegocio.pokemon.Pokemon;

public class Entrenador implements Serializable{
    private String nombreEntrenador;
    private List<Pokemon> pokemones = new ArrayList<>();

    public Entrenador(String nombreEntrenador, Pokemon pokBase){
        this.nombreEntrenador = nombreEntrenador;
        pokemones.add(pokBase);
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
