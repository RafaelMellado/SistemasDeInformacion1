package registroempresas;
import java.io.*;

public class RegistroEmpresas 
{
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));

        int gastos[], cantidadEmpresas;
        
        do
        {
            System.out.println("Ingrese la cantidad de empresas que desea manejar como maximo:");
            cantidadEmpresas=Integer.parseInt(lector.readLine());
        }while(cantidadEmpresas<=0);
        
        gastos=new int[cantidadEmpresas];
        String empresas[]=new String[cantidadEmpresas];
        
        int opcion;
        
        do
        {
            System.out.println("\n\n----------------------");
            System.out.println("Menú de usuario:");
            System.out.println("1: Mostrar registros.");
            System.out.println("2: Agregar nuevo registro.");
            System.out.println("3: Determinar empresa que más gastó.");
            System.out.println("4: Gasto total empresa comparada con promedio.");
            System.out.println("5: Determinar empresa que menos gastó.");
            System.out.println("6: Salir.");
            
            System.out.println("\nIngrese el número de la opción:");
            
            opcion=Integer.parseInt(lector.readLine());
            
            switch(opcion)
            {
                case 1:
                    for(int i=0; i<empresas.length; i++)
                    {
                        System.out.println((i+1)+". "+empresas[i]+" $"+gastos[i]);
                    }
                    break;
                case 2:
                    boolean agregado=false;
                    
                    System.out.println("Ingrese nombre de la empresa:");
                    String nombreEmpresa=lector.readLine();
                    System.out.println("Ingrese el monto de gasto:");
                    int gasto=Integer.parseInt(lector.readLine());
                    
                    for(int i=0; i<empresas.length && agregado==false; i++)
                    {
                        if(empresas[i]==null)
                        {
                            empresas[i]=nombreEmpresa;
                            gastos[i]=gasto;
                            agregado=true;
                        }
                    }
                    
                    if(agregado==true)
                    {
                        System.out.println("Registro guardado con éxito!");
                    }
                    else
                    {
                        System.out.println("No se pudo guardar el registro.");
                    }
                    break;
                case 3:
                    int posicionGanador=-1, mayor=0;
                    for(int i=0; i<empresas.length; i++)
                    {
                        int suma=0;
                        for(int j=0; j<empresas.length; j++)
                        {
                            if(empresas[i]!=null && empresas[i].equals(empresas[j]))
                            {
                                suma=suma+gastos[j];
                            }
                        }
                        
                        if(posicionGanador==-1 || suma>mayor)
                        {
                            posicionGanador=i;
                            mayor=suma;
                        }
                    }
                    
                    if(posicionGanador!=-1)
                    {
                        System.out.println("---> La empresa que más gastó fue: "+empresas[posicionGanador]+" con un gasto acumulado de $"+mayor);
                    }
                    else
                    {
                        System.out.println("---> No se pudo determinar la empresa que más gastó.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la empresa que desea comparar");
                    String empresaBuscada=lector.readLine();
                    
                    double promedio=0;
                    int suma=0, contador=0;
                    for(int i=0; i<empresas.length; i++)
                    {
                        if(empresas[i]!=null)
                        {
                            suma=suma+gastos[i];
                            contador++;
                        }
                    }
                    if(contador!=0)
                    {
                        promedio=suma/contador;
                    }
                    
                    double promedioEmpresa=0;
                    suma=0;
                    contador=0;
                    for(int i=0; i<empresas.length; i++)
                    {
                        if(empresas[i]!=null && empresas[i].equals(empresaBuscada))
                        {
                            suma=suma+gastos[i];
                            contador++;
                        }
                    }
                    
                    if(contador!=0)
                    {
                        promedioEmpresa=suma/contador;
                    }
                    
                    if(promedioEmpresa>promedio)
                    {
                        System.out.println("La empresa indicada gastó en promedio más que el promedio total de todas las empresas");
                    }
                    else
                    {
                        System.out.println("La empresa indicada no gastó más que el promedio total");
                    }
                    break;
                case 5:
                    int posicionMenosGasto=-1, menor=0;
                    for(int i=0; i<empresas.length; i++)
                    {
                        suma=0;
                        for(int j=0; j<empresas.length; j++)
                        {
                            if(empresas[i]!=null && empresas[i].equals(empresas[j]))
                            {
                                suma=suma+gastos[j];
                            }
                        }
                        
                        if(posicionMenosGasto==-1 || suma<menor)
                        {
                            posicionMenosGasto=i;
                            menor=suma;
                        }
                    }
                    
                    if(posicionMenosGasto!=-1)
                    {
                        System.out.println("---> La empresa que menos gastó fue: "+empresas[posicionMenosGasto]+" con un gasto acumulado de $"+menor);
                    }
                    else
                    {
                        System.out.println("---> No se pudo determinar la empresa que menos gastó.");
                    }
                    break;
                case 6:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("La opción ingresada no es correcta!!");
            }
        }while(opcion!=6);
    }
}
