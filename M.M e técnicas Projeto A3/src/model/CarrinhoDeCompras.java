// Design Pattern: Strategy
// Esta classe representa um carrinho de compras que pode aplicar diferentes estratégias de desconto
package model;

import factory.Produto;
import strategy.DescontoStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> produtos;

    public CarrinhoDeCompras() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Calcula o total com base na estratégia de desconto fornecida.
     * 
     * Design Pattern Aplicado:
     * Strategy – a lógica de cálculo do desconto é delegada a uma estratégia externa
     * que implementa a interface DescontoStrategy. Isso permite alterar dinamicamente
     * a forma de calcular o desconto sem modificar esta classe.
     */
    public double calcularTotal(DescontoStrategy estrategia) {
        double total = 0.0;
        for (Produto produto : produtos) {
            // Aplica a estratégia de desconto ao produto atual
            double desconto = estrategia.calcularDesconto(produto);
            double precoFinal = produto.getPrecoBase() - desconto;
            total += precoFinal;

            System.out.println(produto.getNome() + ": Preço base R$" + produto.getPrecoBase() +
                    " | Desconto R$" + desconto + " | Preço final R$" + precoFinal);
        }
        return total;
    }
}
