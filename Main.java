import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;


class OrdenCompra{
    private Date fecha;
    private String estado;
    private Cliente cliente;

    private ArrayList<DetalleOrden> detalles;

    public OrdenCompra(String estadoo, Cliente clientee){
        estado=estadoo;
        cliente=clientee;
        detalles=new ArrayList<>();
    }

    public void agregardetalles(DetalleOrden detalleordenn){
        detalles.add(detalleordenn);
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
    private float peso;
    private float precio;
    private float precioT;
    private int cantidad;
    private Articulo articulo;
    public DetalleOrden(int cantidadd,Articulo articuloo){
        cantidad=cantidadd;
        articulo=articuloo;
        peso=articulo.getPeso();
    }
    public float CalcIVA() {
        return precioT*19/100;
    }
    public float CalcPrecio() {
        return (precio*cantidad)+precioT*19/100;
    }
    public float CalcPrecioSinIVA() {
        return precio*cantidad;
    }
    public float CalcPeso() {
        return peso*cantidad;
    }
}

class Deposito{
    private Articulo A;
    private ArrayList<Articulo> articulos;
    public Deposito(){articulos=new ArrayList<>();}
    public void addArticulo(Articulo articulo){
        articulos.add(articulo);
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
    public float getPeso() {return peso;}
    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public float getPrecio() {return precio;}
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

    Articulo cocacola=new Articulo(500,"cocacola","lata de bebida 200ml",1000);
    Articulo papaslays=new Articulo(200,"papas lays","bolsa de papas 200g",1500);

    DetalleOrden detalle1=new DetalleOrden(2,cocacola);

    OrdenCompra orden1=new OrdenCompra("pendiente",c1);

    orden1.agregardetalles(detalle1);
    
    }
    
}

