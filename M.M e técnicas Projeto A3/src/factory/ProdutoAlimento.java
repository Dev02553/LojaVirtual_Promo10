// Design Pattern: Factory
package factory;

public class ProdutoAlimento extends Produto {
    public ProdutoAlimento(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "alimento";
    }
}
