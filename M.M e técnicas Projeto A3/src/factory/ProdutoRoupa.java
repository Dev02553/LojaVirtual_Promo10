// Design Pattern: Factory
package factory;

public class ProdutoRoupa extends Produto {
    public ProdutoRoupa(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "roupa";
    }
}
