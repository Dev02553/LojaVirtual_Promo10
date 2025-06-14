// Design Pattern: Strategy
package strategy;

//Padrão Strategy: implementação específica para uma estratégia de desconto fidelidade.


import factory.Produto;

public class DescontoFidelidade implements DescontoStrategy {
    private int anosDeFidelidade;

    public DescontoFidelidade(int anosDeFidelidade) {
        this.anosDeFidelidade = anosDeFidelidade;
    }

    @Override
    public double calcularDesconto(Produto produto) {
        return produto.getPrecoBase() * (0.02 * anosDeFidelidade);
    }
}
