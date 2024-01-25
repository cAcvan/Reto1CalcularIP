import java.util.Scanner;
public class Validacion {
    private String ip;
    private String ipString[] = new String[5];
    private String ipString2[] = new String[4];

    private String ipEntera[] = new String[1];
    private int mascara;

    public String getIp() {
        return ip;
    }

    public int getMascara() {
        return mascara;
    }

    Scanner sc = new Scanner(System.in);

    public int devolverMascara(){
        int mascara = Integer.parseInt(ipString[4]);

        return mascara;
    }

    public int[] PasarArray(){
        int[] array = new int[4];

        for (int i=0;i<4;i++){
            array[i]=Integer.parseInt(ipString[i]);
        }

        return array;
    }

    public int[] PasarArray2(){
        int[] array = new int[4];

        for (int i=0;i<4;i++){
            array[i]=Integer.parseInt(ipString2[i]);
        }

        return array;
    }

    public void splitearOpcion1(String ip) {
        String ipReal = "";
        int cont = 0;
        int cont2 = 0;
        do {
            char IpChar = ip.charAt(cont);

            if (IpChar != '.' && IpChar != '/') {
                ipReal = ipReal + IpChar;
            }

            if (IpChar == '.' || IpChar == '/' || cont == ip.length() - 1) {
                ipString[cont2] = ipReal;
                ipReal = "";
                cont2++;
            }

            cont++;
        } while (cont < ip.length() && cont2 < 5);

    }

    public int[] splitearOpcion2(String ip) {
        String ipReal = "";
        int cont = 0;
        int cont2 = 0;
        ipString2 = new String[4];
        do {
            char IpChar = ip.charAt(cont);

            if (IpChar != '.' && IpChar != '/') {
                ipReal = ipReal + IpChar;
            }

            if (IpChar == '.' || IpChar == '/' || cont == ip.length() - 1) {
                ipString2[cont2] = ipReal;
                ipReal = "";
                cont2++;
            }

            cont++;
        } while (cont < ip.length() && cont2 < 5);

        int array[] = new int[4];

        for(int i=0;i<ipString2.length-1;i++){
            array[i]=Integer.parseInt(ipString2[i]);
        }

        return array;
    }


    public String volver() {
        return ipString[4];
    }


    public void most() {
        for (int i = 0; i < ipString.length - 1; i++) {
            System.out.println(ipString[i]);
        }
    }

    public void setMascara(int mascara) {
        this.mascara = mascara;
    }

    public void menu() throws InterruptedException {
        System.out.println("----------MENU----------");
        System.out.println("1.Calcular dirección IP");
        System.out.println("0.Salir");
        System.out.println();
    }

    public void load() throws InterruptedException {
        System.out.print("Loading");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            System.out.print('.');
        }
    }

    public void submenu() {
        System.out.println("1.Ingresar IP y máscara en notación CDIR.");
        System.out.println("2.Ingresar IP  y mascara en decimal.");
    }

    public boolean validarOpcion1(String ip) {
        boolean continuar = false; //para controlar el bucle del main
        int cont = 0;
        boolean flag = false; // para controlar la mascara de red
        boolean numInvalido = false; // para controlar la ip

        for (int i = 0; i < ip.length(); i++) { // Para contar los puntos
            if (ip.charAt(i) == '.') {
                cont++;
            }
        }

        // Separar la cadena de IP y la mascara
        String[] ipAndMask = ip.split("/");

        // Verificar las partes de la IP y la máscara de red
        if (ipAndMask.length == 2) { // comprobamos si hay 2 partes, para saber si está la mascara
            try {
                int mask = Integer.parseInt(ipAndMask[1]); // 1 siendo la mascara, ya que 0 será la ip
                if (mask < 0 || mask > 32) {
                    flag = true;
                }
            } catch (NumberFormatException e) {
                flag = true;
            }
        }

        for (String ipPart2 : ipAndMask[0].split("\\.")) { // Divide la IP por puntos y con subIpPart la recorremos
            try {
                int num = Integer.parseInt(ipPart2);
                if (num < 0 || num > 255) {
                    numInvalido = true;
                }
            } catch (NumberFormatException e) {
                numInvalido = true;
            }
        }

        if (ipAndMask.length != 2 || cont != 3) { // si ipMask no tiene 2 partes y si cont es distinto a 3
            System.out.println("Falta algún elemento, introduce la ip en notación CDIR.");
            continuar = true;
        }  if (numInvalido) {
            System.out.println("Rango de los elementos ip: " + ipAndMask[0] + " no es válida");
            continuar = true;
        }  if (flag) {
            System.out.println("Rango de la máscara " + ipAndMask[1] + " no es válida");
            continuar = true;
        } if(!continuar) {
            System.out.println("La ip " + ipAndMask[0] + " y la máscara " + ipAndMask[1] + " son correctas.");
        }
        System.out.println();

        return continuar;
    }


    public boolean validarOpcion2(String ip, String mascara) {
        boolean continuar = false;
        int cont = 0;
        boolean numeroInvalidoM = false;
        boolean continuarIp = false;
        boolean continuarPuntos = false;

        for (int i = 0; i < ip.length() && !continuarPuntos; i++) { // Vamos a contar puntos
            if (ip.charAt(i) == '.') {
                cont++;
                if (cont == 4) {
                    continuarPuntos = true;
                }
            }
        }

        // Separamos en octetos
        String[] octetosIp = ip.split("\\.");
        String[] octetosMasc = mascara.split("\\.");

        // Recorremos con for los octetos IP
        for (String ipPart2 : octetosIp) {
            try {
                int num = Integer.parseInt(ipPart2);
                if (num < 0 || num > 255) {
                    continuarIp = true;
                }

            } catch (NumberFormatException e) {
                continuarIp = true;
            }
        }

        // Recorremos con for los octetos masc
        for (int i=0;i<octetosMasc.length-1;i++) {
            try {
                int num = Integer.parseInt(octetosMasc[i]);
                int num2 = Integer.parseInt(octetosMasc[i+1]);
                if (num < 0 || num > 255) {
                    numeroInvalidoM = true;
                }
                if(num<num2)
                    numeroInvalidoM = true;

            } catch (NumberFormatException e) {
                numeroInvalidoM = true;
            }
        }

        if (octetosIp.length != 4 || octetosMasc.length != 4) {
            System.out.println("Falta algún elemento o caracter mal puesto, introduce la IP y la máscara en decimal");
            continuar = true;
        }  if (cont != 3) {
            System.out.println("Error en el formato, asegúrate de poner correctamente los puntos en la dirección IP");
            continuar = true;
        }  if (continuarIp) {
            System.out.println("Rango de los elementos IP: " + ip + " no es válido");
            continuar = true;
        }  if (numeroInvalidoM) {
            System.out.println("Rango de los elementos de la máscara de red: " + mascara + " no es válido");
            continuar = true;
        } if(!continuar) {
            System.out.println("La IP " + ip + " y la máscara " + mascara + " son correctas");
        }

        return continuar;
    }
}
