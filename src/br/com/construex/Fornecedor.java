package br.com.construex;

public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String contato;
    private String endereco;

    public Fornecedor(int id, String nome, String cnpj, String contato, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.endereco = endereco;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getContato() { return contato; }
    public String getEndereco() { return endereco; }
}