package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;
import java.util.LinkedHashMap;

public class ObjetoNodeString<K> {
	
	private String dato;

    public ObjetoNodeString() {
        this.dato = new String();;
    }

    public void add(K item)
    {
        //this.lista.add(item1);
        //lista.put(item, item1);
    	dato = item.toString();
    }

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
    
    
	
	

    
}
