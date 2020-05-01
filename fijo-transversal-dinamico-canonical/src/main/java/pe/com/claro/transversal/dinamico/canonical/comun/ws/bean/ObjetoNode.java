package pe.com.claro.transversal.dinamico.canonical.comun.ws.bean;
import java.util.LinkedHashMap;

public class ObjetoNode<K,V> {
	
	private LinkedHashMap<K,V> lista;

    public ObjetoNode() {
        this.lista = new LinkedHashMap<K,V>();
    }

    public void add(K item, V item1)
    {
        //this.lista.add(item1);
        lista.put(item, item1);
    }

	public LinkedHashMap<K, V> getLista() {
		return lista;
	}

	public void setLista(LinkedHashMap<K, V> lista) {
		this.lista = lista;
	}

	

    
}
