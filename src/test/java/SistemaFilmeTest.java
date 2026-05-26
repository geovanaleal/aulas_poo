import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SistemaFilmeTest {

    @Test
    public void testaCadastroFilme() {

        SistemaFilme sistema = new SistemaFilme();

        Filme filme =
                new Filme("Titanic", "Drama", 1997, 9.0);

        sistema.cadastrarFilme(filme);

        assertEquals(
                filme,
                sistema.pesquisarFilme("Titanic")
        );
    }

    @Test
    public void testaRemocaoFilme() {

        SistemaFilme sistema = new SistemaFilme();

        Filme filme =
                new Filme("Avatar", "Ficção", 2009, 8.5);

        sistema.cadastrarFilme(filme);

        assertTrue(
                sistema.removerFilme("Avatar")
        );
    }
}