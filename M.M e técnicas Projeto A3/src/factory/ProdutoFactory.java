// Design Pattern: Factory
package factory;

public class ProdutoFactory {
    public static Produto criarProduto(String tipo, String nome, double preco) {
        switch (tipo.toLowerCase()) {
            case "eletronico": return new ProdutoEletronico(nome, preco);
            case "livro":      return new ProdutoLivro(nome, preco);
            case "roupa":      return new ProdutoRoupa(nome, preco);
            case "alimento":   return new ProdutoAlimento(nome, preco);
            default:
                throw new IllegalArgumentException("Tipo inválido: " + tipo);
        }
    }
}

