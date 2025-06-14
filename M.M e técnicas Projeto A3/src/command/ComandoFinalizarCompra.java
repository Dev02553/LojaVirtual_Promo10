// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de encerrar a venda.


import model.CarrinhoDeCompras;
import strategy.*;

import javax.swing.*;

public class ComandoFinalizarCompra implements Command {
    private final CarrinhoDeCompras carrinho;

    public ComandoFinalizarCompra(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        if (carrinho.getProdutos().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carrinho vazio. Adicione produtos antes.");
            return;
        }

        String[] opcoes = {"Percentual", "Fixo", "Progressivo", "Fidelidade"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de desconto:",
                "Desconto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opcoes, opcoes[0]);

        if (escolha == -1) return;

        DescontoStrategy estrategia = null;
        try {
            switch (escolha) {
                case 0:
                    double perc = Double.parseDouble(JOptionPane.showInputDialog("Informe o percentual:"));
                    estrategia = new DescontoPercentual(perc);
                    break;
                case 1:
                    double fixo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor fixo:"));
                    estrategia = new DescontoFixo(fixo);
                    break;
                case 2:
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade:"));
                    estrategia = new DescontoProgressivo(qtd);
                    break;
                case 3:
                    int anos = Integer.parseInt(JOptionPane.showInputDialog("Informe anos de fidelidade:"));
                    estrategia = new DescontoFidelidade(anos);
                    break;
            }

            double total = carrinho.calcularTotal(estrategia);
            JOptionPane.showMessageDialog(null, "Total final com desconto: R$" + total);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular desconto: " + e.getMessage());
        }
    }
}

