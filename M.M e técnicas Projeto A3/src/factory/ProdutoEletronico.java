// Design Pattern: Factory
package factory;

public class ProdutoEletronico extends Produto {
    public ProdutoEletronico(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "eletronico";
    }
}
