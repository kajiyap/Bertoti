public class Doll implements Toy {
    private String name;

    public Doll(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Boneca: " + name);
    }
}