package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

import command.*; // Padrão Command: comandos são encapsulados em classes específicas
import factory.Produto;
import model.CarrinhoDeCompras;
import observer.Cliente;
import observer.Loja;

public class LojaGUI extends JFrame {
    private CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    private JTextArea areaCarrinho;
    private JLabel statusLabel;
    private CommandInvoker invoker;

    public LojaGUI() {
        // Padrão Command: invoker é responsável por registrar e executar comandos
        invoker = new CommandInvoker();
        FlatDarkLaf.setup(); // Configuração de tema escuro para GUI

        // Padrão Observer: a loja possui clientes que serão notificados
        Loja loja = new Loja();
        loja.adicionarCliente(new Cliente("João"));
        loja.adicionarCliente(new Cliente("Maria"));

        // Command: comando encapsula a notificação dos clientes
        invoker.registrarComando("notificar", new ComandoNotificarClientes(this, loja));

        setTitle("Loja Virtual");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de exibição do carrinho
        areaCarrinho = new JTextArea();
        areaCarrinho.setEditable(false);
        areaCarrinho.setBorder(BorderFactory.createTitledBorder("Carrinho de Compras"));
        add(new JScrollPane(areaCarrinho), BorderLayout.CENTER);

        // Painel lateral com os botões de ação
        JPanel painel = new JPanel(new GridLayout(0, 1, 10, 10));
        painel.setBackground(new Color(240, 240, 255));

        // Criação dos botões
        JButton btnAdicionar = criarBotao("Adicionar Produto");
        JButton btnVer = criarBotao("Ver Carrinho");
        JButton btnFinalizar = criarBotao("Finalizar Compra");
        JButton btnSalvar = criarBotao("Salvar Carrinho");
        JButton btnCarregar = criarBotao("Carregar Carrinho");
        JButton btnNotificar = criarBotao("Notificar Clientes");
        JButton btnRemover = criarBotao("Remover Produto");
        JButton btnLimpar = criarBotao("Limpar Carrinho");
        JButton btnSair = criarBotao("Sair");

        // Adiciona botões ao painel
        painel.add(btnAdicionar);
        painel.add(btnVer);
        painel.add(btnFinalizar);
        painel.add(btnSalvar);
        painel.add(btnCarregar);
        painel.add(btnNotificar);
        painel.add(btnRemover);
        painel.add(btnLimpar);
        painel.add(btnSair);
        add(painel, BorderLayout.EAST);

        // Label de status inferior
        statusLabel = new JLabel("Status: Aguardando ação...");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(statusLabel, BorderLayout.SOUTH);

        // Registro de comandos usando Command Pattern
        invoker.registrarComando("adicionar", new ComandoAdicionarProduto(this, carrinho));
        invoker.registrarComando("ver", new ComandoVerCarrinho(this, carrinho));
        invoker.registrarComando("finalizar", new ComandoAplicarDesconto(this, carrinho)); // Strategy usado aqui
        invoker.registrarComando("salvar", new ComandoSalvarCarrinho(this, carrinho));
        invoker.registrarComando("carregar", new ComandoCarregarCarrinho(this, carrinho));
        invoker.registrarComando("remover", new ComandoRemoverProduto(this, carrinho));
        invoker.registrarComando("limpar", new ComandoLimparCarrinho(this, carrinho));
        invoker.registrarComando("sair", new ComandoSair(this));
        invoker.registrarComando("criarProduto", new ComandoCriarProduto());

        // Mapeamento dos botões para execução dos comandos registrados
        btnAdicionar.addActionListener(e -> invoker.executar("adicionar"));
        btnVer.addActionListener(e -> invoker.executar("ver"));
        btnFinalizar.addActionListener(e -> invoker.executar("finalizar"));
        btnSalvar.addActionListener(e -> invoker.executar("salvar"));
        btnCarregar.addActionListener(e -> invoker.executar("carregar"));
        btnNotificar.addActionListener(e -> invoker.executar("notificar")); // Observer é disparado aqui
        btnRemover.addActionListener(e -> invoker.executar("remover"));
        btnLimpar.addActionListener(e -> invoker.executar("limpar"));
        btnSair.addActionListener(e -> invoker.executar("sair"));

        setVisible(true);
    }

    // Criação padronizada de botões
    public JButton criarBotao(String texto) {
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        return btn;
    }

    // Atualiza o conteúdo do carrinho na interface
    public void atualizarCarrinho(List<Produto> produtos) {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append(produto.getTipo())
              .append(" - ").append(produto.getNome())
              .append(" - R$").append(produto.getPrecoBase())
              .append("\n");
        }
        areaCarrinho.setText(sb.toString());
        destacarCarrinho();
    }

    // Destaque visual temporário para sinalizar atualização do carrinho
    public void destacarCarrinho() {
        Color original = areaCarrinho.getBackground();
        areaCarrinho.setBackground(Color.GREEN);
        new javax.swing.Timer(500, e -> areaCarrinho.setBackground(original)).start();
    }

    // Atualiza a mensagem de status na parte inferior da tela
    public void atualizarStatus(String mensagem) {
        statusLabel.setText("Status: " + mensagem);
        statusLabel.setForeground(Color.CYAN);
        new javax.swing.Timer(1500, e -> statusLabel.setForeground(Color.WHITE)).start();
    }

    public String getTextoCarrinho() {
        return areaCarrinho.getText();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("Erro ao aplicar tema: " + e.getMessage());
        }

        // Inicia a GUI da aplicação
        SwingUtilities.invokeLater(() -> {
            new LojaGUI();
        });
    }
}