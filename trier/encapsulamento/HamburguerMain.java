package trier.encapsulamento;

public class HamburguerMain {
    public static void main(String[] args) {
        Hamburguer hamburguer = new Hamburguer();

        hamburguer.adicionarIngredientes("Pão");
        hamburguer.adicionarIngredientes("Queijo");
        hamburguer.adicionarIngredientes("Hamburguer");
        hamburguer.adicionarIngredientes("Coração");
        hamburguer.adicionarIngredientes("Barbecue");
        hamburguer.adicionarIngredientes("Cebola Caramelizada");

        hamburguer.mostrarHamburguer();

    }
}
