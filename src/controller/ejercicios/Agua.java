package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class Agua {
    public static Scanner sn = new Scanner(System.in);

    public static void PresentarAgua() {
        System.out.println("Programa del agua");

        String sconsumo = " ";
        int consumo = 0;
        float pagar = 0.0f;
        float descuentovejez = 0.0f;
        float pagarimpuesto = 0.0f;
        float discapacidad = 0.0f;
        boolean edad = false;

        System.out.println("Ingrese cantidad de consumo en m3:");
        sconsumo = sn.next();
        consumo = Utilidades.validarmenu(sconsumo);
        if (consumo >= 0) {
            pagar += 3.00f; // será el costo inicial
            edad = preguntaredad(edad);
            if (edad == true)
                descuentovejez = descuentoedad(pagar, 0.50f, edad);
            System.out.println("¿Usted padece alguna discapacidad? Escriba S/N respectivamente");
            String si = "";
            si = sn.next();
            if (si.toLowerCase().equals("s")) {
                discapacidad = porcentajediscapacidad();

                discapacidad = DescuentoDiscapacidad(pagar, discapacidad);

            }

            // System.out.println(pagar);
        }

        if (consumo >= 15) {
            descuentovejez = descuentoedad(pagar, 0.30f, edad); // 0.75 porque haciendo el calculo restado es el 0.35

            pagar = bucleparasumar(0.10f, pagar, Math.min(consumo, 24), 24, 15);
        }
        // lo siento por lo quemado que está
        if (consumo >= 25) {
            pagar = bucleparasumar(0.20f, pagar, Math.min(consumo, 39), 39, 25);
        }

        if (consumo >= 40) {
            pagar = bucleparasumar(0.30f, pagar, Math.min(consumo, 59), 59, 40);
        }

        if (consumo >= 60) {
            pagar = buclemax(consumo, pagar, 59);
        }

        pagarimpuesto = impuesto(pagar);

        while (descuentovejez + discapacidad > 3) { // esto es para que ambos descuentos no se pasen de la base
            discapacidad -= 0.01f;
        }
        //redondear porque todos salian con 0.99999
        pagar = Utilidades.redondear(pagar);
        discapacidad = Utilidades.redondear(discapacidad);
        descuentovejez = Utilidades.redondear(descuentovejez);
        pagarimpuesto = Utilidades.redondear(pagarimpuesto);
        informe(consumo, descuentovejez, pagarimpuesto, discapacidad, pagar);
    }

    public static float bucleparasumar(float preciosagua, float pagar, float consumo, int limite2, int i) {

        for (; i <= consumo; i++) {
            if (consumo <= limite2) { // 0.10, 3, 15, 24;
                pagar += preciosagua;
            }

        }
        return pagar;
    }

    public static float buclemax(float consumo, float pagar, int i) {
        // pagar = anterior;
        for (; i < consumo; i++) {
            if (consumo >= 60) {
                pagar += 0.35f;

            }

        }
        return pagar;
    }

    public static float impuesto(float pagar) {
        float pagarimpuesto = 0.0f;
        pagarimpuesto = pagar;
        pagar = pagar * 0.35f;
        pagarimpuesto += pagar;
        return pagarimpuesto;
    }

    public static float descuentoedad(float pagar, float descuento, boolean edad) {
        if (edad == true) {
            pagar = 3.00f;
            pagar = pagar * descuento;
            return pagar;
        } else {
            return pagar = 0;
        }
    }

    public static float DescuentoDiscapacidad(float pagar, float discapacidad) {

        discapacidad /= 100;
        pagar = pagar * discapacidad;
        return pagar;
    }

    public static boolean preguntaredad(boolean edad) {
        System.out.println("¿Usted pertenece al rango de la tercera edad? Escriba S/N respectivamente");
        String si = "";
        si = sn.next();
        if (si.toLowerCase().equals("s")) {
            edad = true;
            return edad;
        } else {
            return edad;
        }

    }

    public static float porcentajediscapacidad() {
        float discapacidad = 0.0f;
        System.out.println("¿Cuanto porcentaje de discapacidad tiene? Ingrese de 5 a 100");
        discapacidad = sn.nextFloat();
        return discapacidad;
    }

    public static void informe(int consumo, float descuentovejez, float pagarimpuesto, float discapacidad,
            float pagar) {
        System.out.println("-----------------Informe-------------------------");
        System.out.println("IMPUESTOS----------------------------------------");
        System.out.println("Impuesto de alcantarillado                 35%");
        System.out.println("Tasa por recolección de basura            0.75");
        System.out.println("Tasa por costo de procesamiento de datos: 0.50");
        System.out.println("CONSUMOS-----------------------------------------");
        System.out.println("Su consumo de:                            " + consumo + "m3");
        System.out.println("Por consumo es:                           " + pagar);
        System.out.println("Consumo con impuesto de alcantarillado:   " + pagarimpuesto);
        System.out.println("DESCUENTOS---------------------------------------");
        System.out.println("Descuento por vejez:                      " + "-" + descuentovejez);
        System.out.println("Descuento por discapacidad                " + "-" + discapacidad);
        System.out.println("Total--------------------------------------------");
        System.out.println("Total a pagar:                            "+ (Utilidades.redondear((pagarimpuesto + 0.75f + 0.50f - descuentovejez) - discapacidad)));

    }

}