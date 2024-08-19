package Models;

import java.util.LinkedList;
import java.util.List;

public class LojaRoupas {
	
	private List<Roupas> roupas = new LinkedList<Roupas>();
	
	public void cadastrarRoupas(Roupas roupa){
        roupas.add(roupa);
   }

	public Roupas bucarRoupasPorCodigoID (String codigoID) {
		for (Roupas roupa:roupas) {
            if(roupa.getCodigoID().equals(codigoID))return roupa; 

		}
		return null;
	}
	
	public List<Roupas> getRoupas(){
		return roupas;
	}
}
