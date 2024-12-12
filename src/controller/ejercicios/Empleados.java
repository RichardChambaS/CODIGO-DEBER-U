package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class Empleados {
    public static Scanner sn = new Scanner(System.in);

    public void Calculos(){ 
    System.out.println("-----------Programa para informe de autos vendidos.---------");
        System.out.println("Ingrese su nombre de usuario");
        String empleado = sn.next();
        System.out.println("¿Cuántos autos ha vendido?");
        String sautos = sn.next();
        int autos = Utilidades.validarmenu(sautos);
        float precio;
        float preciototal = 0;
        float comision = 0;
        for (int i = 0; i < autos; i++) {
            System.out.println("Ingrese el precio del carro " + (i + 1) + ":");
            precio = sn.nextFloat();
            if (precio >= 10000) {
                comision += 250.0f;
            }
            preciototal += precio;
        }
        float utilidad = preciototal * 0.05f;
        ejecutarinfo(empleado, comision, preciototal, utilidad);
    }

    public void ejecutarinfo(String empleado, float comision, float preciototal, float utilidad){
        System.out.println("------------------------Informe------------------------");
        System.out.println("Usuario: "+empleado);
        System.out.println("Por mes base: 2500.00");
        System.out.println("Por comisión de autos que superan los 10000: " + comision);
        System.out.println("El total de los carros que vendiste: "+preciototal);
        System.out.println("La utilidad por los autos vendidos será: " + utilidad);
        System.out.println("Total ha pagar al empleado es: " + (comision+utilidad+2500));
        System.out.println("------------------------------------------------------");
    }
    
}
