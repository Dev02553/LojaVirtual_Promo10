// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de armazenar o carrinho.


import gui.LojaGUI;
import model.CarrinhoDeCompras;
import util.PersistenciaArquivo;

public class ComandoSalvarCarrinho implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoSalvarCarrinho(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        PersistenciaArquivo.salvarCarrinho(carrinho.getProdutos(), "carrinho_gui.txt");
        gui.atualizarStatus("Carrinho salvo com sucesso!");
    }
}
