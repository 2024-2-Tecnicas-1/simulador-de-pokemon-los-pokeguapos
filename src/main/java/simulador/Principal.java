package simulador;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int salir = 0;
        while (salir  != 4) {
            System.out.println("Simulador de batallas pokemon");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestion de pokemones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");

            int opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                int volver = 0;
                    while(volver != 4){
                        System.out.println("1. Registrar nuevo entrenador");
                        System.out.println("2. Ver lista de entrenadores");
                        System.out.println("3. Seleccionar un entrenador");
                        System.out.println("4. Volver al menu principal");
                        int opcion2 = scan.nextInt();
                        switch (opcion2) {
                            case 1:
                            System.out.println("Resgistrate aqui entrenador nuevo");
                            String entrenador = scan.nextLine();    
                                break;

                            case 2:
                            System.out.println("Ver lista de entrenadores ");
                                break;
                            case 3: 
                            System.out.println("Selecciona un entrenador");
                                break;
                            case 4:
                            System.out.println("Volviendo al menu principal");
                            opcion2 = 4;
                                break;
                            default:
                            System.out.println("Opcion invalida, intentalo de nuevo porfavor");
                        }
                    }
                    break;

                case 2:

                
                    break;

                case 3:

                    break;

                case 4:
                System.out.println("Saliendo del programa");  
                salir = 4;      
                     break;

                default:
                    System.out.println("Opcion invalida, intentalo de nuevo porfavor");
            }
        }



    }
}
