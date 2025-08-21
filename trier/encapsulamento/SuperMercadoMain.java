package trier.encapsulamento;

public class SuperMercadoMain {

    public static void main(String[] args) {
        CaixaSupermercado caixa = new CaixaSupermercado();

        caixa.adicionarCompra(10.50);
        caixa.adicionarCompra(5.20);

        System.out.printf("Total da compra R$ %.2f%n", caixa.getTotalCompra());
    }
}
