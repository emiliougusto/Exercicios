package heranca;

public class Moto extends Veiculo {
    void empinar (){
        System.out.println("Está empinando . . .\n");
    }
    @Override
    void acelerar(){
        System.out.println("A moto está acelerando e empinando . . .\n");
    }

    @Override
    void frear(){
        System.out.println("A moto está freando e empinando ao contrario. . .\n");
    }
}
