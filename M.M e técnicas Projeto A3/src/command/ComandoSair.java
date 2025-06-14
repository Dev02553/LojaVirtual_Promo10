// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de encerrar a atividade.

import gui.LojaGUI;

import javax.swing.*;

public class ComandoSair implements Command {
    @SuppressWarnings("unused")
	private LojaGUI gui;

    public ComandoSair(LojaGUI gui) {
        this.gui = gui;
    }

    @Override
    public void executar() {
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
