package simulador.logicaNegocio.pokemon;

public enum TipoPokemon{
   FUEGO, AGUA, PLANTA, VENENO,ELECTRICO,PSIQUICO,ROCA,TIERRA,NORMAL,VOLADOR,HADA,LUCHA,ACERO,BICHO,HIELO,FANTASMA;

   public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor){
      switch (atacante) {
         case FUEGO:
            if(defensor == AGUA || defensor == ROCA || defensor == ACERO) return 0.5;
            else if(defensor == PLANTA || defensor == BICHO || defensor  == HIELO) return 2.0;
            break;
         case AGUA:
            if(defensor == FUEGO || defensor == ROCA) return 2.0;
            else if(defensor == PLANTA) return 0.5;
            break;
         case PLANTA:
            if(defensor == AGUA || defensor == ROCA || defensor == TIERRA) return 2.0;
            else if(defensor == ACERO || defensor == BICHO || defensor == VENENO || defensor == FUEGO) return 0.5;
            break;
         case VENENO: 
            if(defensor == PLANTA || defensor == HADA) return 2.0;
            else if(defensor == ROCA || defensor == FANTASMA) return 0.5;
            break;
         case ELECTRICO:
            if(defensor == AGUA || defensor == VOLADOR) return 2.0;
            else if(defensor == PLANTA) return 0.5;
            else if(defensor == TIERRA) return 0.0;
         case PSIQUICO:
            if(defensor == VENENO || defensor == LUCHA) return 2.0;
         case ROCA:
            if(defensor == FUEGO || defensor == VOLADOR || defensor == ACERO || defensor == BICHO || defensor == HIELO) return 2.0;
            else if(defensor == LUCHA) return 0.5;
         case TIERRA:
            if(defensor == FUEGO || defensor == VENENO || defensor == ROCA || defensor == ACERO) return 2.0;
            else if(defensor == VOLADOR) return 0.5;
            else if(defensor == ELECTRICO) return 0.0;
         case NORMAL:
            if(defensor ==  FANTASMA) return 0.0;
         case VOLADOR:
            if(defensor == PLANTA || defensor == ELECTRICO || defensor == BICHO) return 2.0;
            else if(defensor == ROCA) return 0.5;
         case HADA:
            if(defensor == PSIQUICO) return 2;
         case LUCHA:
            if(defensor == ROCA || defensor == NORMAL || defensor == HIELO) return 2.0;
            else if(defensor == PSIQUICO || defensor == HADA || defensor == FANTASMA) return 0.5;
         case ACERO:
            if(defensor == FUEGO || defensor == ROCA || defensor == HADA || defensor == LUCHA) return 2.0;
            else if(defensor == PSIQUICO) return 0.5;
         case BICHO:
            if(defensor == PLANTA || defensor == VOLADOR) return 2.0;
            else if(defensor == FANTASMA || defensor == ACERO) return 0.5;
         case HIELO:
            if(defensor == PLANTA || defensor == TIERRA) return 2.0;
         case FANTASMA:
            if(defensor == FANTASMA) return 2.0;
            else if(defensor == VENENO) return 0.5;
            else if(defensor == NORMAL) return 0.0;   
         default:   
            return 1;

      }
      return 1;
   }
}
