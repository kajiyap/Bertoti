public class AVista implements Venda{

    public String vender(Veiculo veiculo) {
        Double desconto = veiculo.preco*0.15;
        Double novoPreco = veiculo.preco - (desconto);
        
        return "veiculo de marca: " + veiculo.marca + 
        "\n de modelo: " + veiculo.nome + 
        "\n de placa: " + veiculo.placa +
        "\n vendido por: " + novoPreco +
        "\n parcelado em no maximo: 10 vezes";
    }
}
