import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Validacion m = new Validacion();
        Scanner sc = new Scanner(System.in);
        int[] array = new int[4];
        int[] array2 = new int[4];
        int[] mascaraDecimal = new int[4];


        int opcion, opcionIp, mascaraReal, recurso, recurso2;
        String ip;
        String mascara, mascara2, mascaraEnBinarioSimple;
        boolean salida = false, flag = false;

        do {
            try {
                m.menu();
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
                        m.submenu();
                        System.out.println("Ingresa la opción: ");
                        opcionIp = sc.nextInt();
                        if (opcionIp == 1) {
                            System.out.println("Ingresa IP");
                            ip = sc.next();
                            if (!m.validarOpcion1(ip)) {
                                m.splitearOpcion1(ip);
                                System.out.println();
                                mascaraReal = m.devolverMascara();
                                array = m.PasarArray();
                                System.out.println("Ahora se mostrará el tipo y la clase de red: ");
                                TipoDeRed.tipo(array);
                                TipoDeRed.clase(array);
                                System.out.println();
                                System.out.println("Ahora se calculará la dirección de red, el broadcast y los host disponibles: ");
                                System.out.print("Valor hexadecimal de la ip: ");
                                binary.PasarHexadecimal(array);
                                recurso = binary.PasarMascaraOne(mascaraReal);
                                String ipEnBinario[] = binary.PasarBinario(array);
                                mascara2 = binary.PasarMascara(mascaraReal);
                                binary.CalcularRed(ipEnBinario, mascara2, recurso);
                                System.out.println();
                            }
                        } else if (opcionIp == 2) {
                            System.out.println("Ingresa la dirección IP:");
                            String ipOpcion2 = sc.next();
                            System.out.println("Ingresa la máscara");
                            String mascOpcion2 = sc.next();
                            sc.nextLine();
                            if(!m.validarOpcion2(ipOpcion2, mascOpcion2)){
                                m.splitearOpcion2(ipOpcion2);
                                array2 = m.PasarArray2();
                                m.splitearOpcion2(mascOpcion2);
                                mascaraDecimal = m.PasarArray2();
                                TipoDeRed.clase(array2);
                                TipoDeRed.tipo(array2);
                                binary.PasarHexadecimal(array2);
                                String ipEnBinario2[] = binary.PasarBinario(array2);
                                String mascaraEnBinario[] = binary.PasarBinario(mascaraDecimal);
                                mascaraEnBinarioSimple = binary.DevolverMascaraBinario(mascaraEnBinario);
                                recurso2 = binary.DevolverMascaraEnEntero(mascaraEnBinarioSimple);
                                binary.CalcularRed(ipEnBinario2,mascaraEnBinarioSimple,recurso2);
                                System.out.println();
                            }
                        }
                        break;
                    default:
                        System.out.println("La opción " + opcion + " no es válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("La opción no es válida");
                sc.nextLine();
                System.out.println();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Fuera del rango del índice");
                sc.nextLine();
            } catch (NumberFormatException e){
                System.out.println("Formato incorrecto");
                sc.nextLine();
            }
        } while (!salida);
    }

}
