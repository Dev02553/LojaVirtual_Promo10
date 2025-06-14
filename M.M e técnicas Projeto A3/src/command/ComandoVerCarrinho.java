// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de exibir os itens do carrinho.

import gui.LojaGUI;
import model.CarrinhoDeCompras;
import factory.Produto;

import javax.swing.*;
import java.util.List;

public class ComandoVerCarrinho implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoVerCarrinho(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        List<Produto> produtos = carrinho.getProdutos();

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(gui, "Carrinho está vazio.");
            gui.atualizarStatus("Carrinho vazio.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Produto produto : produtos) {
                sb.append(produto.getTipo())
                  .append(" - ").append(produto.getNome())
                  .append(" - R$").append(produto.getPrecoBase())
                  .append("\n");
            }
            JOptionPane.showMessageDialog(gui, sb.toString(), "Carrinho", JOptionPane.INFORMATION_MESSAGE);
            gui.atualizarStatus("Carrinho visualizado.");
        }
    }
}
