import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;

public class SistemaFilme implements SistemaFilmeInterface {

    private HashMap<String, Filme> filmeHashMap;

    public SistemaFilme() {
        filmeHashMap = new HashMap<>();
    }

    @Override
    public boolean cadastrarFilme(Filme filme) {
        filmeHashMap.put(filme.getTitulo(), filme);
        return true;
    }

    @Override
    public Filme pesquisarFilme(String titulo) {
        return filmeHashMap.get(titulo);
    }

    @Override
    public void alterarNota(double nota, String titulo) {
        Filme filme = filmeHashMap.get(titulo);
        if (filme != null) {
            filme.setNota(nota);
        }
    }

    @Override
    public Collection<Filme> listarFilmes() {
        return filmeHashMap.values();
    }

    @Override
    public boolean removerFilme(String titulo) {
        return filmeHashMap.remove(titulo) != null;
    }

    public HashMap<String, Filme> getFilmes() {
        return filmeHashMap;
    }

    @Override
    public void salvarDados() throws IOException {
        GravadorDeDados gravador = new GravadorDeDados();
        gravador.salvarDados(filmeHashMap);
    }

    @Override
    public void recuperarDados() throws IOException {
        GravadorDeDados gravador = new GravadorDeDados();
        try {
            filmeHashMap = gravador.recuperarDados();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}