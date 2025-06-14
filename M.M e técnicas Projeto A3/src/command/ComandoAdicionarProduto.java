// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de adicionar um produto criado ao carrinho.

import factory.Produto;
import factory.ProdutoFactory;
import gui.LojaGUI;
import model.CarrinhoDeCompras;

import javax.swing.*;
import java.awt.*;

public class ComandoAdicionarProduto implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoAdicionarProduto(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JTextField nomeField = new JTextField();
        JTextField precoField = new JTextField();
        JComboBox<String> tipoCombo = new JComboBox<>(new String[]{"eletronico", "livro", "roupa", "alimento"});

        panel.add(new JLabel("Nome do produto:"));
        panel.add(nomeField);
        panel.add(new JLabel("Tipo do produto:"));
        panel.add(tipoCombo);
        panel.add(new JLabel("Preço base:"));
        panel.add(precoField);

        int result = JOptionPane.showConfirmDialog(gui, panel, "Adicionar Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String nome = nomeField.getText().trim();
                String tipo = (String) tipoCombo.getSelectedItem();
                double preco = Double.parseDouble(precoField.getText().trim().replace(",", "."));

                Produto produto = ProdutoFactory.criarProduto(tipo, nome, preco);
                carrinho.adicionarProduto(produto);
                gui.atualizarCarrinho(carrinho.getProdutos());
                gui.atualizarStatus("Produto adicionado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(gui, "Erro: " + ex.getMessage());
                gui.atualizarStatus("Erro ao adicionar produto.");
            }
        }
    }
}
