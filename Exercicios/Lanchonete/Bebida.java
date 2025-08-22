package Exercicios.Lanchonete;

public class Bebida extends Produto {
    public Bebida(String nome, double preco, String descricao, int quantidade) {
        super(nome, preco, descricao, "Bebidas", quantidade);
    }
}