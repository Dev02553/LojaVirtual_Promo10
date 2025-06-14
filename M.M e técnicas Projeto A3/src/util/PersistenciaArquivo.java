package util;

import factory.Produto;
import factory.ProdutoFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersistenciaArquivo {

   
     //Salva os produtos do carrinho em um arquivo texto.
      //Cada linha contém: tipo,nome,precoBase
     
    public static void salvarCarrinho(List<Produto> produtos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Produto produto : produtos) {
                writer.write(produto.getTipo() + "," + produto.getNome() + "," + produto.getPrecoBase());
                writer.newLine();
            }
            System.out.println("Carrinho salvo com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o carrinho: " + e.getMessage());
        }
    }

    /**
     * Carrega os produtos de um arquivo texto.
     * Cada linha deve conter: tipo,nome,precoBase
     * 
     * Padrão de Projeto Aplicado:
     * Factory Method – o método ProdutoFactory.criarProduto() instancia o tipo correto de Produto
     * com base na string "tipo", encapsulando a lógica de criação e permitindo maior flexibilidade.
     */
    public static List<Produto> carregarCarrinho(String nomeArquivo) {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    String tipo = partes[0];
                    String nome = partes[1];
                    double precoBase = Double.parseDouble(partes[2]);

                    // Padrão Factory Method: criação de produtos dinamicamente a partir do tipo
                    Produto produto = ProdutoFactory.criarProduto(tipo, nome, precoBase);
                    produtos.add(produto);
                }
            }
            System.out.println("Carrinho carregado com sucesso de " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao carregar o carrinho: " + e.getMessage());
        }
        return produtos;
    }
}
