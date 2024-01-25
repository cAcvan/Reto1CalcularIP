public class TipoDeRed {
    public static void clase(int[] array){
        int num1 = array[0];

        if(num1>=1 && num1<=126) {
            System.out.println("La IP es de tipo A.");
        } else if (num1>=128 && num1<=191) {
            System.out.println("La IP es de tipo B.");
        } else if (num1>=192 && num1<=223) {
            System.out.println("La IP es de tipo C.");
        } else if (num1>=224 && num1<=239) {
            System.out.println("La IP es de tipo D.");
        } else if (num1>=240 && num1<=255) {
            System.out.println("La IP es de tipo E.");
        } else
            System.out.println("La IP " + num1 + " no es de ningún tipo.");
    }

    public static void tipo(int[] array){
        int num = array[0];
        int num2 = array[1];

        String ip1 = String.valueOf(num);
        String ip2 = ip1 + '.' + String.valueOf(num2);


        if(ip1.equals("10")) {
            System.out.println("La IP  es privada.");
        } else if (ip2.equals("172.16")) {
            System.out.println("La IP es privada.");
        } else if (ip2.equals("192.168")) {
            System.out.println("La IP es privada.");
        } else {
            System.out.println("La IP es pública.");
        }
    }
}
