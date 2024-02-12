public class Main {

    private static final String OPCIÓN_EN_DESARROLLO = "Opción aún en desarrollo...";
    private static final String MSG_OUTPUT_LIBROS = "Libros registrados actualmente en ";
    private static final String MSG_SELECTOR_BUSQ = "Seleccione una búsqueda: \n [1]. Por autor \n [2]. Por titulo \n [3]. Por ISBN";
    public static final String BIBIOTECA_AÚN_NO_DISPONIBLE = "Bibioteca aún no disponible...";
    public static String MSG_SELEC_BIBLIOTECA = "Seleccione una biblioteca: \n";
    public static String REF_BIBLIOTECA_1 = "[1]. Biblioteca 1 \n";
    public static String REF_BIBLIOTECA_2 = "[2]. Biblioteca 2 \n";

    public static String MSG_SELEC_OPC = "Selecciona una de las opciones a continuación: \n";
    public static String OPCION_1 = "[1]. Sacar un libro \n";
    public static String OPCION_2 = "[2]. Devolver un libro \n";
    public static String OPCION_3 = "[3]. Introducir un nuevo libro \n";
    public static String OPCION_4 = "[4]. Eliminar libro \n";
    public static String OPCION_5 = "[5]. Consultar número de libros y ejemplares \n";
    public static String OPCION_6 = "[6]. Modificar número de ejemplares \n";
    public static String OPCION_7 = "[7]. Realizar una búsqueda \n";

    public static String SEPARADOR = "----------------------------------- \n";

    public static void main(String[] args) throws Exception {

        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 978030, 2);
        Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, 978031, 3);
        Libro libro3 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 978032, 9788478, 4);
        Libro libro4 = new Libro("1984", "George Orwell", 1949, 978033, 2);
        Libro libro5 = new Libro("El código Da Vinci", "Dan Brown", 2003, 978034, 5);
        Libro libro6 = new Libro("Orgullo y prejuicio", "Jane Austen", 1813, 978035, 1);

        Libro testing = new Libro("aa", "bb", 2024, 123456, 2);

        Libro[] librosBiblioteca1 = new Libro[10];
        Libro[] librosBiblioteca2 = new Libro[10];

        Biblioteca biblioteca1 = new Biblioteca("Biblioteca 1", "Dirección 1", librosBiblioteca1);
        Biblioteca biblioteca2 = new Biblioteca("Biblioteca 2", "Dirección 2", librosBiblioteca2);

        // Precargado de la biblioteca 1
        biblioteca1.anadirLibro(librosBiblioteca1, libro1);
        biblioteca1.anadirLibro(librosBiblioteca1, libro2);
        biblioteca1.anadirLibro(librosBiblioteca1, libro3);

        // Precargado de la biblioteca 2
        biblioteca2.anadirLibro(librosBiblioteca2, libro4);
        biblioteca2.anadirLibro(librosBiblioteca2, libro5);
        biblioteca2.anadirLibro(librosBiblioteca2, libro6);
        // La línea de abajo era un simple test para verificar que cada biblioteca tiene
        // su propio contador, para ello el contador NO debe de ser estático.

        // biblioteca2.anadirLibroPrecargado(librosBiblioteca2, testing);
        // Al hacer esto, el contador de la biblioteca 1 valdrá 3, mientras que el de la
        // 2, valdrá 4.

        System.out.println(
                MSG_OUTPUT_LIBROS + biblioteca1.getNombre() + " : " + biblioteca1.contadorLibros);
        System.out.println(
                MSG_OUTPUT_LIBROS + biblioteca2.getNombre() + " : " + biblioteca2.contadorLibros);

        int selectorBiblioteca = 0;
        System.out.println(MSG_SELEC_BIBLIOTECA + REF_BIBLIOTECA_1 + REF_BIBLIOTECA_2);
        selectorBiblioteca = EntradaDatos.leerEntero();

        switch (selectorBiblioteca) {      // Antes tenía dos métodos diferentes, pero como realmente funciona por parametro, puedo eliminar uno, ya que el determinante para la ejecución de una biblioteca u otra, es el parámetro que recibe el método
            case 1:
                ejecutarBiblioteca(biblioteca1);    
                break;
            case 2:
                ejecutarBiblioteca(biblioteca2);
            default:
                System.out.println(BIBIOTECA_AÚN_NO_DISPONIBLE);
                break;
        }

    }

    public static void ejecutarBiblioteca(Biblioteca b) {

        int selectorOption = 0;

        do {
            System.out.println(SEPARADOR + "Bienvenido a " + b.getNombre() + " , " + b.getDireccion());
            System.out.println(
                    MSG_SELEC_OPC + OPCION_1 + OPCION_2 + OPCION_3 + OPCION_4 + OPCION_5 + OPCION_6 + OPCION_7);
            selectorOption = EntradaDatos.leerEntero();
            switch (selectorOption) {
                case 1:
                    b.sacarLibro();
                    break;
                case 2:
                    b.devolverLibro();
                    break;
                case 3:
                    b.anadirLibro();
                    break;
                case 4:
                    b.eliminarLibro();
                    break;
                case 5:
                    b.consultarEjemplares();
                    break;
                case 6:
                    b.modificarEjemplares();
                    break;
                case 7:
                    System.out
                            .println(MSG_SELECTOR_BUSQ);
                    int selectorTipoBusqueda = EntradaDatos.leerEntero();

                    switch (selectorTipoBusqueda) {
                        case 1:
                            b.buscarLibroPorAutor();
                            break;
                        case 2:
                            b.buscarLibroPorTitulo();
                            break;
                        case 3:
                            b.buscarLibroPorISBN();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    System.out.println(OPCIÓN_EN_DESARROLLO);
                    break;
            }
        } while (selectorOption != 0);

    }

}
