import java.util.ArrayList;
import java.util.List;

public class ToyBox implements Toy {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void removeToy(Toy toy) {
        toys.remove(toy);
    }

    @Override
    public void display() {
        System.out.println("Caixa de Brinquedos contém:");
        for (Toy toy : toys) {
            toy.display();
        }
    }
}