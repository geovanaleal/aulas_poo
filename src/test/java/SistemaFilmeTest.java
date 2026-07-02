import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaFilmeTest {

    private SistemaFilme sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaFilme();
    }

    @Test
    public void testCadastrarEPesquisarFilme() {
        Filme filme = new Filme("Matrix", "Ficção", 1999, 9.5);
        sistema.cadastrarFilme(filme);

        Filme encontrado = sistema.pesquisarFilme("Matrix");
        assertNotNull(encontrado);
        assertEquals(1999, encontrado.getAno());
        assertEquals("Ficção", encontrado.getGenero());
    }

    @Test
    public void testRemoverFilme() {
        Filme filme = new Filme("O Senhor dos Anéis", "Fantasia", 2001, 10.0);
        sistema.cadastrarFilme(filme);

        boolean removido = sistema.removerFilme("O Senhor dos Anéis");
        assertTrue(removido);

        Filme encontrado = sistema.pesquisarFilme("O Senhor dos Anéis");
        assertNull(encontrado);
    }
}