package heranca.animal;

public class Gato extends Animal {


    void miar(){
        System.out.println("O gato está miando. . .\n");
    }
    @Override
    void dormir(){
        System.out.println("O gato está dormindo. . .\n");
    };

    @Override
    void comer(){
        System.out.println("O gato está comendo. . .\n");
    };

    @Override
    void andar(){
        System.out.println("O gato está andando. . .\n");
    };


}
