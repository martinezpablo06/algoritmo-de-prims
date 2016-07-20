  //clase grafo, aqui se definen todos los metos para la manipulacion de los vertices y arcos
  import java.util.Map;          //usamos esta bibliotecas por la facilidad y eficiencia para manejo de pares de datos
  import java.util.HashMap;
  import java.util.List;        //usamos esta bibliotecas por la facilidad para manejo de Listas
  import java.util.LinkedList;

  public class Grafo{

    public static final double INFINITY = Double.MAX_VALUE;

    private int cantArco;  //variable que almacena la cantidad de arcos
    private double cantCosto = 0; //variable que almacena el costo total de los arcos
    private Map <Object,Vertice> listaVertices  = new HashMap<Object,Vertice>(); //declaracion del par de datos que utilizaremos para manipular los vertices y arcos. La variable de tipo Object hace alucion al nombre definido en la clase Vertice.
    
    public Grafo(){ //creador del grafo
    }
   
    public boolean esVacia(){//devuelve true si el grafo esta vacio
      return(listaVertices.isEmpty());
    }
      
    public int cantArcos(){//devuelve la cantidad de arcos que hay
      return (this.cantArco);
    }
    
    public double cantCostos(){//devuelve la cantidad de arcos que hay
      return (this.cantCosto);
    }

    public int cantVertices(){//devuelve la cantidad de vertices que hay
      return (listaVertices.size());
    }
        
    public boolean buscarVertice(Object item){//devuelve true si el vertice esta en el grafo
      return(listaVertices.containsKey(item));
    } 
     
    public boolean hayArco(Object x1, Object x2){//devuelve true si el vertice esta en el grafo
      boolean b=false; 
      if (buscarVertice(x1) && buscarVertice(x2)){//x1 es vertice donde buscar el adyacente x2
        Vertice v1=listaVertices.get(x1);//variables auxiliares
        for(Arco a : v1.lista){//uso del for extendido
          Vertice v3=a.destino;
          if(v3.nombre==(x2)){
            b=true;
          }
         }
        return(b);
      }else{
        return(b);
      }
    }
    
   

    
    public double obtenerCosto(Object x1, Object x2) throws GrafoExcepcion{//devuelve el valor de costo ere dos vertices
      if(hayArco(x1,x2)){ 
        Vertice v = listaVertices.get(x1);
        for(Arco a : v.lista){//uso del for extendido
          Vertice v2=a.destino;
          if(v2.nombre==(x2)){
            return(a.costo);
          }
        }
       }
       throw new HeapExcepcion("No hay arco entre los dos Vertices "); 
      }

    public void borrarArco( Object x1, Object x2) throws GrafoExcepcion{//borra un arco entre dos vertices(recordar que manejamos no dirigidos)
      if (hayArco(x1,x2)){    
        Vertice v1 = obtenerVertice(x1);
        Vertice v2 = obtenerVertice(x2);
   			double c = obtenerCosto(x1,x2);
   			int i=0;
			  for(Arco a : v1.lista){//uso del for extendido
          Vertice v3=a.destino;
          if(v3.nombre==(x2)){
            v1.lista.remove(i);
            break;
          }
          i++;
        }
        int j=0;
			  for(Arco a : v2.lista){//uso del for extendido
          Vertice v4=a.destino;
          if(v4.nombre==(x2)){
          
            v2.lista.remove(j);
            break;
          }
          j++;
        }
			  cantArco--;
			  cantCosto=cantCosto-c;
      }else{
        throw new HeapExcepcion("No hay arco entre los dos Vertices, no hay nada que borrar");
      }
    }
     
      
    public void agregarArco( Object x1, Object x2, double c){//agrega un arco entre dos vertices( no dirigidos)
      if (!(hayArco(x1,x2))){
        Vertice v1 = obtenerVertice(x1);//crea el vertice
        Vertice v2 = obtenerVertice(x2);//crea el vertice
        v1.lista.add(new Arco( v2, c));//añade los arcos entre los dos vertices incluyendo el costo
        v2.lista.add(new Arco( v1, c));//añade los arcos entre los dos vertices incluyendo el costo
        cantCosto = cantCosto + c; //aumentamos el contador de la cantidad de costo total
        cantArco++; //como se añadio un arco, sumamos uno al contador
      }
    }

    
    public Vertice obtenerVertice(Object x){//obtiene un vertice segun el nombre que le pasemos como parametro, si no existe lo crea
      Vertice v = listaVertices.get(x);
      if(v == null){
        v = new Vertice(x);
        listaVertices.put(x,v);
      }
      return v;
    }
    
    public void borrarVertice(Object x)throws GrafoExcepcion{//borra un vertice de un grafo
    
    if(buscarVertice(x)){
      Vertice v=listaVertices.get(x);
      for(Arco a : v.lista){ //uso del for extendido para recorrer todos los arcos del vertice
          Vertice corriente=a.destino;  
          borrarArco(corriente.nombre,x);
        } 
      listaVertices.remove(x);//borra completamente el vertice del grafo
      }else {
        throw new HeapExcepcion("No existe el vertice, no hay nada que borrar");
      }
    }
      
    public Vertice noVisitado(Vertice v){ //devuelve el vertice mas cercano que no ha sido marcado
		  for(Arco a : v.lista){//uso del for extendido para recorrer todos los arcos del vertice
        Vertice v2=a.destino;
        if(v2.marca==false){
          return(v2);
        }
      }
      return (null);
    }
    
    public void dfsIterativo(Object x){//recorrido en profundidad iterativo usando la pila
      Pila pilaAdyacentes=new Pila();
      Vertice v1=listaVertices.get(x);
      pilaAdyacentes.push(v1); //mete el primer elementoa la pila
      v1.marca=true;           //y luego se lo marca
      System.out.println(v1.nombre);
      while(!(pilaAdyacentes.esVacia())){  //Mientras que la pila no se acabe
       Vertice v2 = pilaAdyacentes.tope();  //va recorriendo segun el adyacente al nodo en cuestion
       Vertice v3 = noVisitado(v2);         // se le asigna un vertice no visitado
       if (v3!=null){     //mientras no sea null lo marca, lo imprime y lo saca de la pila
         v3.marca=true;
         System.out.println(v3.nombre);
         pilaAdyacentes.push(v3);
       }else{
        pilaAdyacentes.pop();
       }
       }
    }


    public void dfsRecursivo(Object x){//recorrido en profundidad recursivo usando la pila
      Vertice v1=listaVertices.get(x); //crea el vertice
		  v1.marca=true;  //lo marca y luego lo imprime
		  System.out.println(v1.nombre);
		  while(noVisitado(v1)!=null){ 
			  Vertice v2 = noVisitado(v1);  
			  dfsRecursivo(v2.nombre); //hace la llamada recursiva con un elemento no visitado
      }
	  }
    

    public void setearTodaMarca(Object x){//usa la estructura de dfsIterativo
      Pila pilaAdyacentes=new Pila();
      Vertice v1=listaVertices.get(x);
      pilaAdyacentes.push(v1);
      v1.marca=false;
      while(!(pilaAdyacentes.esVacia())){//Mientras que la pila no se acabe
       Vertice v2 = pilaAdyacentes.tope();
       Vertice v3 = noVisitadoMarca(v2);
       if (v3!=null){ //aqui se setean todos los valores de la marca, la distancia y el previo del vertice en cuestion 
         v3.marca=false;
         v3.distancia=INFINITY;
         v3.previo=null;
				  for(Arco a : v3.lista){//seteo todas las visitas de los arcos
					  a.visitado=false;				
				  }
         pilaAdyacentes.push(v3);
       }else{
        pilaAdyacentes.pop();
       }
       }
    }
    
    public Vertice noVisitadoMarca(Vertice v){//sirve para el seteo de toda marca, usa la estructura de noVisitado
      for(Arco a : v.lista){//uso del for extendido
        Vertice v2=a.destino;
        if(v2.marca!=false){
          return(v2);
        }
      }
     return null;
    }
    
				
 
	public void printPrevio(){
			for (Vertice v : listaVertices.values()){
			if (v.previo!=null){
				System.out.println("  Arco desde:  " + v.nombre + " a "+ v.previo.nombre);
				}
		}
  }
	  
	public void Prims( Object startName ){
		setearTodaMarca(startName);
		Vertice start = listaVertices.get( startName ); //vertice de inicio
		Vertice w = null;  //vertices auxiliares
		Vertice v = null;
		heap q = new heap(listaVertices.size()) ;
			for (Vertice vx : listaVertices.values()){
						q.insertar(vx);
		}
		while( !q.esVacia() ){
				v = q.remueveMinimo();
				for( Arco a : v.lista ){  
						w = a.destino;
										if( q.inHeap(w) && w.distancia > a.costo ){
												Vertice wx =	q.remueveMinimo();
												wx.distancia = a.costo;
												wx.previo = v;
												q.insertar(w);
										
									}	 
				}
				
   }
		printPrevio();
}
    
  }//fin de la clase




  








