import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;


class OrdenCompra{

    private Date fecha;
    private String estado;
    private Cliente cliente;

    private ArrayList<DocTributario> DocsTributarios;
    private ArrayList<Cliente> Clientes;

    public OrdenCompra(String estadoo, Cliente clientee){
        estado=estadoo;
        cliente=clientee;
    }


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
    private Direccion direccion;
    private ArrayList<OrdenCompra> OrdenesDeCompra;
    public Cliente(String nombree,String rutt,Direccion direccionn){
        nombre=nombree;
        RUT=rutt;
        direccion=direccionn;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRUT(){
        return RUT;
    }
    public Direccion getDireccion() {
        return direccion;
    }
}
class Direccion{
    private String direccion;
    private ArrayList<Cliente> Clientes;
    public Direccion(String direccionn){
        direccion=direccionn;
    }

    public String getDireccion() {
        return direccion;
    }
}

class DetalleOrden {
    private int cantidad;

    public int CalcPrecio() {
        return 0;
    }

    public int CalcPrecioSinIVA() {
        return 0;
    }

    public int CalcIVA() {
        return 0;
    }

    public int CalcPeso() {
        return 0;
    }
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float pesoo, String nombree, String descripcionn, float precioo){
        peso=pesoo;
        nombre=nombree;
        descripcion=descripcionn;
        precio=precioo;
    }
    
}

abstract class Pago{
    private float monto;
    private Date fecha;

    public Pago(float montoo){
        monto=montoo;
    }
}
class Efectivo extends Pago{
    public Efectivo(float montoo){
        super(montoo);
    }
    public float calcDevolucion(){return 0;}
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public Transferencia(float montoo,String bancoo,String numCuentaa){
        super(montoo);
        banco=bancoo;
        numCuenta=numCuentaa;
    }

}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(float montoo,String tipoo,String numTransaccionn){
        super(montoo);
        tipo=tipoo;
        numTransaccion=numTransaccionn;
    }

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
    Direccion d1=new Direccion("Lord cochrane");
    Cliente c1=new Cliente("vicente","21093975k",d1);
    System.out.println(c1.getNombre());
    System.out.println(c1.getRUT());
    System.out.println(c1.getDireccion().getDireccion());

    Tarjeta t1=new Tarjeta(12,"credito","1");
    Efectivo e1=new Efectivo(12);
    Transferencia tr1=new Transferencia(12,"BBVA","12");

    }
    
}

