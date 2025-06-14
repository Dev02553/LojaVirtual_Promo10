// Design Pattern: Command
package command;

//Padrão Command: esta classe encapsula a ação específica do sistema de criar um novo produto.


import factory.Produto;
import factory.ProdutoFactory;

import javax.swing.*;

public class ComandoCriarProduto implements Command {

    @Override
    public void executar() {
        String tipo = JOptionPane.showInputDialog(null, "Digite o tipo de produto (eletronico, livro, roupa, alimento):");
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto:");
        String precoStr = JOptionPane.showInputDialog(null, "Digite o preço base:");

        try {
            double preco = Double.parseDouble(precoStr.replace(",", "."));
            Produto produto = ProdutoFactory.criarProduto(tipo, nome, preco);
            JOptionPane.showMessageDialog(null, "Produto criado: " + produto.getNome() + " - R$" + produto.getPrecoBase());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar produto: " + e.getMessage());
        }
    }
}
