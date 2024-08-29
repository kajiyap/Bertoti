package service.impl;

import service.Venda;

public class Parcelado implements Venda{
    
    public String vender(){
        Double porcentagemJuros = 17.00/100.00;
        Double precoExemplo = 100000.00;
        Double juros = precoExemplo*porcentagemJuros;
        Double novoPreco = precoExemplo + (juros);
        
        return "Um veículo financiado em nossa loja tem: 17% de juros."+
                "\nLogo se um veículo custa:" +precoExemplo+
                "\nSeu novo valor sera: "+novoPreco;
    }
}
