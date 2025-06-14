// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de notificar os clientes.

import gui.LojaGUI;
import observer.Cliente;
import observer.Loja;

public class ComandoNotificarClientes implements Command {
    private LojaGUI gui;
    private Loja loja;

    public ComandoNotificarClientes(LojaGUI gui, Loja loja) {
        this.gui = gui;
        this.loja = loja;
    }

    @Override
    public void executar() {
        String mensagem = "🎉 Promoção especial! Aproveite os descontos no carrinho!";
        
     // Uso do Observer Pattern: envia uma mensagem para todos os clientes observadores da loja.        
        loja.notificarClientes(mensagem);
        gui.atualizarStatus("Clientes foram notificados!");

        StringBuilder sb = new StringBuilder("📣 Notificações enviadas:\n");
        for (Cliente c : loja.getClientes()) {
            sb.append("🧑 Cliente: ").append(c.getNome()).append("\n");
            for (String msg : c.getHistoricoNotificacoes()) {
                sb.append("   • ").append(msg).append("\n");
            }
        }

        javax.swing.JOptionPane.showMessageDialog(gui, sb.toString(), "Notificações", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}
