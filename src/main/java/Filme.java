public class Filme {

    private String titulo;
    private String genero;
    private int ano;
    private double nota;

    // Construtor
    public Filme(String titulo, String genero, int ano, double nota) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.nota = nota;
    }

    // Gets e Sets
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // toString
    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", ano=" + ano +
                ", nota=" + nota +
                '}';
    }
}