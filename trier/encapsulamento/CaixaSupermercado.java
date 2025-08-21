package trier.encapsulamento;

public class CaixaSupermercado {
    private double totalCompra;

    public void adicionarCompra(double preco){
        if (preco > 0){
            totalCompra += preco;
        }
    }

    public double getTotalCompra() {
        return totalCompra;
    }

}
