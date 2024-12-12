package controller.ejercicios;

import java.util.Scanner;

import controller.util.Utilidades;

public class Llamadas {
    public static Scanner sn = new Scanner(System.in);

    public static enum Regiones { // Enumeración de las regiones
        AMERICA_NORTE(12, 2.75f),
        AMERICA_CENTRAL(15, 1.89f),
        AMERICA_SUR(18, 1.60f),
        EUROPA(19, 3.50f),
        ASIA(23, 4.50f),
        AFRICA(25, 3.10f),
        OCEANIA(29, 3.00f),
        RESTO_MUNDO(31, 6.00f),
        SALIR(1, 0.0f);

        private final int cod;  //puse los valores de codigo y tarifa a pagar
        private final float tarifa;

        Regiones(int cod, float tarifa) {   
            this.cod = cod; //los hice en constructor para hacerle todo
            this.tarifa = tarifa;
        }

        public int getCod() {
            return cod;
        }

        public float getTarifa() {
            return tarifa;
        }

        public static Regiones paracodigo(int menu) { 
            Regiones[] regiones = values(); //tipo array  con los enums
            for (int i = 0; i < regiones.length; i++) { // recorremos el valor
                if (regiones[i].getCod() == menu) {
                    return regiones[i];
                }
            }
            return null; // retorno null si el valor está mal
        }
        
    }

    public static void menu() {
        System.out.println("Se le mostrará la zona en la que quiere hacer una llamada, y su respectiva clave.");
        System.out.println("Por favor ingrese un código válido de la zona que desea. \n");
        System.out.println("-----------------------------------");
        System.out.println("REGIÓN              CÓD");
        System.out.println("AMERICA DEL NORTE:  12");
        System.out.println("AMERICA CENTRAL:    15");
        System.out.println("AMERICA DEL SUR:    18");
        System.out.println("EUROPA:             19");
        System.out.println("ASIA:               23");
        System.out.println("ÁFRICA:             25");
        System.out.println("OCEANÍA:            29");
        System.out.println("RESTO DEL MUNDO:    31");
        System.out.println("-----------------------------------");
        System.out.println("Si desea salir del menú, ingrese 1");
        System.out.println("\nIngrese un código.");
    }

    public static void casos() {
        boolean salir = false;
        do {
            menu();
            String smenu = sn.next();
            int menu = validarmenu(smenu);

            Regiones region = Regiones.paracodigo(menu);

            if (region == null) {
                System.out.println("CODIGO INVÁLIDO, INTENTE NUEVAMENTE POR FAVOR.");
                continue; //el continue es para saltar a la siguiente iteración
            }

            switch (region) {
                case AMERICA_NORTE:
                case AMERICA_CENTRAL:
                case AMERICA_SUR:
                case EUROPA:
                case ASIA:
                case AFRICA:
                case OCEANIA:
                case RESTO_MUNDO:
                    procesollamada(region.getTarifa()); //aqui llamo dependiendo el precio
                    break;
                case SALIR:
                    salir = true;
                    break;
                default:
                    System.out.println("INGRESE CORRECTAMENTE EL CÓDIGO.");
                    break;
            }
        } while (salir != true);
    }

    public static int pedirminutos() {
        String sminutos = ""; // string minutos
        boolean a = false;
        do {
            System.out.println("Ingrese los minutos que usted ha llamado:");
            sminutos = sn.next();
            if (Utilidades.validate(sminutos)) {
                    a = true;
            } else {
                System.out.println("INGRESE UN NÚMERO CORRECTO.");
            }
        } while (a != true);
        return Utilidades.transformStringInt(sminutos);
    }

    public static String convertirMinutosaHoras(int minutos) {
        int horas = 0;
        while (minutos >= 60) {
            if (minutos >= 60) {
                minutos = minutos - 60;
                horas = horas + 1;
            }
        }
        return "Usted ha llamado " + horas + " hora(s) con " + minutos + " minuto(s)";
    }

    public static void procesollamada(float tarifa) {
        int minutos = pedirminutos();
        if (minutos <0){
            minutos = minutos*-1;
            System.out.println("ADVERTENCIA. Sus minutos se convirtieron en positivo xd");
        }
        String presentar = convertirMinutosaHoras(minutos);
        float total = minutos * tarifa;
        System.out.println("\n-------------Informe------------");
        System.out.println(presentar);
        System.out.println("La cantidad a pagar es de: " + total + "$");
        System.out.println("--------------------------------");
    }

    public static int validarmenu(String smenu) {
        boolean validar = false;
        do {
            if (Utilidades.validate(smenu)) {
                validar = true;
            } else {
                System.out.println("INGRESE UN NÚMERO, NO UNA LETRA.");
                smenu = sn.next();
            }
        } while (validar != true);
        return Utilidades.transformStringInt(smenu);
    }

    public static void presentar() {
        casos();
    }
}
