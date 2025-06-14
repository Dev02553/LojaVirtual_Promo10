// Design Pattern: Observer
package observer;


import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Observer> clientes = new ArrayList<>();

    public void adicionarCliente(Observer cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Observer cliente) {
        clientes.remove(cliente);
    }

    // Padrão Observer: notifica todos os clientes (observadores) com a nova mensagem
    public void notificarClientes(String mensagem) {
        for (Observer cliente : clientes) {
            cliente.atualizar(mensagem);
        }
    }

    public List<Cliente> getClientes() {
        List<Cliente> lista = new ArrayList<>();
        for (Observer obs : clientes) {
            if (obs instanceof Cliente c) {
                lista.add(c);
            }
        }
        return lista;
    }
}
