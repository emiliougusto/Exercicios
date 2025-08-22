package Exercicios.Lanchonete;

public class Lanche extends Produto {
    public Lanche(String nome, double preco, String descricao, int quantidade) {
        super(nome, preco, descricao, "Lanches", quantidade);
    }
}