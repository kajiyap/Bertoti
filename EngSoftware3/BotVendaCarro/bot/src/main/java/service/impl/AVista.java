package service.impl;

import service.Venda;

public class AVista implements Venda{

    public String vender(){
        Double porcentagemDesc = 5.00/100.00;
        Double precoExemplo = 100000.00;
        Double desconto = precoExemplo*porcentagemDesc;
        Double novoPreco = precoExemplo - (desconto);
        
        return "Um veículo financiado em nossa loja tem: 5% de desconto."+
                "\nLogo se um veículo custa:" +precoExemplo+
                "\nSeu novo valor sera: "+novoPreco;
    }
}
