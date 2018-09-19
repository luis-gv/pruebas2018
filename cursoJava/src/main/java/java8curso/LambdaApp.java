package java8curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaApp {

	public void ordenar(){
		List<String> lista = new ArrayList();
		lista.add("MitoCode");
		lista.add("Code");
		lista.add("Mito");
		
		Collections.sort(lista, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		for(String elemento:lista){
			System.out.println(elemento);
		}
	}
	
	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		app.ordenar();
	}

}
