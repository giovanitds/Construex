package br.com.construex;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String contato;
    private String endereco;

    public Cliente(int id, String nome, String cpf, String contato, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
}
