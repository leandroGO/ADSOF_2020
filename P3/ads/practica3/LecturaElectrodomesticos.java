package ads.practica3;

import java.io.*;
import java.util.ArrayList;

public class LecturaElectrodomesticos {
    public static ArrayList<Electrodomestico> leer(String fichero) throws IOException {
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
        String l;
        String[] linea;
        int a;

        while ((l = entrada.readLine()) != null) {
            linea = l.split("=");
            a = linea.length;
            switch (a) {
                case 5:
                    electrodomesticos.add(new Television(linea[0], linea[1], Double.parseDouble(linea[2]),
                            ClaseEnergetica.parseClase(linea[3]), Integer.parseInt(linea[4])));
                    break;
                case 9:
                    electrodomesticos.add(new Frigorifico(linea[0], linea[1], Double.parseDouble(linea[2]),
                            ClaseEnergetica.parseClase(linea[3]), new Dimension(Double.parseDouble(linea[4]),
                            Double.parseDouble(linea[5]), Double.parseDouble(linea[6])), Double.parseDouble(linea[7]),
                            linea[8].equals("NoFrost")));
                    break;
                case 10:
                    electrodomesticos.add(new Lavadora(linea[0], linea[1], Double.parseDouble(linea[2]),
                            ClaseEnergetica.parseClase(linea[3]), new Dimension(Double.parseDouble(linea[4]),
                            Double.parseDouble(linea[5]), Double.parseDouble(linea[6])), Double.parseDouble(linea[7]),
                            Double.parseDouble(linea[8]), Integer.parseInt(linea[9])));
                    break;
                default:
                    break;
            }
        }
        return electrodomesticos;
    }
}
