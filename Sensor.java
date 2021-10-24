
public class Sensor
{
    public static Sensor[][] sensores;
    private int estado;

    public Sensor(){
       
    }

    public Sensor(int e){
        this.estado = e;
    }

    public void setEstado(int e){
        this.estado = e;
    }

    public int getEstado(){
        return this.estado;
    }

    public String toString(){
        String disponibilidad = "";
        switch(this.estado){
            case 0: disponibilidad = "Libre";
                break;
            case 1: disponibilidad = "Ocupado";
                break;
        }   
        return disponibilidad;
    }

    public static String sensorLibre(){
        String espaciosDisponibles = "";
        for(int i =0; i< Sensor.sensores.length; i ++){
            for(int j = 0; j < Sensor.sensores[i].length; j++){
                if(Sensor.sensores[i][j].toString().equals("Libre")){
                    espaciosDisponibles = espaciosDisponibles +"Piso: ";
                    espaciosDisponibles = espaciosDisponibles + i + "\n" + "Espacio: "  + j + "\n" +sensores[i][j].toString() + "\n";
                }
            }
        }
        return espaciosDisponibles;
    }

    public static String sensoresEstado(){
        String sensor = "";
        for(int i =0; i<Sensor.sensores.length; i ++){
            for(int j = 0; j < Sensor.sensores[i].length; j++){
                sensor = sensor +"Piso: " + i + "\n" + "Espacio: " + j + "\n" + "Estado: " + sensores[i][j].toString() + "\n" + "\n";
            }
        }
        return sensor;

    }
}
