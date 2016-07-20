  //aqui se definen los vertices (o nodos) del grafo, se importan librerias para el manejo de las listas encadenadas
  import java.util.List;
  import java.util.LinkedList;
  
  
  public class Vertice{
    //declaracion de todas las variables de la clase
    public Object nombre;  //identificador del nombre de cada vertice
    public LinkedList<Arco> lista;  //lista de los adyacentes
	  public double distancia;        //variable usada para los recorridos
	  public Vertice previo;          //variable de tipo vertice que almacena el vertice previo
    public boolean marca;           //variable usada para los recorridos         

  //creador de la clase, inicializacion de todos los atributos pasando unnombre como parametro
  public Vertice(Object s){//metodo creador
    nombre=s;
    marca=false;
    lista=new LinkedList<Arco>();
    previo=null;
	  distancia=Grafo.INFINITY;
  }
    
  }




