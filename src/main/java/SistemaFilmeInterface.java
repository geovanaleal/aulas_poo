import java.io.IOException;
import java.util.Collection;

public interface SistemaFilmeInterface {

    /**
     * Cadastra um filme no sistema.
     * @param filme Filme a ser cadastrado
     * @return true se cadastrou com sucesso
     */
    boolean cadastrarFilme(Filme filme);

    /**
     * Pesquisa um filme pelo título.
     * @param titulo Título do filme
     * @return Filme encontrado
     */
    Filme pesquisarFilme(String titulo);

    /**
     * Altera a nota de um filme existente.
     * @param nota Nova nota do filme
     * @param titulo Título do filme
     */
    void alterarNota(double nota, String titulo);

    /**
     * Remove um filme do sistema.
     * @param titulo Título do filme
     * @return true se removeu
     */
    boolean removerFilme(String titulo);

    /**
     * Lista todos os filmes cadastrados.
     * @return coleção de filmes
     */
    Collection<Filme> listarFilmes();

    /**
     * Salva os dados em arquivo.
     * @throws IOException erro de gravação
     */
    void salvarDados() throws IOException;

    /**
     * Recupera os dados do arquivo.
     * @throws IOException erro de leitura
     */
    void recuperarDados() throws IOException;
}