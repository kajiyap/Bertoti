public class Personagem implements Componente {
    private String nome;

    public Personagem(String nome) {
        this.nome = nome;
    }

    @Override
    public void exibir() {
        System.out.println("Personagem: " + nome);
    }
}
