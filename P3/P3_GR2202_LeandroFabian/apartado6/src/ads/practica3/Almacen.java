package ads.practica3;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementa un almacen que lleva el registro de los electrodomesticos en stock por tipo y modelo
 *
 * @author Leandro Garcia y Fabian Gutierrez
 */
public class Almacen {
    private static final Map<String, Map<String, Integer>> catalogo = new HashMap<>();

    /**
     * Agrega un electrodomestico al almacen
     * @param tipo el tipo de electrodomestico (Television, Frigorifico...)
     * @param modelo el modelo del electrodomestico
     */
    public static void add(String tipo, String modelo) {
        if (catalogo.containsKey(tipo)) {
            if (catalogo.get(tipo).containsKey(modelo)) {
                catalogo.get(tipo).put(modelo, catalogo.get(tipo).get(modelo) + 1);
            } else {
                catalogo.get(tipo).put(modelo, 1);
            }
        } else {
            catalogo.put(tipo, new HashMap<>());
            catalogo.get(tipo).put(modelo, 1);
        }
    }

    /**
     * Extrae un electrodomestico del almacen
     * @param tipo el tipo de electrodomestico (Television, Frigorifico...)
     * @param modelo el modelo del electrodomestico
     * @return si pudo realizarse con exito la extraccion
     */
    public static boolean extract(String tipo, String modelo) {
        if (!catalogo.containsKey(tipo) ||
            !catalogo.get(tipo).containsKey(modelo) ||
            (catalogo.get(tipo).get(modelo) == 0)) {
            return false;
        }
        catalogo.get(tipo).put(modelo, catalogo.get(tipo).get(modelo) - 1);
        return true;
    }

    /**
     * Elimina un modelo del almacen
     * @param tipo el tipo de electrodomestico (Television, Frigorifico...)
     * @param modelo el modelo a eliminar
     */
    public static void remove(String tipo, String modelo) {
        if (catalogo.containsKey(tipo)) {
            catalogo.get(tipo).remove(modelo);
        }
    }

    /**
     * Imprime el estado actual del inventario
     * @return la lista de modelos por tipo con su frecuencia
     */
    public static String getStock() {
        return catalogo.toString();
    }

    /**
     * Imprime el inventario de los electrodomesticos de un tipo
     * @param tipo el tipo de electrodomestico (Television, Frigorifico...)
     * @return la lista de modelos del tipo dado con su frecuencia
     */
    public static String getStock(String tipo) {
        if (!catalogo.containsKey(tipo)) {
            return "Error";
        }
        return tipo + catalogo.get(tipo).toString();
    }
}
