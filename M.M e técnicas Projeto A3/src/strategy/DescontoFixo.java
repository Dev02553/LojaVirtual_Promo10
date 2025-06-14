// Design Pattern: Strategy
package strategy;

//Padrão Strategy: implementação específica para uma estratégia de desconto fixo.


import factory.Produto;

public class DescontoFixo implements DescontoStrategy {
	private double valorFixo;
	
	public DescontoFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    @Override
    public double calcularDesconto(Produto produto) {
        return valorFixo;
    }

}
