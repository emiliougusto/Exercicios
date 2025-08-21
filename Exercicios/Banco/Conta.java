package Exercicios.Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected double saldo;
    protected Cliente cliente;
    protected LocalDateTime dataCriacao;
    protected List<Operacao> historico;

    public Conta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.dataCriacao = LocalDateTime.now();
        this.historico = new ArrayList<>();
        historico.add(new Operacao("Abertura", saldo, null));
    }
    public String getNomeTitular() {
        return cliente.nome;
    }

    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
            historico.add(new Operacao("Depósito", valor, null));
        } else {
            System.out.println("Valor de depósito inválido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            historico.add(new Operacao("Saque", valor, null));
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && valor <= (saldo)) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            historico.add(new Operacao("Transferência Enviada", valor, "Para: " + contaDestino.getNomeTitular()));
            contaDestino.historico.add(new Operacao("Transferência Recebida", valor, "De: " + this.getNomeTitular()));
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência!");
        }
    }

    public void verExtrato() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Data de criação: " + dataCriacao.format(formatter));
        System.out.println("Extrato da Conta:");
        System.out.println("Titular: " + getNomeTitular());
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Data de criação: " + dataCriacao.format(formatter));
        System.out.println("Histórico de operações:");
        for (Operacao op : historico) {
            System.out.println(op);
        }
    }


}

