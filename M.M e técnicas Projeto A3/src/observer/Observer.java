// Design Pattern: Observer
package observer;

//Padrão Observer: notifica todos os clientes (observers) registrados sobre mudanças.

public interface Observer {
	void atualizar(String mensagem);

}
