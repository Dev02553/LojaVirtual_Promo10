// Design Pattern: Observer
package observer;

//Padrão Observer: representa o observador que reage às notificações da loja.

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Observer {
    private String nome;
    private List<String> historicoNotificacoes;

    public Cliente(String nome) {
        this.nome = nome;
        this.historicoNotificacoes = new ArrayList<>();
    }

 // Observer que recebe notificações da loja.
    @Override
    public void atualizar(String mensagem) {
    	historicoNotificacoes.add(mensagem);
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }
    
    public List<String> getHistoricoNotificacoes() {
    	return historicoNotificacoes;
    }
    
    public String getNome() {
        return nome;
    }
}
