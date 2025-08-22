package Exercicios.Lanchonete;

public class Produto {
    String nome;
    double preco;
    String descricao;
    String categoria;
    int quantidade;

    public Produto(String nome, double preco, String descricao, String categoria, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public boolean reduzirEstoque(int qtd) {
        if (quantidade >= qtd) {
            quantidade -= qtd;
            return true;
        }
        return false;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
}