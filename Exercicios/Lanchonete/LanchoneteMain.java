package Exercicios.Lanchonete;

import java.util.ArrayList;
import java.util.Scanner;

public class LanchoneteMain {
    public static void main(String[] args) {
        ArrayList<Lanche> lanches = new ArrayList<>();
        ArrayList<Bebida> bebidas = new ArrayList<>();
        ArrayList<Sobremesa> sobremesas = new ArrayList<>();
        ArrayList<Produto> carrinho = new ArrayList<>();

        lanches.add(new Lanche("X-Burguer", 10.00, "Pão, carne, queijo e molho"));
        lanches.add(new Lanche("X-Salada", 12.00, "Pão, carne, queijo, alface e tomate"));
        lanches.add(new Lanche("X-Bacon", 15.00, "Pão, carne, queijo, bacon e molho"));

        bebidas.add(new Bebida("Refrigerante", 5.00, "Refrigerante gelado"));
        bebidas.add(new Bebida("Suco", 6.00, "Suco natural de frutas"));

        sobremesas.add(new Sobremesa("Pudim", 7.00, "Pudim de leite condensado"));
        sobremesas.add(new Sobremesa("Sorvete", 8.00, "Sorvete de creme com calda de chocolate"));


        Scanner input = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("\n ======Cardápio======");
            System.out.println("1. Lanches");
            System.out.println("2. Bebidas");
            System.out.println("3. Sobremesas");
            System.out.println("4. Ver Carrinho");
            System.out.println("5. Finalizar Pedido");
            System.out.println("6. Sair");
            System.out.println("=====================");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProdutoCategoria(lanches, carrinho, input, "Lanches");
                    break;
                case 2:
                    adicionarProdutoCategoria(bebidas, carrinho, input, "Bebidas");
                    break;
                case 3:
                    adicionarProdutoCategoria(sobremesas, carrinho, input, "Sobremesas");
                    break;
                case 4:
                    mostrarCarrinho(carrinho);
                    break;
                case 5:
                    System.out.println("Pedido finalizado. Obrigado!");
                    mostrarCarrinho(carrinho);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);
        input.close();
    }
        private static void adicionarProdutoCategoria (ArrayList < ? extends
        Produto > lista, ArrayList < Produto > carrinho, Scanner input, String categoria){
            System.out.println("\n--- " + categoria + " ---");
            for (int i = 0; i < lista.size(); i++) {
                Produto p = lista.get(i);
                System.out.println((i + 1) + ". " + p.getNome() + " - R$" + p.getPreco());
            }
            System.out.println((lista.size() + 1) + ". Voltar");
            System.out.print("Selecione um produto para adicionar ao carrinho: ");
            int escolha = input.nextInt();
            if (escolha > 0 && escolha <= lista.size()) {
                carrinho.add(lista.get(escolha - 1));
                System.out.println("Produto adicionado ao carrinho!");
            } else if (escolha != lista.size() + 1) {
                System.out.println("Opção inválida!");
            }
        }
        private static void mostrarCarrinho (ArrayList < Produto > carrinho){
            if (carrinho.isEmpty()) {
                System.out.println("Carrinho vazio.");
            } else {
                System.out.println("\n--- Carrinho ---");
                for (Produto p : carrinho) {
                    System.out.println(p.getNome() + " - R$" + p.getPreco());
                }
                double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();
                System.out.println("Total: R$" + total);
            }
        }
}


