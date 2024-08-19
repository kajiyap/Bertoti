public class Financiamento implements Venda{
    
    public String vender(Veiculo veiculo){
        Double juros = veiculo.preco*0.15;
        Double novoPreco = veiculo.preco + (juros);
        
        return "veiculo de marca: " + veiculo.marca + 
        "\n de modelo: " + veiculo.nome + 
        "\n de placa: " + veiculo.placa +
        "\n vendido por: " + novoPreco +
        "\n em um financiamento";
    }
}
