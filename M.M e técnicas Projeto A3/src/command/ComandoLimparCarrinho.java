// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de esvaziar o carrinho.


import gui.LojaGUI;
import model.CarrinhoDeCompras;

import javax.swing.*;

public class ComandoLimparCarrinho implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoLimparCarrinho(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        if (carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carrinho já está vazio.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar o carrinho?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            carrinho.getProdutos().clear();
            gui.atualizarCarrinho(carrinho.getProdutos());
            gui.atualizarStatus("Carrinho limpo.");
        }
    }
}
