package trier.encapsulamento;

public class ContaBancariaMain {

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Jude", 10000000);

        conta.depositar(5000);
        conta.sacar(100000);

        System.out.printf("Titular: %s\n", conta.getTitular());
        System.out.println("Saldo: R$" + conta.getSaldo());
    }
}
