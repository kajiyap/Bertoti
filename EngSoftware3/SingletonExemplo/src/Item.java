public class Item implements Componente {
    private String nome;

    public Item(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir() {
        System.out.println("Item: " + nome);
    }
}
