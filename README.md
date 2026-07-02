# aulas_poo

# Sistema de Cadastro de Filmes

Este é um sistema desenvolvido em Java para gerenciar o cadastro de filmes. O sistema permite o cadastro, listagem, pesquisa, alteração de notas e remoção de filmes, utilizando o título como identificador.

## Funcionalidades
- **Cadastrar**: Adiciona um novo filme ao sistema.
- **Pesquisar**: Busca os dados de um filme pelo seu título.
- **Alterar Nota**: Permite atualizar a nota de avaliação de um filme existente.
- **Apagar**: Remove um filme do sistema.
- **Salvar/Recuperar**: Persistência de dados em arquivo.

## Estrutura Técnica
- **Interface e Implementação**: Uso de `HashMap` para armazenamento em memória.
- **Persistência**: Feita através de `ObjectInputStream` e `ObjectOutputStream` na classe `GravadorDeDados`.
- **Interface Gráfica (GUI)**: Construída com `JFrame` (Swing).
- **Testes**: Testes unitários com JUnit para garantir o funcionamento das operações principais.