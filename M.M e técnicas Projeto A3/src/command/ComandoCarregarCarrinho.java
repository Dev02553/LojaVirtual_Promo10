// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de carregar um carrinho salvo.


import gui.LojaGUI;
import model.CarrinhoDeCompras;
import factory.Produto;
import util.PersistenciaArquivo;

import java.util.List;

public class ComandoCarregarCarrinho implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoCarregarCarrinho(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        List<Produto> produtos = PersistenciaArquivo.carregarCarrinho("carrinho_gui.txt");
        for (Produto produto : produtos) {
            carrinho.adicionarProduto(produto);
        }
        gui.atualizarCarrinho(carrinho.getProdutos());
        gui.atualizarStatus("Carrinho carregado.");
    }
}
