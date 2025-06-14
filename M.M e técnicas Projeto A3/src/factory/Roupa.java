package factory;

public class Roupa extends Produto {
	public Roupa(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "Roupa";
    }

}
