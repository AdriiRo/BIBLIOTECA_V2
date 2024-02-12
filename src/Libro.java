public class Libro {

    private String titulo; 
    private String autor; 
    private int anoPublicacion;
    private int codigoISBN;
    private int numEjemplares;
    
    public Libro(String titulo, String autor, int anoPublicacion, int codigoISBN, int numEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.codigoISBN = codigoISBN;
        this.numEjemplares = numEjemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(int codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {

        if (numEjemplares>=0) {
            this.numEjemplares = numEjemplares;
        } else {
            System.out.println("ERROR. No puede haber una cantidad negativa de libros");
        }

    }

    @Override
    public String toString() {
        return "Título:"  + titulo + "  |  Autor:"  + autor + "  |  ISBN:" + codigoISBN + "  | Ejemplares disponibles: " + numEjemplares;
    }

    

    

    
}
