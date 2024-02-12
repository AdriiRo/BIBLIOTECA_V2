import java.util.Scanner;

public class EntradaDatos { // Es una clase que nos permite gestionar la entrada de datos en nuestro programa


    public static String leerString() {
        String input = "";
        Scanner sc = new Scanner (System.in);
        input = sc.nextLine(); 
        return input;
    }

    public static int leerEntero() {    // SI SE CIERRAN LOS SCANNERS DA ERROR, SIN CERRARLOS FUNCIONA BIEN
        int input = 0;
        Scanner sc = new Scanner (System.in);
        input = sc.nextInt(); 
        return input;
    }

    public static double leerDouble() {
        double input = 0;
        Scanner sc = new Scanner (System.in);
        input = sc.nextDouble(); 
        return input;
    }

    public static long leerLong() {
        long input = 0; 
        Scanner sc = new Scanner(System.in); 
        input = sc.nextLong();
        return input; 
    }


}
