// Design Pattern: Strategy
package strategy;

//Padrão Strategy: implementação específica para a estratégia de desconto progressivo.


import factory.Produto;

public class DescontoProgressivo implements DescontoStrategy {
    private int quantidade;

    public DescontoProgressivo(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public double calcularDesconto(Produto produto) {
        double desconto = 0;
        if (quantidade >= 5 && quantidade < 10) {
            desconto = produto.getPrecoBase() * 0.10;
        } else if (quantidade >= 10) {
            desconto = produto.getPrecoBase() * 0.20;
        }
        return desconto;
    }
}
