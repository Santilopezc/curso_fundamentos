
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
}
