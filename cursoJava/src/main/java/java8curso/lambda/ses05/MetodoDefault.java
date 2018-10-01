package java8curso.lambda.ses05;

public class MetodoDefault implements InterfazA, InterfazB {

    public static void main(String args[]){
        MetodoDefault defaultMethod = new MetodoDefault();
        defaultMethod.hablar();
    }

    @Override
    public void caminar() {
        System.out.print("Hola desde caminar");
    }

    @Override
    public void hablar() {
        //InterfazB.super.hablar();
        System.out.print("Hola desde hablar - overrided");
    }
}
