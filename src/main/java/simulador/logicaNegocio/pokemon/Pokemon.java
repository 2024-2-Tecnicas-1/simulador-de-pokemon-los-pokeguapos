package simulador.logicaNegocio.pokemon;

import java.io.Serializable;

public class Pokemon  implements Serializable{
    private String nombre;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private Estados estado;

    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, Estados estado){
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }

    // TODO: Falta completar de manera correcta los metodos.
    public void atacar(Pokemon oponente){
        // TODO: completar metodo
    }

    public void recibirDaño(int daño){
        // TODO: Completar metodo
    }
    
    public void entrenar(){
        this.salud += 5;
        this.puntosDeAtaque += 2;
    }

    // GETTERS
    public String getNombre(){
        return this.nombre;
    }
    
    public int getSalud(){
        return this.salud;
    }

    public int getPuntosDeAtaque(){
        return this.puntosDeAtaque;
    }

    public TipoPokemon getTipo(){
        return this.tipo;
    }

    public Estados getEstado(){
        return this.estado;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setPuntosDeAtaque(int puntosDeAtaque) {
        this.puntosDeAtaque = puntosDeAtaque;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
        

}
