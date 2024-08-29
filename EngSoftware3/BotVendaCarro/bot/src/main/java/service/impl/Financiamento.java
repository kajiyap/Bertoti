package service.impl;

import service.Venda;

public class Financiamento implements Venda{
    
    public String vender(){
        Double porcentagemJuros = 15.00/100.00;
        Double precoExemplo = 100000.00;
        Double juros = precoExemplo*porcentagemJuros;
        Double novoPreco = precoExemplo + (juros);
        
        return "Um veículo financiado em nossa loja tem: 15% de juros."+
                "\nLogo se um veículo custa:" +precoExemplo+
                "\nSeu novo valor sera: "+novoPreco;
    }
}
