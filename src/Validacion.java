public class Validacion {
    private String ip;
    private String ipString[] = new String[5];
    private String ipEntera[] = new String[1];
    private int mascara;

    public String getIp() {
        return ip;
    }

    public int getMascara() {
        return mascara;
    }

    public void splitear(String ip) {
        for(int i=0;i<ip.length()-1;i++){
            if(ip.charAt(i)!='/'){
                ipString = ip.split("\\.");

            }
        }
    }

    public String volver(){
        return ipString[5];
    }

    public void most(){
        for(int i=0;i< ipString.length-1;i++){
            System.out.println(ipString[i]);
        }
    }

    public void setMascara(int mascara) {
        this.mascara = mascara;
    }

    public void menu() throws InterruptedException {
        System.out.println("----------MENU----------");
        System.out.println("1.Calcular dirección IP");
        System.out.println("2.Historial de IPs");
        System.out.println("0.Salir");;
        System.out.println();
    }

    public void load() throws InterruptedException {
        System.out.print("Loading");
        for(int i=0;i<10;i++){
            Thread.sleep(250);
            System.out.print('.');
        }
    }

    public void submenu(){
        System.out.println("1.Ingresar IP y depués máscara, en notación CDIR.");
        System.out.println("2.Ingresar IP junto a máscara, en decimal.");
    }

    public void validar(String ip, String mascaracs) {
        int cont = 0;
        int mascara = Integer.parseInt(mascaracs);
        boolean flag = false;
        for (int i = 0; i < ip.length() - 1; i++) {
            if (ip.charAt(i) == '.') {
                cont++;
            }
        }

        for(int i=0;i< ipString.length;i++){
            int num = Integer.parseInt(ipString[i]);
            if(num>255|| num<0){
                flag=true;
            }
        }

        if (ip.length() < 9 || ip.length() > 18) {
            System.out.println("La ip " + ip + " no es una ip válida.");
        } else if (cont > 3) {
            System.out.println("La ip " + ip + " no es una ip válida.");
        } else if (flag){
            System.out.println("La ip " + ip + " no es una ip válida.");
        } else if(mascara>32 || mascara<1){
            System.out.println("La máscara " + mascara + " no es una máscara válida.");
        } else
            System.out.println("La ip " + ip + " y la máscara " + mascara + " son correctas.");
        System.out.println();
    }
}
