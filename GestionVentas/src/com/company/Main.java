package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int cantidadVentas=5;

        int ventas[]=new int[cantidadVentas];

        /*PREGUNTA 1*/
        for(int i=0; i<ventas.length; i++)
        {
            int montoVenta;
            do {
                System.out.println("Ingrese monto de venta del día");
                montoVenta=Integer.parseInt(lector.readLine());
            }while(montoVenta<0);
            ventas[i]=montoVenta;
        }

        /*PREGUNTA 2*/
        int ventasMayor=ventas[0];
        int posicionMayor=0;

        for(int i=0; i<ventas.length; i++)
        {
            if(ventas[i]>ventasMayor)
            {
                ventasMayor=ventas[i];
                posicionMayor=i;
            }
        }

        System.out.println("El día que tiene el mayor monto en ventas es el día: "+(posicionMayor+1));

        /*PREGUNTA 3*/
        int sumaVentas=0;
        for(int i=0; i<ventas.length; i++)
        {

            sumaVentas=sumaVentas+ventas[i];
        }

        double promedio= sumaVentas/ventas.length;
        System.out.println("El promedio de ventas es: $"+promedio);

        /*PREGUNTA 4*/
        int contadorDias=0;
        for(int i=0; i<ventas.length; i++)
        {
            if(ventas[i]<promedio)
            {
                contadorDias++;  // contadorDias= contadorDias+1;
            }
        }

        System.out.println("En total "+contadorDias+" días se vendió menos que el promedio.");

    }
}
