import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TelaPrincipal extends JFrame {

    private SistemaFilmeInterface sistema;

    public TelaPrincipal() {
        sistema = new SistemaFilme();

        try {
            sistema.recuperarDados();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Nenhum dado anterior encontrado ou erro ao ler.");
        }

        setTitle("Sistema de Filmes");
        setSize(750, 550); // Aumentei um pouco a altura para caber o 4º botão confortavelmente
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Arquivo");
        JMenuItem itemSalvar = new JMenuItem("Salvar Dados");
        itemSalvar.addActionListener(new SalvarController());
        menuOpcoes.add(itemSalvar);
        menuBar.add(menuOpcoes);
        setJMenuBar(menuBar);

        setLayout(new GridLayout(1, 2));

        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setBackground(new Color(20, 140, 70));
        painelEsquerdo.setLayout(new GridBagLayout());

        JLabel labelTitulo = new JLabel("Sistema de Filmes");
        labelTitulo.setFont(new Font("Serif", Font.BOLD, 28));
        labelTitulo.setForeground(Color.BLACK);
        painelEsquerdo.add(labelTitulo);

        JPanel painelDireito = new JPanel();
        painelDireito.setBackground(new Color(200, 230, 200));
        painelDireito.setLayout(new GridLayout(4, 1, 0, 15));
        painelDireito.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnRemover = new JButton("Remover");
        JButton btnListar = new JButton("Listar");

        Font fonteBotoes = new Font("SansSerif", Font.BOLD, 16);
        btnAdicionar.setFont(fonteBotoes);
        btnPesquisar.setFont(fonteBotoes);
        btnRemover.setFont(fonteBotoes);
        btnListar.setFont(fonteBotoes);

        btnAdicionar.addActionListener(new CadastrarController());
        btnPesquisar.addActionListener(new PesquisarController());
        btnRemover.addActionListener(new ApagarController());
        btnListar.addActionListener(new ListarController()); // Ação de listar

        painelDireito.add(btnAdicionar);
        painelDireito.add(btnPesquisar);
        painelDireito.add(btnRemover);
        painelDireito.add(btnListar);

        add(painelEsquerdo);
        add(painelDireito);

        setVisible(true);
    }

    private class CadastrarController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String titulo = JOptionPane.showInputDialog("Título:");
            if (titulo != null && !titulo.isEmpty()) {
                String genero = JOptionPane.showInputDialog("Gênero:");
                String anoStr = JOptionPane.showInputDialog("Ano:");
                String notaStr = JOptionPane.showInputDialog("Nota:");
                try {
                    sistema.cadastrarFilme(new Filme(titulo, genero, Integer.parseInt(anoStr), Double.parseDouble(notaStr)));
                    JOptionPane.showMessageDialog(null, "Cadastrado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro nos dados.");
                }
            }
        }
    }

    private class ListarController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder lista = new StringBuilder("=== FILMES ===\n");
            for (Filme f : sistema.listarFilmes()) {
                lista.append(f.getTitulo()).append(" - ").append(f.getNota()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sistema.listarFilmes().isEmpty() ? "Vazio." : lista.toString());
        }
    }

    private class PesquisarController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String t = JOptionPane.showInputDialog("Pesquisar título:");
            Filme f = sistema.pesquisarFilme(t);
            JOptionPane.showMessageDialog(null, f != null ? f.toString() : "Não encontrado.");
        }
    }

    private class ApagarController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String t = JOptionPane.showInputDialog("Título para apagar:");
            JOptionPane.showMessageDialog(null, sistema.removerFilme(t) ? "Apagado." : "Não encontrado.");
        }
    }

    private class SalvarController implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                sistema.salvarDados();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal());
    }
}