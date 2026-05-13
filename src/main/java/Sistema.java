import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaFilme sistema = new SistemaFilme();

        System.out.println("=== CADASTRO DE FILMES ===");

        // Quantidade de filmes
        System.out.print("Quantos filmes deseja cadastrar? ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        // Cadastro
        for (int i = 1; i <= quantidade; i++) {

            System.out.println("\nFilme " + i);

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Gênero: ");
            String genero = scanner.nextLine();

            System.out.print("Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());

            System.out.print("Nota: ");
            double nota = Double.parseDouble(scanner.nextLine());

            Filme filme = new Filme(titulo, genero, ano, nota);

            sistema.cadastrarFilme(filme);

            System.out.println("Filme cadastrado com sucesso!");
        }

        // Listar filmes
        System.out.println("\n=== LISTA DE FILMES ===");
        sistema.listarFilmes();

        // Buscar filme
        System.out.print("\nDigite o título do filme que deseja buscar: ");
        String tituloBusca = scanner.nextLine();

        Filme filmeEncontrado = sistema.pesquisarFilme(tituloBusca);

        if (filmeEncontrado != null) {

            System.out.println("\nFilme encontrado:");
            System.out.println(filmeEncontrado);

            // Alterar nota
            System.out.print("\nDigite a nova nota: ");
            double novaNota = Double.parseDouble(scanner.nextLine());

            sistema.alterarNota(novaNota, tituloBusca);

            System.out.println("\nNota alterada com sucesso!");
            System.out.println(sistema.pesquisarFilme(tituloBusca));

        } else {

            System.out.println("Filme não encontrado.");
        }

        scanner.close();
    }
}