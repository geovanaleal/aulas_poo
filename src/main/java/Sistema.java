import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaFilme sistema = new SistemaFilme();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=== SISTEMA DE FILMES ===");
            System.out.println("1 - Cadastrar filme");
            System.out.println("2 - Listar filmes");
            System.out.println("3 - Pesquisar filme");
            System.out.println("4 - Alterar nota");
            System.out.println("5 - Remover filme");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:

                    System.out.println("\n=== CADASTRO DE FILME ===");

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nota: ");
                    double nota = Double.parseDouble(scanner.nextLine());

                    Filme filme =
                            new Filme(titulo, genero, ano, nota);

                    sistema.cadastrarFilme(filme);

                    System.out.println("Filme cadastrado!");
                    break;

                case 2:

                    System.out.println("\n=== LISTA DE FILMES ===");

                    for (Filme f : sistema.listarFilmes()) {
                        System.out.println(f);
                    }

                    break;

                case 3:

                    System.out.print("\nDigite o título: ");

                    String busca = scanner.nextLine();

                    Filme encontrado =
                            sistema.pesquisarFilme(busca);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Filme não encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("\nTítulo do filme: ");
                    String tituloNota = scanner.nextLine();

                    System.out.print("Nova nota: ");
                    double novaNota =
                            Double.parseDouble(scanner.nextLine());

                    sistema.alterarNota(novaNota, tituloNota);

                    System.out.println("Nota alterada!");
                    break;

                case 5:

                    System.out.print("\nTítulo do filme: ");

                    String tituloRemover =
                            scanner.nextLine();

                    if (sistema.removerFilme(tituloRemover)) {

                        System.out.println("Filme removido!");

                    } else {

                        System.out.println("Filme não encontrado.");
                    }

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}