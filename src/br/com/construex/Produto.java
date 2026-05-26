package br.com.construex;

public class Produto {
    private int id;
    private String nome;
    private String categoria; // Corrigido aqui para português
    private String unidade;
    private double preco;
    private int quantidade;
    private Fornecedor fornecedor;
    private String observacoes;

    // Construtor alinhado com os parâmetros passados na Main
    public Produto(int id, String nome, String categoria, String unidade, double preco, int quantidade, Fornecedor fornecedor, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.unidade = unidade;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.observacoes = observacoes;
    }

    public boolean precisaReposicao() {
        return this.quantidade < 5;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
