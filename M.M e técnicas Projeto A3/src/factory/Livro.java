package factory;

public class Livro extends Produto{
	public Livro(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}
