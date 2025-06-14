package factory;

public class Alimento extends Produto {
	public Alimento(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "Alimento";
    }
}

