package heranca;

public class VeiculoMain {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.marca = "Toyota";
        carro.ano = 2021;
        carro.portas = 4;
        carro.abrirPortasMalas();
        carro.acelerar();//herdado do veiculo
        carro.frear();//herdado do veiculo

        Moto moto = new Moto();
        moto.marca = "Honda";
        moto.ano = 2021;
        moto.acelerar();
        moto.frear();
        moto.empinar();
    }
}
