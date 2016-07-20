  //clase para el manejo de la pila utilizando listas encadenadas(se hace uso de las librerias que se importan para tal fin)
  import java.util.LinkedList;
  import java.util.List;

  public class Pila{


    private LinkedList<Vertice> pila; //se declara la lista encadenada de Vertices
    
    //creadora de la clase
    public Pila(){
	    pila = new LinkedList<Vertice>();
    }
    
    //pregunta si es vacia la pila
    public boolean esVacia(){  
	    return (pila.isEmpty()); 
    }

    //vacia la pila
    public void Vaciar(){ 
	    pila.clear(); 
    }

    //mete un vertice a la pila
    public void push( Vertice x ){
      pila.addFirst(x);
    }

    //borra el primer vertice de la pila
    public void pop(){
	    pila.removeFirst();
    }

    //devuelve el ultimo vertice incertado
    public Vertice tope(){
	    return (pila.getFirst());
    }

  }
