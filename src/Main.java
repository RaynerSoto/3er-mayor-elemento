import java.util.*;

public class Main {
    public static void main(String[] args) {
        int valores[] = {15,15,50,87,88,43,96,20,6,8,9,6,8,9,6,8};
        ejemplo2(valores);
    }

    public static void ejemplo1(){
        Queue<Integer> valores = new LinkedList<Integer>(Arrays.asList(1, 3, 4,50, 52, 1, 3, 2, 55, 4, 27,68));
        int respuesta;
        if (valores.size() == 0)
            System.out.println("Cantidad de valores no procesables");
        else {
            int contador = 0;
            Queue<Integer> respaldo = new LinkedList<>();
            do {
                respaldo.addAll(valores);
                respuesta = max(respaldo.poll(), respaldo);
                valores.remove(respuesta);
                contador++;
            } while (contador != 3);
            System.out.println("El tercer mayor elemento es: " + respuesta);
        }

    }

    public static void ejemplo2(int ...args){
        int max = -5;
        for (int i = 0; i < 3; i++) {
            max = max(args[0],Arrays.copyOfRange(args,1,args.length));
            if (i!= 2)
                remove(max,args);
            else {
                break;
            }
        }
        System.out.println("El tercar mayor elemento es: "+max);
    }

    public static int max(int pivote, Queue<Integer> elementos) {
        try {
            return Math.max(pivote,max(elementos.poll(),elementos));
        } catch (Exception e) {
            return pivote;
        }
    }

    public static int max(int pivote, int ...elementos) {
        try {
            return Math.max(pivote,max(elementos[0],Arrays.copyOfRange(elementos, 1, elementos.length)));
        } catch (Exception e) {
            return pivote;
        }
    }

    public static void remove(int elemento, int ...args){
        boolean encontrado = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i] == elemento && !encontrado) {
                encontrado = true;
            }
            else if (encontrado) {
                args[i-1] = args[i];
            }
        }
    }
}