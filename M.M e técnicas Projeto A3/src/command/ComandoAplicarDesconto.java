// Design Pattern: Command
package command;


import gui.LojaGUI;
import model.CarrinhoDeCompras;
import strategy.*;

import javax.swing.*;

public class ComandoAplicarDesconto implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoAplicarDesconto(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    
    @Override
    public void executar() {
        if (carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(gui, "Carrinho vazio. Adicione produtos antes.");
            return;
        }

        String[] opcoes = {"Percentual", "Fixo", "Progressivo", "Fidelidade"};
        int escolha = JOptionPane.showOptionDialog(gui, "Escolha o tipo de desconto:",
                "Desconto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opcoes, opcoes[0]);

        if (escolha == -1) return;

        DescontoStrategy estrategia = null;

        try {
            switch (escolha) {
            // Escolha dinâmica da estratégia de desconto com base na entrada do usuário (Strategy Pattern).
                case 0 -> estrategia = new DescontoPercentual(Double.parseDouble(
                    JOptionPane.showInputDialog("Informe o percentual:")));
                case 1 -> estrategia = new DescontoFixo(Double.parseDouble(
                    JOptionPane.showInputDialog("Informe o valor fixo:")));
                case 2 -> estrategia = new DescontoProgressivo(Integer.parseInt(
                    JOptionPane.showInputDialog("Informe a quantidade:")));
                case 3 -> estrategia = new DescontoFidelidade(Integer.parseInt(
                    JOptionPane.showInputDialog("Informe anos de fidelidade:")));
            }

            double total = carrinho.calcularTotal(estrategia);
            JOptionPane.showMessageDialog(gui, "Total com desconto: R$ " + total);
            gui.atualizarStatus("Compra finalizada.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(gui, "Erro: " + ex.getMessage());
            gui.atualizarStatus("Erro ao aplicar desconto.");
        }
    }
}
