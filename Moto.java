import java.util.Date;

public class Moto extends Vehiculo
{
    public static int valorHora;
    private String tipoVehiculo = "Moto";

    public Moto (String p , String m, String c){
        super(p, m, c);
    }

    public Moto (String p , String m, String c, int v){
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
    public void sacarVehiculo(){
        Date salida = new Date();
        int tiempoFaltante = 60 - salida.getMinutes();
        int valorParqueadero = this.valorHora * (salida.getHours() - this.getHora());
        valorParqueadero = valorParqueadero + ((this.valorHora/60)*((60-this.getMinuto())+(60-tiempoFaltante)));
        int minutosParqueadero = 0;
        int horasParqueadero = salida.getHours() - this.getHora();
        if(salida.getMinutes() >= this.getMinuto()){
            minutosParqueadero = salida.getMinutes() - this.getMinuto();
        }

        else{
            minutosParqueadero = salida.getMinutes() + (60 - this.getMinuto());
        }
        int valorCobro = (this.valorHora * horasParqueadero) + ((this.valorHora/60) * minutosParqueadero);
        String cobro = "Tiempo en el parqueadero: " + "\n";
        cobro = cobro + "Horas: " + horasParqueadero + "\n";
        cobro = cobro + "Minutos: " + minutosParqueadero + "\n";
        cobro = cobro + "Valor a cobrar: " + valorCobro;
        System.out.println(cobro);

    }
}
