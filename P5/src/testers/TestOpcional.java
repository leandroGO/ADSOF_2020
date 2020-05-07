package testers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import rules.*;

public class TestOpcional {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Producto p1 = new Producto(10, sdf.parse("15/04/2020")); // “similar” a la clase Producto del apartado 2
        TriggeredRule.<Producto>trigRule("r1").
                trigger(p1, "precio").
                when(pro -> Producto.getDateDiff(Calendar.getInstance().getTime(), pro.getCaducidad(), TimeUnit.DAYS) < 2 ).
                exec(pro -> { System.out.println("Ojo! cambias el precio de un producto próximo a caducar"); });
        p1.setPrecio(17);
    }
}
