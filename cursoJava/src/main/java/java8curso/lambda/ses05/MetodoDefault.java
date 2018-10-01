package java8curso.lambda.ses05;

public class MetodoDefault implements Interfaz{

    public static void main(String args[]){
        MetodoDefault defaultMethod = new MetodoDefault();
        defaultMethod.hablar();
    }

    @Override
    public void caminar() {
        System.out.print("Hola desde caminar");
    }
}
