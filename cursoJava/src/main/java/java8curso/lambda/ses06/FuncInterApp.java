package java8curso.lambda.ses06;

public class FuncInterApp {

    public double operar(double x, double y){
        Operacion op = (n1,n2) -> n1 + n2;
        return op.calcular(x,y);

    }

    public static void main(String args[]){
        FuncInterApp funcInterApp = new FuncInterApp();
        System.out.print(funcInterApp.operar(5d,7d));
    }
}
