// Design Pattern: Strategy
package strategy;

import factory.Produto;

//Padrão Strategy: define uma interface comum para estratégias de cálculo de desconto.

public interface DescontoStrategy {
	double calcularDesconto(Produto produto);

}
