import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Principal
{
    public static void main(String[]args) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de pisos: ");
        int pisos = scan.nextInt();

        System.out.print("Ingrese la cantidad de espacios: ");
        int espacios = scan.nextInt();

        System.out.print("Ingrese el valor de la hora para carros: ");
        Carro.valorHora = scan.nextInt();

        System.out.print("Ingrese el valor de la hora para motos: ");
        Moto.valorHora = scan.nextInt();

        Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
        Sensor.sensores = new Sensor[pisos][espacios];
        Vehiculo.tamano = pisos * espacios;
        for(int i =0; i<Sensor.sensores.length; i ++){
            for(int j = 0; j < Sensor.sensores[i].length; j++){
                Sensor sensor = new Sensor(0);
                Sensor.sensores[i][j] = sensor;
            }
        }
        System.out.println("Que desea hacer: ");
        System.out.println("0: Salir");
        System.out.println("1: Imprimir los sensores desocupados");
        System.out.println("2: Ingresar un vehiculo en el parqueado");
        System.out.println("3: Ingresar un vehiculo en el parqueado con valor");
        System.out.println("4: Mostrar la informacion de todos los vehiculos");
        System.out.println("5: Mostrar la cantidad de vehiculos");
        System.out.println("6: Revisar la disponibilidad de un parqueadero");
        System.out.println("7: Mostrar la disponibilidad de todos los parqueaderos");
        System.out.println("8: Mostrar todos los carros de un color");
        System.out.println("9: Mostrar los vehiculos ordenados por valor comercial");
        System.out.println("10: Sacar vehiculo del parqueadero");
        System.out.println("11: Crear un archivo con la informacion de los vehiculos");
        int accion = scan.nextInt();
        while(accion != 0){
            switch(accion){
                case 0:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    System.out.println("En que piso desea parquear ");
                    int piso = scan.nextInt() - 1;
                    System.out.println("En que espacio desea parquear ");
                    int espacio = scan.nextInt() - 1;
                    if(Vehiculo.vehiculos[piso][espacio] != null){
                        System.out.println("No se puede realizar la accion");
                    }
                    else {

                        System.out.println("Ingrese la placa");
                        String placa = scan.next();
                        System.out.println("Ingrese la marca");
                        String marca = scan.next();
                        System.out.println("Ingrese el color");
                        String color = scan.next();
                        System.out.println("Ingrese el tipo de Vehiculo");
                        String tipo = scan.next();
                        if(tipo.equalsIgnoreCase("Carro")){
                            Carro c1 = new Carro(placa, marca, color);
                            Vehiculo.vehiculos[piso][espacio] = c1;
                            Sensor.sensores[piso][espacio].setEstado(1);
                        }

                        else if(tipo.equalsIgnoreCase("Moto")){
                            Moto m1 = new Moto(placa, marca, color);
                            Vehiculo.vehiculos[piso][espacio] = m1;
                            Sensor.sensores[piso][espacio].setEstado(1);
                        }
                    }
                    break;

                case 3:
                    System.out.println("En que piso desea parquear ");
                    piso = scan.nextInt() - 1;
                    System.out.println("En que espacio parquear ");
                    espacio = scan.nextInt() - 1;
                    if(Vehiculo.vehiculos[piso][espacio] != null){
                        System.out.println("No se puede realizar la accion");
                    }
                    else {

                        System.out.println("Ingrese la placa");
                        String placa = scan.next();
                        System.out.println("Ingrese la marca");
                        String marca = scan.next();
                        System.out.println("Ingrese el color");
                        String color = scan.next();
                        System.out.println("Ingrese el valor del vehiculo");
                        int valor = scan.nextInt();
                        System.out.println("Ingrese el tipo de Vehiculo");
                        String tipo = scan.next();
                        if(tipo.equalsIgnoreCase("Carro")){
                            Carro c1 = new Carro(placa, marca, color, valor);
                            Vehiculo.vehiculos[piso][espacio] = c1;
                            Sensor.sensores[piso][espacio].setEstado(1);
                        }

                        else if(tipo.equalsIgnoreCase("Moto")){
                            Moto m1 = new Moto(placa, marca, color, valor);
                            Vehiculo.vehiculos[piso][espacio] = m1;
                            Sensor.sensores[piso][espacio].setEstado(1);
                        }
                    }
                    break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 5:
                    System.out.println("Cantidad de vehiculos: " + Vehiculo.cantidadVehiculos() );
                    break;
                case 6:
                    System.out.println("Ingrese el piso ");
                    piso = scan.nextInt() - 1;
                    System.out.println("Ingrese el espacio ");
                    espacio = scan.nextInt() - 1;
                    System.out.println(Sensor.sensores[piso][espacio].toString() + "\n");
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;
                case 8:
                    System.out.println("Ingrese un color: ");
                    String color = scan.next();
                    String carrosColor = "";
                    boolean vehiculoColor = false;
                    for(int i =0; i<Sensor.sensores.length; i ++){
                        for(int j = 0; j < Sensor.sensores[i].length; j++){
                            if((Vehiculo.vehiculos[i][j]!= null) && (Vehiculo.vehiculos[i][j].getColor().equalsIgnoreCase(color))){
                                carrosColor = carrosColor + Vehiculo.vehiculos[i][j].toString() + "\n"; 
                                vehiculoColor = true;
                            }
                        }
                    }
                    if(vehiculoColor == false){
                        System.out.println("No hay vehiculos de ese color");
                    }

                    System.out.println(carrosColor);
                    break;
                case 9:
                    System.out.println(Vehiculo.ordenarPorValor(Vehiculo.vehiculos));
                    break;
                case 10:
                    System.out.println("En que piso esta el vehiculo: ");
                    piso = scan.nextInt() - 1;
                    System.out.println("En que espacio esta el vehiculo: ");
                    espacio = scan.nextInt() - 1;
                    if(Vehiculo.vehiculos[piso][espacio] != null){
                        System.out.println(Vehiculo.vehiculos[piso][espacio].sacarVehiculo());
                        Vehiculo.vehiculos[piso][espacio] = null;
                        Sensor.sensores[piso][espacio].setEstado(0);
                    }
                    else{
                        System.out.println("No hay un vehiculo en ese espacio");
                    }

                    //Date salida = new Date();

                    break;
                case 11:
                    FileWriter archivo = new FileWriter("D:/Santi/Universidad/2021 - 2/Fundamentos de Programacion/Proyecto/texto.txt"); 
                    //D:/Santi/Universidad/2021 - 2/Fundamentos de Programacion/Proyecto/texto.txt
                    archivo.write(Vehiculo.toStringVehiculos());
                    archivo.close();
                    break;

                default:
                    System.out.println("Comando Incorrecto");

            }
            System.out.println("Que desea hacer: ");
            System.out.println("0: Salir");
            System.out.println("1: Imprimir los sensores desocupados");
            System.out.println("2: Ingresar un vehiculo en el parqueado");
            System.out.println("3: Ingresar un vehiculo en el parqueado con valor");
            System.out.println("4: Mostrar la informacion de todos los vehiculos");
            System.out.println("5: Mostrar la cantidad de vehiculos");
            System.out.println("6: Revisar la disponibilidad de un parqueadero");
            System.out.println("7: Mostrar la disponibilidad de todos los parqueaderos");
            System.out.println("8: Mostrar todos los carros de un color");
            System.out.println("9: Mostrar los vehiculos ordenados por valor comercial");
            System.out.println("10: Sacar vehiculo del parqueadero");
            System.out.println("11: Crear un archivo con la informacion de los vehiculos");
            accion = scan.nextInt();
        }
        System.out.println("Saliendo");
    }
}
