//declaracion de la clase heap, extiende a a la clase Grafo
public class heap extends Grafo{
  //declaracion de los elementos que usa la clase
  private Vertice arr[];
  private int ultimo;//variable que lleva la ultima posicion
  private int capacidad;//tamaño mximo del arreglo
 
  //creador de la clase
  public heap(int cap) {
      arr = new Vertice [cap + 1];
      ultimo = 0;
      capacidad = cap;
  }
  //devuelve la longitud del arreglo hasta ese momento
  public int longitud() {
      return ultimo;
  }
  //devuelve true si la longitud del arreglo es 0
  public boolean esVacia() {
      return (longitud() == 0);
  }

  //devuelve el vertice que se encuentra al principio
  public Vertice minimo() throws HeapExcepcion {
      if (esVacia())
          throw new HeapExcepcion("El heap esta vacio");//si es vacia tira excepcion
      else
          return  arr[1];
  }

    
  public boolean inHeap( Vertice x ){
		boolean result= false;
		for (Vertice v : arr){
			if (v == x){
				result=true;
				break;
			}
		}
		return(result);
	}

  //toma dos vertices y compara cual de sus vertices tiene el mas cercano con menos costo, devuelve 
  private int compara(Vertice x, Vertice y) {
    double aux = x.distancia;
    double aux2 = y.distancia;
    if (aux>aux2) 
      return (-1);
    if (aux==aux2)
      return (0);
    return (1);
  }
  
  //incerta un elemento al final del arreglo (encola)
  public void insertar(Vertice v) throws HeapExcepcion {
    if (longitud() == capacidad)
        throw new HeapExcepcion("Heap lleno");
    else{
        ultimo++; //incrementa variable que lleva el indice del ultimo
        arr[ultimo] = v;
        moverArriba(); //reacomoda el heap
    }       
  }

  //saca el primer elemento de la cola (desencola), ya qjue es el elemento con mas prioridad
  public Vertice remueveMinimo() throws HeapExcepcion {
      if (esVacia())
          throw new HeapExcepcion("El heap esta vacio");
      else {
          Vertice minimo = minimo();
          arr[1] = arr[ultimo];
          ultimo--;
          moverAbajo();//reacomoda el heap
          return minimo;
      }
  }

  //reacomoda el heap, haciendo intercambios en caso de ser necesario ya que se encolo
  private void moverArriba(){
      int i = longitud();
      while (i > 1){
          int aux = i / 2;
          if (compara(arr[i], arr[aux]) >= 0)
              break;//termina el ciclo si aux es menor o igual al elemento corriente
          swap(i,aux);
          i = aux;
      }       
  }
  
  //comportamiento similar al anterior, reacomoda el heap ya que se desencolo
  private void moverAbajo(){
      int i = 1;
      while (true){
          int aux = i*2;
          if (aux > longitud())
              break;
          if (aux + 1 <= longitud()){
            aux = findminimo(aux, aux + 1);
          }
          if (compara(arr[i],arr[aux]) <= 0 )
              break;
          swap(i,aux);
          i = aux;
      }
  }

  //intercambia dos valores
  private void swap(int i, int j) {
      Vertice v = arr[i];
      arr[i] = arr[j];
      arr[j] = v;
  }

  //determina el minimo entre dos posiciones pasadas como parametro, devuelve la posicion con la menor 
  private int findminimo(int aux1, int aux2) {
       if (compara(arr[aux1],arr[aux2]) <= 0)
          return aux1;
      else
          return aux2;
  }


 

}



