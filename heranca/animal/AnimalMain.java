package heranca.animal;

public class AnimalMain {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();
        Jabuti jabuti = new Jabuti();


        gato.nome="Garfield";
        gato.raca="Persa";
        gato.peso= 100;
        gato.sexo= 'M';
        gato.dormir();
        gato.andar();
        gato.comer();
        gato.miar();

        System.out.println("=================================");

        cachorro.nome="Mutley";
        cachorro.raca="Vira-Lata";
        cachorro.peso=50;
        cachorro.sexo='M';
        cachorro.dormir();
        cachorro.andar();
        cachorro.comer();
        cachorro.latir();

        System.out.println("=================================");

        jabuti.nome="Grizelda";
        jabuti.raca="Jabuti";
        jabuti.sexo='F';
        jabuti.dormir();
        jabuti.andar();
        jabuti.comer();
        jabuti.viver();

        System.out.println("=================================");


    }
}
