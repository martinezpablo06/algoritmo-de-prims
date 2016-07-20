
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	static Scanner scanner = new Scanner(System.in);//variable para lectura
	static int opcion = -1; //inicializo opción

public static void main( String [ ] args ){

	while(opcion != 0){ //mientras la opcion no sea 'salir'

		System.out.print("\033[H\033[2J");//limpia pantalla
		System.out.flush();

		try{
			System.out.println("Grafos: ");
			System.out.println(" ");
			System.out.println("1- Ejemplo 1: ");
			System.out.println("2- Ejemplo 2: ");
			System.out.println("3- Ejemplo 3: ");
			System.out.println("0- Salir: ");

			System.out.println(" ");
			opcion = Integer.parseInt(scanner.nextLine()); 

			switch(opcion){
				case 1: 

					System.out.print("\033[H\033[2J");//limpia pantalla
					System.out.flush();
					//crea un grafo nuevo
					Grafo g = new Grafo( );
					System.out.println("Ejemplo 1: ");
					System.out.println(" ");
					//carga valores en el grafo
					g.agregarArco("v1","v2",2);
					g.agregarArco("v2","v5",10);
					g.agregarArco("v5","v7",6);
					g.agregarArco("v7","v6",1);
					g.agregarArco("v6","v3",5);
					g.agregarArco("v3","v1",4);
					g.agregarArco("v4","v1",1);
					g.agregarArco("v4","v2",3);
					g.agregarArco("v4","v3",2);
					g.agregarArco("v4","v5",7);
					g.agregarArco("v4","v6",8);
					g.agregarArco("v4","v7",4);
					//imprime los arcos del grafo y los costos del grafo
					System.out.println("Arco v1,v2,2 ");
					System.out.println("Arco v2,v5,10 ");
					System.out.println("Arco v5,v7,6 ");
					System.out.println("Arco v7,v6,1 ");
					System.out.println("Arco v6,v3,5 ");
					System.out.println("Arco v3,v1,4 ");
					System.out.println("Arco v4,v1,1 ");
					System.out.println("Arco v4,v2,3 ");
					System.out.println("Arco v4,v3,2 ");
					System.out.println("Arco v4,v5,7 ");
					System.out.println("Arco v4,v6,8 ");
					System.out.println("Arco v4,v7,4 ");

					printValores(g);

				break;
				case 2: 

					System.out.print("\033[H\033[2J"); //limpia pantalla
					System.out.flush();
					//crea un grafo nuevo
					Grafo g2 = new Grafo( );
					System.out.println("Ejepmlo 2:  ");
					System.out.println(" ");
					//carga valores en el grafo
					g2.agregarArco("a","b",2);
					g2.agregarArco("a","c",10);
					g2.agregarArco("a","e",6);
					g2.agregarArco("b","d",1);
					g2.agregarArco("b","f",5);
					g2.agregarArco("f","e",4);
					g2.agregarArco("c","g",4);
					//imprime los arcos y los costos del grafo
					System.out.println("Arco a,b,2 ");
					System.out.println("Arco a,c,10 ");
					System.out.println("Arco a,e,6 ");
					System.out.println("Arco b,d,1 ");
					System.out.println("Arco b,f,5 ");
					System.out.println("Arco f,e,4 ");
					System.out.println("Arco c,g,4 ");

					printValores(g2);

				break;
				case 3: 

					System.out.print("\033[H\033[2J"); //limpia pantalla
					System.out.flush();
					//crea un frafo nuevo
					Grafo g3 = new Grafo( );
					System.out.println("Ejepmlo 3:  ");
					System.out.println(" ");
					//carga valores en el grafo
					g3.agregarArco("a","b",4);
					g3.agregarArco("a","c",2);
					g3.agregarArco("c","e",3);
					g3.agregarArco("b","d",10);
					g3.agregarArco("d","f",11);
					g3.agregarArco("e","d",4);		
					//imprime los arcos y costos del grafo
					System.out.println("Arco a,b,4 ");
					System.out.println("Arco a,c,2 ");
					System.out.println("Arco c,e,3 ");
					System.out.println("Arco b,d,10 ");
					System.out.println("Arco d,f,11 ");
					System.out.println("Arco e,d,4 ");

					printValores(g3);

				break;
				case 0:
 
					System.out.print("\033[H\033[2J"); //limpia panalla
					System.out.flush();

				break;
				default:

					System.out.print("Ingrese una opcion valida");
					scanner.nextLine(); //lee una tecla para continuar

				break;
			}
				
			}
			catch(Exception e){
				System.out.println(" ");
				System.out.print("Caracter invalido");
				scanner.nextLine(); //lee una tecla para continuar
			}
		}

	}

	public static void printValores(Grafo x){
		System.out.println(" ");
		System.out.println("cantidad de arcos: " + x.cantArcos());
		System.out.println("cantidad de vertices: " + x.cantVertices());
		System.out.println("cantidad de costos: " + x.cantCostos());

		try{
			String s;  //variable para lectura
			System.out.println(" ");
			System.out.print("Introduzca vertice de inicio: ");
			s = scanner.nextLine(); //lee vertice

			x.setearTodaMarca(s);  //desmarco todos los nodos antes de recorrer
			System.out.println(" ");
			System.out.println("dfsIterativo desde " + s);
			x.dfsIterativo(s);   //imprimo dfs iterativo

			x.setearTodaMarca(s);  //desmarco todos los nodos antes de recorrer
			System.out.println(" ");
			System.out.println("dfsRecursivo desde " + s);
			x.dfsRecursivo(s); //imprimo dfs recursivo
			System.out.println(" ");
      System.out.println("Prims desde: " + s);
      System.out.println(" ");
			x.Prims(s); //imprimo dfs recursivo
			scanner.nextLine();  //lee una tecla para continuar

		}
		catch(Exception j){
			System.out.println(" ");
			System.out.print("Nombre invalido");
			scanner.nextLine(); //lee una tecla para continuar
		}
	}

}

