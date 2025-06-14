// Design Pattern: Command
package command;

/*Padrão Command: esta classe encapsula a ação específica do sistema de remover um produto em especifico.
*Em caso de multiplos itens repetidos ele ira eliminar o ultimo adicionado.
*/

import gui.LojaGUI;
import model.CarrinhoDeCompras;
import factory.Produto;

public class ComandoRemoverProduto implements Command {
    private LojaGUI gui;
    private CarrinhoDeCompras carrinho;

    public ComandoRemoverProduto(LojaGUI gui, CarrinhoDeCompras carrinho) {
        this.gui = gui;
        this.carrinho = carrinho;
    }

    @Override
    public void executar() {
        String nome = javax.swing.JOptionPane.showInputDialog("Informe o nome do produto a remover:");
        Produto paraRemover = null;

        for (Produto p : carrinho.getProdutos()) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                paraRemover = p;
                break;
            }
        }

        if (paraRemover != null) {
            carrinho.getProdutos().remove(paraRemover);
            gui.atualizarCarrinho(carrinho.getProdutos());
            gui.atualizarStatus("Produto removido.");
        } else {
            gui.atualizarStatus("Produto não encontrado.");
        }
    }
}
