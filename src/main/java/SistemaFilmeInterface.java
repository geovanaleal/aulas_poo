import java.io.IOException;
import java.util.Collection;

public interface SistemaFilmeInterface {

    /**
     * Cadastra um filme no sistema.
     * @param filme Filme a ser cadastrado
     * @return true se cadastrou com sucesso
     */
    public boolean cadastrarFilme(Filme filme);

    /**
     * Pesquisa um filme pelo título.
     * @param titulo Título do filme
     * @return Filme encontrado
     */
    public Filme pesquisarFilme(String titulo);

    /**
     * Remove um filme do sistema.
     * @param titulo Título do filme
     * @return true se removeu
     */
    public boolean removerFilme(String titulo);

    /**
     * Lista todos os filmes cadastrados.
     * @return coleção de filmes
     */
    public Collection<Filme> listarFilmes();

    /**
     * Salva os dados em arquivo.
     * @throws IOException erro de gravação
     */
    public void salvarDados() throws IOException;

    /**
     * Recupera os dados do arquivo.
     * @throws IOException erro de leitura
     */
    public void recuperarDados() throws IOException;
}
