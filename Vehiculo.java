import java.util.Date;

public class Vehiculo
{
    public static Vehiculo[][] vehiculos; 
    public static int tamano;
    public static int cantidad = 0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    private Date fecha;
    private int minEntrada;
    private int horaEntrada;

    public Vehiculo(){}

    public Vehiculo(String p , String m, String c){
        this(p, m, c, 30000);
    }

    public Vehiculo(String p, String m, String c, int v){
        this.placa = p;
        this.marca = m;
        this.color = c;
        this.valorComercial = v;
        fecha = new Date();
        //this.minEntrada = fecha.getMinutes();
        //this.horaEntrada = fecha.getHours();
        Vehiculo.cantidad = Vehiculo.cantidad + 1;
    }

    public String toString(){
        String marca = this.marca;
        String placa = this.placa;
        String color = this.color;
        int valor = this.valorComercial;
        
        String info = "Placa: " + placa + "\n" + "Marca: " + marca+ "\n" + "Color: " + color + "\n" + "Valor: " + valor + "\n";
        return info;
    }    

    public static String toStringVehiculos(){
        String informacion = "";
        for(int i =0; i< Vehiculo.vehiculos.length; i ++){
            for(int j = 0; j <Vehiculo.vehiculos[i].length; j++){
                if(vehiculos[i][j]!= null){
                    informacion = informacion + vehiculos[i][j].toString() + "\n";
                }
            }
        }

        return informacion;
    }

    public static String ordenarPorValor(Vehiculo[][] original){
        original = vehiculos;
        Vehiculo[] ordenado = new Vehiculo[cantidad];
        int cont = 0;
        Vehiculo temp;
        String valoresOrdenados = "";
        for(int i =0; i<original.length; i ++){
            for(int j = 0; j < original[i].length; j++){
                if(vehiculos[i][j]!= null){
                    ordenado[cont] = original[i][j];
                    cont ++;
                }
            }
        }
        for(int i =0; i<ordenado.length; i ++){
            for(int j = i + 1; j < ordenado.length; j++){
                if(ordenado[i].getValor() > ordenado[j].getValor()){
                    temp = ordenado[i];
                    ordenado[i] = ordenado[j];
                    ordenado[j] = temp;
                }
            }
        }
        cont = 0;
        for(cont =0; cont<ordenado.length; cont ++){

            if(ordenado[cont] != null){
                
                valoresOrdenados = valoresOrdenados + ordenado[cont].toString() + "\n";
            }

        }

        return valoresOrdenados;
    }
    
    public String sacarVehiculo(){
        return "";
    }
    
    public static int cantidadVehiculos(){
        int cantidad = Vehiculo.cantidad;

        return cantidad;
    }

    public Date getFecha(){
    return this.fecha;
    }
    
    public int getMinuto(){
    return this.fecha.getMinutes() * 60;
    }
    
    public int getHora(){
    return this.fecha.getHours() * 3600;
    }
    
    public void setPlaca(String p){
        this.placa = p;
    }

    public String getPlaca(){
        return this.placa;
    }

    public void setMarca(String m){
        this.marca = m;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setColor(String c){
        this.color = c;
    }

    public String getColor(){
        return this.color;
    }

    public void setValor(int v){
        this.valorComercial = v;
    }

    public int getValor(){
        return this.valorComercial;
    }
}
