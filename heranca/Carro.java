package heranca;

public class Carro extends Veiculo{

    int portas;

    void abrirPortasMalas(){
        System.out.println("Abrindo portas Malas. . .\n");
    }
    @Override
    void acelerar(){
        System.out.println("O carro está acelerando. . .\n");
    }

    @Override
    void frear(){
        System.out.printf("O carro está freando com as %d portas abertas\n", this.portas);
    }
}
