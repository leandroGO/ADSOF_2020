import java.util.SortedSet;
import java.util.TreeSet;
import java.lang.Math;

/**
 * Esta clase mantiene una caché de números primos, para
 * evitar cálculos repetidos, y calcula si un número es primo.
 * La cache conserva los primos calculados
 * 
 * @author Leandro García y Fabián Gutiérrez
 */
public class Primos {
    // usamos un conjunto ordenado, que implementa TreeSet
    private SortedSet<Integer> primos = new TreeSet<>();
    private int max = 1;

    /**
     *
     * @return cache con los primos calculados
     */
    public SortedSet<Integer> getPrimos(){
        return primos;
    }

    public String toString(){
        return "Primos hasta " + max + " = " + primos;
    }

    /**
     * Determina si n es primo
     * @param n un número entero
     * @return si n es primo
     */
    public boolean esPrimo(int n){
        if (n < 2) {
        	return false;
        }
        if (n > max) {
        	actualizaPrimos(n);
        }
        return primos.contains(n);
    }


    /*
    Completa los métodos actualizaPrimos y compruebaPrimo
     */

    /**
     * Este método llama a compruebaPrimo, y lo añade, si es primo,
     * para todos los números entre max+1 y n. Actualiza max al terminar
     * @param n
     */
    private void actualizaPrimos(int n){
        for (int i = max + 1; i <= n; i++) {
              if (compruebaPrimo(i)) {
                primos.add(i);
              }
        }
        max = n;
    }

    /**
     * Comprueba si n es primo, asumiendo que el conjunto primos
     * está actualizado con todos los anteriores
     * @param n valor a comprobar
     * @return si n es primo
     */
    private boolean compruebaPrimo(int n){
        double root = Math.sqrt((double)n);

        for (int p:primos) {
            if (n%p == 0) {
                return false;
            }
            if (p > root) {
            	break;
            }
        }
        return true;
    }

    /**
     * Halla los divisores primos de n
     * @param n un número entero
     * @return los divisores primos de n
     */
    public SortedSet<Integer> divisoresPrimos(int n){
        SortedSet<Integer> d = new TreeSet<>();

        if (esPrimo(n)) {
            d.add(n);
        }
        else {
            for (int p:primos) {
                if (n%p == 0) {
                    d.add(p);
                }
                if (p >= n/2) {
                    break;
                }
            }
        }
        return d;
    }

    /*
     *  Añade el método main
     */
    public static void main(String[] args){
        
        if (args.length < 1) {
            System.out.println("Se espera al menos un entero positivo como argumento");
        }
        else {
            Primos p = new Primos();
            int n = 0;
            for (String s:args) {
                n = Integer.parseInt(s);
                if (p.esPrimo(n)) {
                    System.out.println("El numero " + s + " es primo");
                }
                else {
                    System.out.println("El numero " + s + " no es primo y tiene divisores primos " + p.divisoresPrimos(n));
                }

                System.out.println(p); //Imprime el estado del conjunto tras cada comprobacion
            }
        }
    }

}
