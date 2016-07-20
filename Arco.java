//en esta clase se define los arcos 
public class Arco {
	public Vertice destino; // vertice con el que esta conectado
	public double costo;    // valor del costo del arco
	public boolean visitado;

  //creador de la clase
	public Arco( Vertice d, double c ){
			destino = d;
			costo = c;
			visitado=false;
	}
}
