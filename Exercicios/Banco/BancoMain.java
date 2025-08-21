package Exercicios.Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoMain {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Conta> contas = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        Conta conta = null;

        int opcao = 0;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Entrar na sua conta");
            System.out.println("6 - Sair");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do titular da conta: ");
                    String nome = input.nextLine();
                    System.out.println("Digite a idade do titular: ");
                    int idade = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite seu CPF: ");
                    String cpf = input.nextLine();
                    System.out.println("Digite o saldo inicial: ");
                    double saldo = input.nextDouble();
                    input.nextLine();

                    System.out.println("Selecione o tipo de conta:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int tipoConta = input.nextInt();
                    input.nextLine();
                    Cliente novoCliente = new Cliente(nome, idade, cpf);
                    clientes.add(novoCliente);

                    if(tipoConta == 1){
                        conta = new ContaCorrente(novoCliente, saldo);
                    } else if(tipoConta == 2){
                        conta = new ContaPoupanca(novoCliente, saldo);
                    } else {
                        System.out.println("Tipo de conta inválido!");
                        continue;
                    }
                    contas.add(conta);

                    System.out.println("Conta criada com sucesso!\n");
                    conta.verExtrato();
                    break;
                case 2:
                    if (contas.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada.");
                        break;
                    }
                    System.out.println("Digite o CPF do titular: ");
                    String cpfDigitado = input.nextLine();
                    Conta contaLogada = null;
                    for (Conta c : contas) {
                        if (c.cliente.CPF.equals(cpfDigitado)) {
                            contaLogada = c;
                            break;
                        }
                    }
                    if (contaLogada != null) {
                        System.out.println("Acesso permitido!");
                        int opConta;
                        do {
                            System.out.println("1 - Ver Extrato");
                            System.out.println("2 - Depositar");
                            System.out.println("3 - Sacar");
                            System.out.println("4 - Transferir");
                            System.out.println("5 - Sair");
                            opConta = input.nextInt();
                            input.nextLine();
                            switch (opConta) {
                                case 1:
                                    contaLogada.verExtrato();
                                    break;
                                case 2:
                                    System.out.println("Valor para depósito:");
                                    double valorDep = input.nextDouble();
                                    input.nextLine();
                                    contaLogada.depositar(valorDep);
                                    break;
                                case 3:
                                    System.out.println("Valor para saque:");
                                    double valorSaq = input.nextDouble();
                                    input.nextLine();
                                    contaLogada.sacar(valorSaq);
                                    break;
                                case 4:
                                    System.out.println("Digite o CPF do destinatário:");
                                    String cpfDestino = input.nextLine();
                                    Conta contaDestino = null;
                                    for (Conta c : contas) {
                                        if (c.cliente.CPF.equals(cpfDestino)) {
                                            contaDestino = c;
                                            break;
                                        }
                                    }
                                    if (contaDestino == null) {
                                        System.out.println("Conta de destino não encontrada.");
                                        break;
                                    }
                                    System.out.println("Valor para transferência:");
                                    double valorTransf = input.nextDouble();
                                    input.nextLine();
                                    contaLogada.transferir(contaDestino, valorTransf);
                                    break;
                                case 5:
                                    System.out.println("Saindo da conta . . .");
                                    break;
                                default:
                                    System.out.println("Opção inválida! Tente novamente.");
                            }
                        } while (opConta != 5);
                    } else {
                        System.out.println("CPF não encontrado ou conta não cadastrada.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        input.close();
    }
}