package trier.encapsulamento;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double valor){
        if(valor>0){
            this.saldo+=valor;
        }else{
            System.out.println("Valor invalido para depósito!");
        }
    }
    public void sacar(double valor){
        if(valor>0 && valor<=saldo){
            this.saldo-=valor;
        } else{
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }
}
