package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Para comenzar dime tu nombre: ");
        String nombreUsuario = lector.readLine();

        int cantidadComunas;
        do {
            System.out.println("Hola "+nombreUsuario+", indica la cantidad de comunas que podrá almacenar el sistema: ");
            cantidadComunas = Integer.parseInt(lector.readLine());
        }while(cantidadComunas<=0);

        int comunas[]= new int[cantidadComunas];


        comunas[0]=684;
        comunas[1]=121;
        comunas[2]=1684;
        comunas[3]=667;
        comunas[4]=1920;


        /*PREGUNTA 2*/
        int numeroComunaGanadora=-1;
        int mayorCantidadVacunas=comunas[0];

        for(int i=0; i<comunas.length; i++)
        {
            if(numeroComunaGanadora==-1 || comunas[i]>mayorCantidadVacunas)
            {
                numeroComunaGanadora=i;
                mayorCantidadVacunas=comunas[i];
            }
        }

        System.out.println("La comuna con más vacunas suministradas es: "+(numeroComunaGanadora+1)+", con una cantidad suministrada de: "+mayorCantidadVacunas);


        /*PREGUNTA 3*/
        int sumaVacunas=0;
        for(int i=0; i<comunas.length; i++)
            sumaVacunas+=comunas[i];

        double promedioVacunacion=sumaVacunas/comunas.length;

        int cantidadComunasBajoPromedio=0;
        for(int i=0; i<comunas.length; i++)
        {
            if(comunas[i]<promedioVacunacion)
                cantidadComunasBajoPromedio++;
        }

        System.out.println(cantidadComunasBajoPromedio+" comunas vacunan bajo el promedio.");


        for(int i=0; i<comunas.length; i++)
            System.out.print("["+comunas[i]+"]");
    }
}
