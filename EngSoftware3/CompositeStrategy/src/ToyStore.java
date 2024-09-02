public class ToyStore {
    public static void main(String[] args) {
        Toy doll1 = new Doll("Boneca Barbie");
        Toy doll2 = new Doll("Boneca Polly");
        Toy toyCar1 = new ToyCar("Carro Hot Wheels");

        ToyBox toyBox1 = new ToyBox();
        toyBox1.addToy(doll1);
        toyBox1.addToy(toyCar1);

        ToyBox toyBox2 = new ToyBox();
        toyBox2.addToy(doll2);
        toyBox2.addToy(toyBox1);

        toyBox2.display();
    }
}
