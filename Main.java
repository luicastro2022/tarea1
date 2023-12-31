import java.lang.reflect.Array;
import java.util.Date;
import java.util.ArrayList;

class OrdenCompra {
    private Date fecha;
    private String estado;
    private Cliente cliente;
    private ArrayList<DetalleOrden> detalles;


    public OrdenCompra(String estadoo, Cliente clientee, Date fechaa) {
        estado = estadoo;
        cliente = clientee;
        detalles = new ArrayList<>();
        fecha=fechaa;
    }
    public void agregardetalles(DetalleOrden detalleordenn) {
        detalles.add(detalleordenn);
    }


    public float calcPrecioSinIVA() {
        float aux = 0;
        for (int i = 0; i < detalles.size(); i++) {
            aux = aux + detalles.get(i).CalcPrecioSinIVA();
        }
        return aux;
    }
    public float calcIVA() {
        float aux = 0;
        for (int i = 0; i < detalles.size(); i++) {
            aux = aux + detalles.get(i).CalcIVA();
        }
        return aux;
    }
    public float calcPrecio() {
        float aux = 0;
        for (int i = 0; i < detalles.size(); i++) {
            aux = aux + detalles.get(i).CalcPrecio();
        }
        return aux;
    }
    public float calcPeso() {
        float aux = 0;
        for (int i = 0; i < detalles.size(); i++) {
            aux = aux + detalles.get(i).CalcPeso();
        }
        return aux;
    }

    public String toString() {
        return "Orden:" + this.estado + "\n" + this.cliente;
    }
    public Date getDate(){return fecha;}
    public String getEstado(){return estado;}
    public Cliente getCliente(){return cliente;}
    public String getdetalles(){
        return detalles.toString();
    }

    public void CrearDoc(){

    }
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
    public String getOrdenes(){return OrdenesDeCompra.toString();}
    public String toString(){
        return "cliente"+this.nombre+this.RUT+this.direccion.toString();
    }
}
class Direccion{
    private String direccion;
    private ArrayList<Cliente> Clientes;
    public Direccion(String direccionn){
        direccion=direccionn;
    }

    public String getDireccion() {return direccion;}
    public String getClientes(){return Clientes.toString();}
    public String toString(){
        return "direccion"+this.direccion;
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
        precioT=articulo.getPrecio()*cantidad;
        precio=articuloo.getPrecio();
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

    public float getPeso() {return peso;}
    public float getPrecio() {return precio;}
    public float getPrecioT() {return precioT;}
    public int getCantidad() {return cantidad;}
    public Articulo getArticulo(){return articulo;}

    public String toString(){return "Detalle Orden:"+this.cantidad+"\n"+this.articulo;}

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

    public String toString(){return "Articulo:\n"+this.nombre+"\n"+this.peso+"\n"+this.precio+"\n"+this.descripcion;}

}

abstract class Pago{
    private float monto;
    private Date fecha;

    public Pago(float montoo){
        monto=montoo;
    }
}
class Efectivo extends Pago{
    float abono;
    float monto;
    public Efectivo(float montoo,float abonoo){
        super(montoo);
        monto=montoo;
        abono=abonoo;
    }
    public float calcDevolucion(){
        return abono-monto;
    }

    public float getAbono() {return abono;}
    public float getMonto() {return monto;}
    public String toString(){return "Pago:\n"+"Deuda: "+this.monto+"\n"+"Abono: "+this.abono;}
}
class Transferencia extends Pago{
    private float monto;
    private String banco;
    private String numCuenta;
    public Transferencia(float montoo,String bancoo,String numCuentaa){
        super(montoo);
        monto=montoo;
        banco=bancoo;
        numCuenta=numCuentaa;
    }

    public String getBanco() {return banco;}
    public String getNumCuenta(){return numCuenta;}
    public String toString(){return "Transeferencia:"+"\n"+"Deuda: "+this.monto+"\n"+"Banco: "+this.banco+"\n"+"Numero de cuenta: "+this.numCuenta;}

}
class Tarjeta extends Pago{
    private float monto;
    private String tipo;
    private String numTransaccion;
    public Tarjeta(float montoo,String tipoo,String numTransaccionn){
        super(montoo);
        tipo=tipoo;
        numTransaccion=numTransaccionn;
    }

    public float getMonto() {return monto;}
    public String getTipo() {return tipo;}
    public String getNumTransaccion() {return numTransaccion;}

    public String toString(){return "Operacion con tarjeta:\n"+"Deuda: "+this.monto+"\n"+"Tipo de tarjeta: "+this.tipo+"\n"+"Numero de transaccion: "+this.numTransaccion;}
}


abstract class DocTributario {
        private String rut;
        private Date fecha;
        private String direccion;

        public DocTributario(String rutt, Date fechaa, String direccionn) {
            rut = rutt;
            fecha = fechaa;
            direccion = direccionn;
        }
        public String getRut(){return rut;}
        public Date getFecha(){return fecha;}
        public String getDireccion(){return direccion;}
}

class Boleta extends DocTributario {
    public Boleta(String rut, Date fecha, String direccion) {
        super(rut, fecha, direccion);
    }
}
class Factura extends DocTributario {
    public Factura(String rutt, Date fechaa, String direccionn) {
        super(rutt, fechaa, direccionn);
    }

public class Main {
    public static void main(String[] args){

    Direccion d1=new Direccion("Lord cochrane");
    Cliente c1=new Cliente("vicente","21093975k",d1);

    Direccion d2=new Direccion("Barros Arana");
    Cliente c2=new Cliente("luis","213311107",d2);

    Date fechaorden1= new Date(2023-15-10);
    Date fechaorden2= new Date(2023-17-10);

    Articulo cocacola=new Articulo(400,"cocacola","lata de bebida 400ml",1000);
    Articulo papaslays=new Articulo(200,"papas lays","bolsa de papas 200g",1500);
    Articulo chokita=new Articulo(30, "chokita", "barra de chocolate 30g", 300);
    Articulo chicle=new Articulo(10, "chicle", "goma de mascar 10g", 50);
    Articulo gomitas=new Articulo(100, "gomitas", "gomas dulces 100g", 250);

    DetalleOrden detalle1=new DetalleOrden(2,cocacola);
    DetalleOrden detalle2=new DetalleOrden(1,papaslays);
    DetalleOrden detalle3=new DetalleOrden(4,chokita);
    DetalleOrden detalle4=new DetalleOrden(7,chicle);
    DetalleOrden detalle5=new DetalleOrden(3,gomitas);
    DetalleOrden detalle6=new DetalleOrden(1,cocacola);
    DetalleOrden detalle7=new DetalleOrden(3,papaslays);
    DetalleOrden detalle8=new DetalleOrden(2,gomitas);

    OrdenCompra orden1=new OrdenCompra("pendiente",c1, fechaorden1);
    orden1.agregardetalles(detalle1);
    orden1.agregardetalles(detalle2);
    orden1.agregardetalles(detalle3);
    orden1.agregardetalles(detalle4);
    orden1.agregardetalles(detalle5);

    OrdenCompra orden2=new OrdenCompra("pendiente",c2, fechaorden2);
    orden2.agregardetalles(detalle6);
    orden2.agregardetalles(detalle7);
    orden2.agregardetalles(detalle8);
    orden2.agregardetalles(detalle4);

    Efectivo pagoorden1=new Efectivo(orden1.calcPrecio(),1000);
    Efectivo pagoorden1=new Efectivo(orden1.calcPrecio(),500);
    Tarjeta pagoorden1=new Tarjeta(orden1.calcPrecio(), "Debito", "13225");
    Transferencia pagoorden2=new Transferencia(orden2.calcPrecio(), "Banco estado", "21331110");

    }
    
}

