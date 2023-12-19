import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Validacion v = new Validacion();
        Scanner sc = new Scanner(System.in);
        String iphistoial[] = new String[100];

        int opcion, opcionIp;
        String ip,mascara;
        boolean salida = false, flag=false;

        do {
            try {
                v.menu();
                System.out.println("Introduce la opción: ");
                opcion = sc.nextInt();
                /*v.load();*/
                System.out.println();
                switch (opcion) {
                    case 0:
                        System.out.println("Adiós :)");
                        salida = true;
                        break;
                    case 1:
                        v.submenu();
                        System.out.println("Ingresa la opción: ");
                        opcionIp = sc.nextInt();
                        if(opcionIp==1){
                            System.out.println("Ingresa la dirección ip:");
                            ip = sc.next();
                            v.splitear(ip);
                            mascara=v.volver();
                            v.validar(ip,mascara);
                            v.most();
                        }else if (opcionIp==2){
                            System.out.println("Ingresa la dirección ip:");
                            String ipOpcion2= sc.next();
                            System.out.println("Ingresa la mascara");
                            String mascOpcion2= sc.next();

                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("La opción " + opcion + " no es válida.");
                }
            } catch(InputMismatchException e){
                System.out.println("La opción no es válida");
                sc.nextLine();
                System.out.println();
            }
        }while(!salida);
    }
}
