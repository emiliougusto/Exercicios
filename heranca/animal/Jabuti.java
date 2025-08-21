package heranca.animal;

public class Jabuti extends Animal{
    void viver(){
        System.out.println("O jabuti está vivendo. . .\n");
    }
    @Override
    void dormir(){
        System.out.println("O jabuti está dormindo. . .\n");
    };

    @Override
    void comer(){
        System.out.println("O jabuti está comendo. . .\n");
    };

    @Override
    void andar(){
        System.out.println("O jabuti está andando. . .\n");
    };
}
