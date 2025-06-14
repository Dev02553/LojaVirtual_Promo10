// Design Pattern: Strategy
package strategy;

//Padrão Strategy: implementação específica para uma estratégia de desconto percentual [%].



import factory.Produto;

public class DescontoPercentual implements DescontoStrategy{
	private double percentual;
	
	public DescontoPercentual(double percentual) {
		this.percentual = percentual;
	}
	
	@Override
	public double calcularDesconto(Produto produto) {
		return produto.getPrecoBase() * (percentual / 100);
	}

}
