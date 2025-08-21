package heranca.animal;

public class Cachorro extends Animal {
    @Override
    void dormir(){
        System.out.println("O cachorro está dormindo. . .\n");
    };

    @Override
    void comer(){
        System.out.println("O cachorro está comendo. . .\n");
    };

    @Override
    void andar(){
        System.out.println("O cachorro está andando. . .\n");
    };


    void latir(){
        System.out.println("O cahorro está latindo. . .\n");
    };
}
