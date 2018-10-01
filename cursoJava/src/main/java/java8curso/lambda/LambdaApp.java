package java8curso.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaApp {

	public void ordenar(){
		List<String> lista = new ArrayList();
		lista.add("MitoCode");
		lista.add("Code");
		lista.add("Mito");
		
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
//		Collections.sort(lista, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
		
		for(String elemento:lista){
			System.out.println(elemento);
		}
	}
	
	public void calcular(){
		/*Operacion operacion = new Operacion() {
			
			@Override
			public double calcular(double n1, double n2) {
				return (n1+n2)/2;
			}
		};*/
		Operation operation = (double x, double y) -> (x+y)/2;
		System.out.println(operation.calcular(5, 2));
	}
	
	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		//app.ordenar();
		app.calcular();
	}

}
