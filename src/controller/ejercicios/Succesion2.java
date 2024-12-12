package controller.ejercicios;

public class Succesion2 {
    public static int fibonacciarriba(int n) { //fibonacci arriba
        int x = 1;
        int y = 0;
        int z = 1;

        for (int i = 1; i <= n; i++) {
            z = x;
            x = x + y;
            y = z;
        }
        return x;
    }

    public static int abajo(int n) { // no topar
        int a = 1;
        for (int i = 1; i <= n; i++) {
            a = a + 2;
        }
        return a;
    }

    public static int exponente(int n) { // no topar
        int a = 2;
        for (int i = 1; i <= n; i++) {
            a = a + 2;
        }
        return a;
    }

    public static char signo(int n) {
        char respuesta = ' ';
        char signoposi = '+';
        char signonega = '-';
        int cont = 1;
        for (int i = 0; i <= n; i++) {
            if (cont <= 2) {
                respuesta = signoposi;
            } else if (cont <4  && cont >=3){
                respuesta = signonega;
            }
                else{ 
                    cont = 0;
                }
                cont++;
            }
            
        return respuesta;
        }

    public static String entregarfinal(int n) {
        String a = "";
        for (int i = 0; i < n; i++) {
            a = Succesion2.signo(i) + "(" + Succesion2.fibonacciarriba(i) + "/" + Succesion2.abajo(i) + ")^"
                    + Succesion2.exponente(i)+ " ";
        }
        return a;
    }

    public static float entregarsuma(int n) {
        float b = 0;
        for (int i = 0; i < n-1; i++) { //el -1 no sé porque pasaba que se sumaba el siguiente numero de la sucección aunque no existía, entonces le reste ese xd
            if (Succesion2.signo(i) == '-') {
                b -= Math.pow(((float) Succesion2.fibonacciarriba(i) / (float) Succesion2.abajo(i)),
                        ((float) Succesion2.exponente(i)));
            } else {
                b += Math.pow(((float) Succesion2.fibonacciarriba(i) / (float) Succesion2.abajo(i)),
                        ((float) Succesion2.exponente(i)));// le puse dar formato y me lo puso así en dos lineas en vez de una
            }
        }
        return b;
    }  

    
}

