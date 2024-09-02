public class ToyCar implements Toy {
    private String name;

    public ToyCar(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Carro de Brinquedo: " + name);
    }
}