package simulador.pokemon;

public class Pokemon {
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
        // TODO: Completar metodo
    }

}
