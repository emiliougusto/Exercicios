package trier.encapsulamento;

import java.util.ArrayList;

public class Hamburguer {

    private ArrayList<String> ingredientes = new ArrayList<>();

    public void adicionarIngredientes(String ingrediente){
        if(ingrediente != null && !ingrediente.isEmpty()){
            ingredientes.add(ingrediente);
        }else{
            System.out.println("Erro ao adicionar ingredientes!\n Nã pode ser null ou vazio");
        }
    }

    public void mostrarHamburguer(){
        System.out.printf("Hamburguer com %s", ingredientes);
    }
}
