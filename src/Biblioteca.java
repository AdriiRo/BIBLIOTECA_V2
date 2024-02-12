import java.util.InputMismatchException;

public class Biblioteca {
    
    // Constantes (Mensajes de salida del programa)

    public static final String MSG_RESULT_BUSQ = "Resultado de la búsqueda: \n";
    public static final String MSG_ISBN_CHECK_EJEMPLARES = "Introduce el ISBN del libro del que quieres consultar los ejemplares disponibles: ";
    public static final String MSG_ERROR_BUSQUEDA = "Error durante la búsqueda";
    public static final String MSG_ISBN_NOT_FOUND = "No se ha encontrado ningún libro registrado con ese ISBN";
    public static final String MSG_EJEMPLARES_MODIF_SUCESS = "Ejemplares modificados correctamente. Ejemplares actuales: ";
    public static final String MSG_CAMBIO_NUM_EJEMPLARES = "Introduce el nuevo número de ejemplares: ";
    public static final String MSG_MODIF_ISBN = "Introduce el ISBN del libro del cual desea modificar los ejemplares: ";
    public static final String MSG_ERROR_BUSQ_ISBN = "No se ha encontrado ningún libro registrado para el ISBN introducido.";
    public static final String MSG_ERROR_BUSQ_TITULO = "No se ha encontrado ningún libro registrado con el título introducido.";
    public static final String MSG_BUSQ_TITULO = "Introduce el titulo que deseas buscar: ";
    public static final String MSG_BUSQ_NOT_FOUND = "No se ha encontrado ningún libro registrado para el autor de tu búsqueda.";
    public static final String MSG_ERROR_GENERAL_BUSQ = "Se ha producido un error durante la búsqueda. Reintentando búsqueda...";
    public static final String ERROR_TIPO_DATO = "Introduce un dato válido.";
    public static final String MSG_BUSQUEDA_TITULO = "Introduce el título que deseas buscar: ";
    public static final String MSG_BUSQUEDA_ISBN = "Introduce el ISBN que deseas buscar: ";
    public static final String MSG_BUSQUEDA_AUTOR = "Introduce el autor que deseas buscar: ";
    public static final String MSG_REGISTRO_FAIL = "Fallo durante el registro del libro";
    public static final String MSG_LIBRO_SUCESS = "Libro añadido exitosamente";
    public static final String MSG_INPUT_NUM_EJEMPL = "Introduce el número de ejemplares del libro: ";
    public static final String MSG_INPUT_ISBN = "Introduce el ISBN del libro: ";
    public static final String MSG_INPUT_ANO_PUBLI = "Introduce el año de publicación del libro: ";
    public static final String MSG_INPUT_AUTOR = "Introduce el autor del libro: ";
    public static final String MSG_INPUT_TITULO = "Introduce el titulo del libro: ";

    int contadorLibros = 0;

    private String nombre;
    private String direccion;
    private Libro[] libros;

    // Constructor

    public Biblioteca(String nombre, String direccion, Libro[] libros) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.libros = libros;
    }

    // Métodos de acceso

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    // Comportamiento

    public Libro registrarLibro() { // Este método recoge los datos que introduce el usuario por teclado y los
                                    // devuelve en un objeto de tipo Libro

        System.out.println(MSG_INPUT_TITULO);
        String titulo = EntradaDatos.leerString();
        System.out.println(MSG_INPUT_AUTOR);
        String autor = EntradaDatos.leerString();
        System.out.println(MSG_INPUT_ANO_PUBLI);
        int anoPublicacion = EntradaDatos.leerEntero();
        System.out.println(MSG_INPUT_ISBN);
        int codigoISBN = EntradaDatos.leerEntero();
        System.out.println(MSG_INPUT_NUM_EJEMPL);
        int numEjemplares = EntradaDatos.leerEntero();

        Libro libro = new Libro(titulo, autor, anoPublicacion, codigoISBN, numEjemplares);

        return libro;

    }

    public void anadirLibro() { // Llama al método que interactúa con el usuario y añade el libro al array
                                // asociado a la biblioteca

        Libro tempLibro = registrarLibro();

        libros[contadorLibros] = tempLibro;

        if (libros[contadorLibros] != null) {
            System.out.println(MSG_LIBRO_SUCESS);
            contadorLibros++;
        } else {
            System.out.println(MSG_REGISTRO_FAIL);
            do {
                registrarLibro();
            } while (libros[contadorLibros] != null);
        }

    }

    public void anadirLibro(Libro[] libros, Libro l) { // Permite añadir a una biblioteca un libro precargado
                                                                 // en memoria (instanciado en el Main)

        libros[contadorLibros] = l;
        contadorLibros++;

    }

    public void buscarLibroPorAutor() {
        try {
            System.out.println(MSG_BUSQUEDA_AUTOR);
            String inputAutor = EntradaDatos.leerString();
            boolean encontrado = false; // Variable para controlar si se encuentra el libro

            for (int i = 0; i < libros.length; i++) {
                if (inputAutor.equalsIgnoreCase(libros[i].getAutor())) {
                    System.out.println(MSG_RESULT_BUSQ);
                    System.out.println("Título: " + libros[i].getTitulo() + " | Autor: " + libros[i].getAutor());
                    encontrado = true; // Indica que se encontró el libro
                    break;
                }
            }

            if (!encontrado) { // Si no se encontró ningún libro, mostrar mensaje de error
                System.out.println(MSG_BUSQ_NOT_FOUND);
            }

        } catch (InputMismatchException e) {
            System.out.println(ERROR_TIPO_DATO);
            buscarLibroPorAutor();
        } catch (NullPointerException e) {
            System.out.println(MSG_BUSQ_NOT_FOUND);
        } catch (Exception e) {
            System.out.println(MSG_ERROR_GENERAL_BUSQ);
            buscarLibroPorAutor();
        }
    }

    public void buscarLibroPorTitulo() {
        try {
            System.out.println(MSG_BUSQ_TITULO);
            String inputTitulo = EntradaDatos.leerString();
            boolean encontrado = false; // Variable para controlar si se encuentra el libro

            for (int i = 0; i < libros.length; i++) {
                if (inputTitulo.equalsIgnoreCase(libros[i].getTitulo())) {
                    System.out.println(MSG_RESULT_BUSQ);
                    System.out.println("Título: " + libros[i].getTitulo() + " | Autor: " + libros[i].getAutor());
                    encontrado = true; // Indica que se encontró el libro
                    break;
                }
            }

            if (!encontrado) { // Si no se encontró ningún libro, mostrar mensaje de error
                System.out.println(MSG_ERROR_BUSQ_TITULO);
            }

        } catch (InputMismatchException e) {
            System.out.println(ERROR_TIPO_DATO);
            buscarLibroPorAutor();
        } catch (NullPointerException e) {
            System.out.println(" ");
        } catch (Exception e) {
            System.out.println(MSG_ERROR_GENERAL_BUSQ);
            buscarLibroPorAutor();
        }
    }

    public void buscarLibroPorISBN() {
        try {
            System.out.println(MSG_BUSQUEDA_ISBN);
            int inputISBN = EntradaDatos.leerEntero();
            boolean encontrado = false; // Variable para controlar si se encuentra el libro

            for (int i = 0; i < libros.length; i++) {
                if (inputISBN == libros[i].getCodigoISBN()) {
                    System.out.println(MSG_RESULT_BUSQ);
                    System.out.println("Título: " + libros[i].getTitulo() + " | Autor: " + libros[i].getAutor());
                    encontrado = true; // Indica que se encontró el libro
                    break;
                }
            }

            if (!encontrado) { // Si no se encontró ningún libro, mostrar mensaje de error
                System.out.println(MSG_ERROR_BUSQ_ISBN);
            }

        } catch (InputMismatchException e) { // Cobertura de excepciones a posibles errores
            System.out.println(ERROR_TIPO_DATO);
            buscarLibroPorAutor();
        } catch (NullPointerException e) {
            System.out.println(MSG_ISBN_NOT_FOUND);
        } catch (Exception e) {
            System.out.println(MSG_ERROR_GENERAL_BUSQ);
            buscarLibroPorAutor();
        }
    }

    public void modificarEjemplares() {
        try {
            System.out.println(MSG_MODIF_ISBN);
            int inputISBN = EntradaDatos.leerEntero();
            boolean libroExiste = false;

            for (int i = 0; i < libros.length; i++) {
                if (inputISBN == libros[i].getCodigoISBN()) {
                    libroExiste = true;
                    System.out.println(MSG_CAMBIO_NUM_EJEMPLARES);
                    int newNumEjemplares = EntradaDatos.leerEntero();
                    libros[i].setNumEjemplares(newNumEjemplares);
                    if (libros[i].getNumEjemplares() == newNumEjemplares) {
                        System.out.println(MSG_EJEMPLARES_MODIF_SUCESS + libros[i].getNumEjemplares());
                    } else {
                        System.out.println(MSG_ISBN_NOT_FOUND);
                    }
                    break; // Importante: salimos del bucle una vez que encontramos el libro
                }
            }

            if (!libroExiste) {
                System.out.println(MSG_ISBN_NOT_FOUND);
            }

        } catch (NullPointerException e) {
            System.out.println(MSG_ISBN_NOT_FOUND);
        } catch (InputMismatchException e) {
            System.out.println(ERROR_TIPO_DATO);
            modificarEjemplares();
        } catch (Exception e) {
            System.out.println(MSG_ERROR_BUSQUEDA);
            modificarEjemplares();
        }
    }

    public void consultarEjemplares() {

        try {

            System.out.println("Esta biblioteca cuenta con " + contadorLibros + " libros actualmente");

            // El siguiente fragmento de código invalida la consulta de ejemplares mediante ISBN

            System.out.println("Libros de " + nombre + " :  \n");
            
            for (int i = 0; i < libros.length; i++) {
                if (libros[i] == null) {    // Evita mostrar el error al capturar la excepción (no corresponde el mensaje de error mostrado por la excepción, con el error que se pretende evitar en este caso).
                    break;
                } else {
                    System.out.println(" · " + libros[i].toString());
                }
            }

        } catch (NullPointerException e) { // Cobertura de excepciones a posibles errores
            System.out.println(MSG_ERROR_BUSQ_ISBN);
        } catch (InputMismatchException e) {
            System.out.println(ERROR_TIPO_DATO);
            consultarEjemplares();
        } catch (Exception e) {
            System.out.println(MSG_ERROR_BUSQUEDA);
            consultarEjemplares();
        }

    }

    public void sacarLibro() {

        System.out.println("Introduce el ISBN del libro a retirar: ");
        int inputISBN = EntradaDatos.leerEntero();

        try {
            for (int i = 0; i < libros.length; i++) {
                if (inputISBN == libros[i].getCodigoISBN()) {
                    System.out.println("Libro encontrado. Gestionando préstamo...");
                    libros[i].setNumEjemplares(libros[i].getNumEjemplares() - 1);
                    System.out.println("Libro prestado correctamente. Actualmente restan "
                            + libros[i].getNumEjemplares() + " ejemplares.");
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(MSG_ERROR_BUSQ_ISBN);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            sacarLibro();
        }

    }

    public void devolverLibro() {

        System.out.println("Introduce el ISBN del libro a devolver: ");
        int inputISBN = EntradaDatos.leerEntero();

        try {
            for (int i = 0; i < libros.length; i++) {
                if (inputISBN == libros[i].getCodigoISBN()) {
                    System.out.println("Libro encontrado. Gestionando devolución...");
                    libros[i].setNumEjemplares(libros[i].getNumEjemplares() + 1);
                    System.out.println("Libro devuelto correctamente. Actualmente restan "
                            + libros[i].getNumEjemplares() + " ejemplares.");
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(MSG_ISBN_NOT_FOUND);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            devolverLibro();
        }

    }

    public void eliminarLibro() {

        System.out.println("Introduce el ISBN del libro a eliminar: ");
        int inputISBN = EntradaDatos.leerEntero();

        try {
            for (int i = 0; i < libros.length; i++) {
                if (inputISBN == libros[i].getCodigoISBN()) {
                    System.out.println("Libro encontrado. Gestionando borrado...");
                    libros[i] = null;
                    System.out.println("Libro borrado correctamente.");
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(MSG_ISBN_NOT_FOUND);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            eliminarLibro();
        }

    }
}
