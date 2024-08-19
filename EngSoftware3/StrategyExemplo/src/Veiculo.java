public class Veiculo {
    public String marca;
    public String nome;
    public String placa;
    public Double preco;
    public Venda venda;

    public Veiculo(String marca, String nome, String placa, Double preco){
        this.marca = marca;
        this.nome = nome;
        this.placa = placa;
        this.preco = preco;
        System.out.println("criado");
    }

    public void fazerVenda(Veiculo v){
        System.out.println(this.venda.vender(v));
    }
}
