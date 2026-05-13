import java.util.HashMap;

public class SistemaFilme {

    private HashMap<String, Filme> filmeHashMap;

    // Construtor
    public SistemaFilme() {
        filmeHashMap = new HashMap<>();
    }

    // Cadastrar filme
    public void cadastrarFilme(Filme filme) {
        filmeHashMap.put(filme.getTitulo(), filme);
    }

    // Pesquisar filme
    public Filme pesquisarFilme(String titulo) {
        return filmeHashMap.get(titulo);
    }

    // Alterar nota
    public void alterarNota(double nota, String titulo) {

        Filme filme = filmeHashMap.get(titulo);

        if (filme != null) {
            filme.setNota(nota);
        }
    }

    // Listar filmes
    public void listarFilmes() {

        for (Filme filme : filmeHashMap.values()) {
            System.out.println(filme);
        }
    }
}
