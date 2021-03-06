import java.util.Date;
public class Carro extends Vehiculo
{
    public static int valorHora;
    private String tipoVehiculo = "Carro";

    public Carro (String p , String m, String c){
        super(p, m, c);
    }

    public Carro (String p , String m, String c, int v){
        super(p, m, c, v);
    }

    public String tipoVehiculo(){
        return this.tipoVehiculo;
    }

    @Override
    public String toString(){
        String marca = this.getMarca();
        String placa = this.getPlaca();
        String color = this.getColor();
        int valor = this.getValor();
        String tipo = this.tipoVehiculo;

        String info = "Placa: " + placa + "\n" + "Marca: " + marca+ "\n" + "Color: " + color + "\n" + "Valor: " + valor + "\n";
        info = info + "Tipo de Vehiculo: " + tipo + "\n" + "Hora de Ingreso: " + this.getFecha() + "\n";

        return info;
    }

    @Override
    public String sacarVehiculo(){
        
        Date salida = new Date();
        int horaSalida = salida.getHours() * 3600;
        int minutoSalida = salida.getMinutes() * 60;
        int tiempoSalida = horaSalida + minutoSalida;
        int tiempoEntrada = this.getHora() + this.getMinuto();
        int tiempoParqueo = tiempoSalida - tiempoEntrada;
        int precioParqueadero = (tiempoParqueo/60) * (valorHora/60);
        
        String cobro = "Valor a cobrar: " + precioParqueadero + "\n";
        return cobro;
    }

}
