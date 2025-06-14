package factory;

public class Eletronico extends Produto {
	 public Eletronico(String nome, double precoBase) {
	        super(nome, precoBase);
	    }

	    @Override
	    public String getTipo() {
	        return "Eletrônico";
	    }
	}


