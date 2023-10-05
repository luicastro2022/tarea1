import java.util.Date;

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







public class Main {
    public static void main(String[] args){

    }
    
}

