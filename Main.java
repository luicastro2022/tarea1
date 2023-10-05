import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;

class OrdenCompra{

    private Date fecha;
    private String estado;
    private ArrayList<Pago> Pagos;
    private ArrayList<DocTributario> DocsTributarios;
    private ArrayList<Cliente> Clientes;

    public OrdenCompra(){}

    public int calcPrecioSinIVA(){
        return 2;
    }
    public int calcIVA(){return 2;}
    public int calcPrecio(){return 2;}
    public int calcPeso(){return 2;}


}

class Cliente{
    private String nombre;
    private String RUT;
}



class Pago{
    private float monto;
    private Date fecha;

    public Pago(){}
}
class Efectivo extends Pago{
    public Efectivo(){}
    public float calcDevolucion(){return 0;}
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;

}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;

}

class DocTributario{
    private String numero;
    private String RUT;
    private Date fecha;
    private DocTributario docTributario;

    public DocTributario(){}
}
class Boleta extends DocTributario{
    public Boleta(){}
}
class Factura extends DocTributario{
    public Factura(){}
}







public class Main {
    public static void main(String[] args){

    }
    
}

