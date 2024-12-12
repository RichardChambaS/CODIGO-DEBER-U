package controller.util;

import controller.util.Utilidades;
import java.util.Scanner;

public class Utilidades {
    public static Scanner sn = new Scanner(System.in);

    public static boolean validate(String num) { // El utilizado en las clases.
        boolean band = true;
        if (num.charAt(0) == '-') {
            num = num.substring(0);
            num = num.substring(1);
        }
        int cont_p = 0;
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i)) && num.charAt(i) != '.') {
                band = false;
                break;
            } else if (num.charAt(i) == '.')
                cont_p++;
        }
        if (cont_p >= 2)
            band = false;
        return band;
    }

    public static int transformStringInt(String num) { // El utilizado de las clases.
        int resp = 0;
        if (Utilidades.validate(num)) {
            resp = Integer.parseInt(num);
        }
        return resp;
    }

    public static int validarmenu(String numeroString) { //validar  que  no ponga un valor negativo o alguna letra o palabra.
        boolean validar = false;
        int num = 0;
        do {
            if (Utilidades.validate(numeroString)) {
                num = Utilidades.transformStringInt(numeroString);
                if (num > 0) {
                    validar = true;
                } else {
                    System.out.println("Ingrese un número mayor a 0");
                    numeroString = sn.next();
                }
            } else {
                System.out.println("INGRESE UN NÚMERO, NO UNA LETRA.");
                numeroString = sn.next();
            }
        } while (validar != true);

        return num;
    }

    public static float redondear(float num) { // utilizado en clases
        float aux = num * 100.00f;
        float aux1 = (float) ((int) aux);
        return (aux1 / 100.00f);
    }
}
