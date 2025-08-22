package Exercicios.Lanchonete;

import java.util.ArrayList;
import java.util.Scanner;

public class LanchoneteMain {

    static final double TAXA_SERVICO = 0.1;
    static ArrayList<Venda> relatorioVendas = new ArrayList<>();
    static int numeroPedido = 1;

    static class Venda {
        int numeroPedido;
        String nomeProduto;
        int quantidade;
        int gratis;
        double valorTotal;

        Venda(int numeroPedido, String nomeProduto, int quantidade, int gratis, double valorTotal) {
            this.numeroPedido = numeroPedido;
            this.nomeProduto = nomeProduto;
            this.quantidade = quantidade;
            this.gratis = gratis;
            this.valorTotal = valorTotal;
        }
    }

    public static void main(String[] args) {
        ArrayList<Lanche> lanches = new ArrayList<>();
        ArrayList<Bebida> bebidas = new ArrayList<>();
        ArrayList<Sobremesa> sobremesas = new ArrayList<>();
        ArrayList<Produto> carrinho = new ArrayList<>();

        lanches.add(new Lanche("X-Burguer", 10.00, "Pão, carne, queijo e molho",10));
        lanches.add(new Lanche("X-Salada", 12.00, "Pão, carne, queijo, alface e tomate", 10));
        lanches.add(new Lanche("X-Bacon", 15.00, "Pão, carne, queijo, bacon e molho", 10));

        bebidas.add(new Bebida("Refrigerante", 5.00, "Refrigerante gelado",10));
        bebidas.add(new Bebida("Suco", 6.00, "Suco natural de frutas",10));

        sobremesas.add(new Sobremesa("Pudim", 7.00, "Pudim de leite condensado",10));
        sobremesas.add(new Sobremesa("Sorvete", 8.00, "Sorvete de creme com calda de chocolate",10));

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n ======Cardápio======");
            System.out.println("1. Lanches");
            System.out.println("2. Bebidas");
            System.out.println("3. Sobremesas");
            System.out.println("4. Ver Carrinho");
            System.out.println("5. Finalizar Pedido");
            System.out.println("6. Relatório de Vendas");
            System.out.println("7. Sair");
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
                    registrarVendas(carrinho);
                    mostrarCarrinho(carrinho);
                    carrinho.clear();
                    break;
                case 6:
                    mostrarRelatorioVendas();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);
        input.close();
    }

    private static void adicionarProdutoCategoria(ArrayList<? extends Produto> lista, ArrayList<Produto> carrinho, Scanner input, String categoria) {
        System.out.println("\n--- " + categoria + " ---");
        for (int i = 0; i < lista.size(); i++) {
            Produto p = lista.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - R$" + p.getPreco() + " (Estoque: " + p.getQuantidade() + ")");
        }
        System.out.println((lista.size() + 1) + ". Voltar");
        System.out.print("Selecione um produto para adicionar ao carrinho: ");
        int escolha = input.nextInt();
        if (escolha > 0 && escolha <= lista.size()) {
            Produto p = lista.get(escolha - 1);
            System.out.print("Digite a quantidade desejada: ");
            int qtd = input.nextInt();
            if (qtd > 0 && p.getQuantidade() >= qtd) {
                p.reduzirEstoque(qtd);
                for (int i = 0; i < qtd; i++) {
                    carrinho.add(p);
                }
                System.out.println("Produto adicionado ao carrinho!");
            } else {
                System.out.println("Quantidade inválida ou estoque insuficiente!");
            }
        } else if (escolha != lista.size() + 1) {
            System.out.println("Opção inválida!");
        }
    }

    private static void mostrarCarrinho(ArrayList<Produto> carrinho) {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("\n--- Carrinho ---");
            java.util.Map<String, Integer> contagem = new java.util.HashMap<>();
            java.util.Map<String, Double> precos = new java.util.HashMap<>();
            for (Produto p : carrinho) {
                contagem.put(p.getNome(), contagem.getOrDefault(p.getNome(), 0) + 1);
                precos.put(p.getNome(), p.getPreco());
            }
            double total = 0;
            for (String nome : contagem.keySet()) {
                int qtd = contagem.get(nome);
                double preco = precos.get(nome);
                int gratis = qtd / 3;
                int cobrados = qtd - gratis;
                double subtotal = cobrados * preco;
                System.out.print(qtd + "x " + nome + " - R$" + subtotal);
                if (gratis > 0) {
                    System.out.print(" (Promoção: " + gratis + " grátis)");
                }
                System.out.println();
                total += subtotal;
            }
            double taxa = total * TAXA_SERVICO;
            System.out.println("Taxa de serviço: R$" + taxa);
            System.out.println("Total: R$" + (total + taxa));
        }
    }

    private static void registrarVendas(ArrayList<Produto> carrinho) {
        java.util.Map<String, Integer> contagem = new java.util.HashMap<>();
        java.util.Map<String, Double> precos = new java.util.HashMap<>();
        for (Produto p : carrinho) {
            contagem.put(p.getNome(), contagem.getOrDefault(p.getNome(), 0) + 1);
            precos.put(p.getNome(), p.getPreco());
        }
        for (String nome : contagem.keySet()) {
            int qtd = contagem.get(nome);
            double preco = precos.get(nome);
            int gratis = qtd / 3;
            int cobrados = qtd - gratis;
            double valorTotal = cobrados * preco;
            relatorioVendas.add(new Venda(numeroPedido, nome, qtd, gratis, valorTotal));
        }
        numeroPedido++;
    }

    private static void mostrarRelatorioVendas() {
        System.out.println("\n--- Relatório Diário de Vendas ---");
        double total = 0;
        for (Venda v : relatorioVendas) {
            System.out.print("Pedido #" + v.numeroPedido + ": ");
            System.out.print(v.quantidade + "x " + v.nomeProduto + " - R$" + v.valorTotal);
            if (v.gratis > 0) {
                System.out.print(" (Promoção: " + v.gratis + " grátis)");
            }
            System.out.println();
            total += v.valorTotal;
        }
        double taxa = total * TAXA_SERVICO;
        System.out.println("Taxa de serviço total: R$" + taxa);
        System.out.println("Total arrecadado: R$" + (total + taxa));
    }
}