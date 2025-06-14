// Design Pattern: Command
package command;

//Padrão Command: permite registrar e executar comandos dinamicamente a partir de strings.

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private Map<String, Command> comandos = new HashMap<>();

    // Padrão Command: registra comandos associando strings a ações encapsuladas
    public void registrarComando(String nome, Command comando) {
        comandos.put(nome, comando);
    }

    // Padrão Command: executa o comando associado à ação
    public void executar(String nome) {
        Command comando = comandos.get(nome);
        if (comando != null) {
            comando.executar();
        } else {
            System.err.println("Comando não encontrado: " + nome);
        }
    }
}
