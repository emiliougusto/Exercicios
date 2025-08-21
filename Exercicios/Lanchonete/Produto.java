package Exercicios.Lanchonete;

public class Produto {
    String nome;
    double preco;
    String descricao;
    String categoria;

    public Produto(String nome, double preco, String descricao, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

}
