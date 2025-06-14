// Design Pattern: Factory
package factory;

public class ProdutoLivro extends Produto {
    public ProdutoLivro(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "livro";
    }
}
