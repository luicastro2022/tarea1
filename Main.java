import java.util.Date;
import java.util.ArrayList;

class OrdenCompra{

    private Date fecha;
    private String estado;

    public OrdenCompra(){}

    public int calcPrecioSinIVA(){
        return 2;
    }
    public int calcIVA(){return 2;}
    public int calcPrecio(){return 2;}
    public int calcPeso(){return 2;}


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

