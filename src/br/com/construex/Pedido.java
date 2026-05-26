package br.com.construex;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private List<Integer> quantidades;
    private double valorTotal;
    private String formaPagamento;

    public Pedido(int id, Cliente cliente, String formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.produtos = new ArrayList<>();
        this.quantidades = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    // Adiciona produto, calcula total e baixa estoque (Protótipo do RF004 e RF005)
    public void adicionarItem(Produto produto, int qtd) {
        if (produto.getQuantidade() >= qtd) {
            this.produtos.add(produto);
            this.quantidades.add(qtd);
            this.valorTotal += produto.getPreco() * qtd;
            
            // RF005 - Controle de Estoque (Baixa automática)
            produto.setQuantidade(produto.getQuantidade() - qtd);
            System.out.println("Item adicionado: " + qtd + "x " + produto.getNome());
        } else {
            System.out.println("Erro: Estoque insuficiente para " + produto.getNome());
        }
    }

    public void fecharPedido() {
        System.out.println("\n--- PEDIDO CONFIRMADO ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("-------------------------\n");
    }
}
