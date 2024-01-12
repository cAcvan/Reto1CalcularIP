import java.util.Scanner;

public class binary {

    public static String[] PasarBinario(int[] array){
        String binario = "";
        String cac="";
        int cont=0;
        int cont2=8;
        String pepe[]=new String[4];
       for(int i=0;i< array.length;i++){
           binario=Integer.toBinaryString(array[i]);
           if(cont2!=binario.length()){
               do{
                   cac = cac+"0";
                   cont2--;
               }while(cont2>binario.length());
           }

           if (cont<4){
               String binario2 = cac + binario;
               pepe[cont]=binario2;
           }
           cont++;
           cont2=8;
           cac="";
       }

       return pepe;
    }

    public static void PasarHexadecimal(int[] array){
        String hexa = "";
        int cont=0;
        String pepe[]=new String[4];
        for(int i=0;i< array.length;i++){
            hexa=Integer.toHexString(array[i]);
            if(cont<4){
                pepe[cont]=hexa;
            }
            cont++;
        }
        for(String num:pepe)
            System.out.print(num + " ");
    }

    public static String PasarMascara(int mascara){
        String mascaparra="";
        for (int i=0;i<mascara;i++){
            mascaparra=mascaparra+"1";
        }
        for(int i=mascara;i<32;i++){
            mascaparra=mascaparra+"0";
        }
        System.out.println(mascaparra);
        return mascaparra;
    }

    public static int PasarMascaraOne(int mascara){
        String mascaparra="";
        int cont=0;
        for (int i=0;i<mascara;i++){
            mascaparra=mascaparra+"1";
            cont++;
        }

        return cont;
    }

    public static void CalcularRed(String[] pepe, String mascaparra, int recurso) {
        String ip="";
        for (int i=0; i< pepe.length;i++){
            ip=ip+pepe[i];
        }

        String resultado = "";
        String cac = "";
        String octeto = "";
        String avc = "";
        String faf= "";
        String va= "";
        String antonio="";
        String adrian="";
        int cont=0,cont2=0,cont3=0;

        do{
            if(cont<8){
                resultado = resultado + (Character.getNumericValue(ip.charAt(cont2)) * (Character.getNumericValue(mascaparra.charAt(cont2))));
                faf = faf + (Character.getNumericValue(ip.charAt(cont2)) * (Character.getNumericValue(mascaparra.charAt(cont2))));
                cont2++;
                cont++;
                cont3++;
                if(cont==8){
                    cac = cac + binary.PasarDecimal(resultado) + '.';
                    octeto = octeto + resultado;
                    resultado = "";
                    cont = 0;
                }
                if(cont3==recurso){
                    avc = faf;
                    antonio = faf;
                }
            }
        }while(cont2<32);

        cont2=0;
        cont=0;

        for(int i=recurso+1;i<=32;i++){
            if(i==32){
                antonio = antonio + "1";
            }else
                antonio = antonio + "0";
        }

        String falo = avc;

        for(int i=recurso+1;i<=32;i++){
            avc = avc + "1";
            if(i!=31){
                falo=falo + "1";
            }
            if(i==32){
                falo = falo + "0";
            }
        }

        adrian=avc.substring(recurso,avc.length()-1);

        int marco = Integer.parseInt(binary.PasarDecimal(adrian))-1;


        String ivan="";
        String nico="";
        String broadcast="";
        do {
            va = va + avc.charAt(cont2);
            ivan = ivan + antonio.charAt(cont2);
            if(cont==7){
                broadcast = broadcast + binary.PasarDecimal(va) + '.';
                nico = nico + binary.PasarDecimal(ivan) + '.';
                va="";
                ivan= "";
                cont=-1;
            }
            cont2++;
            cont++;
        }while(cont2<32);

        cont2=0;
        cont=0;


        String generalitat = "";
        String s="";
        do{
            generalitat = generalitat + falo.charAt(cont2);
            if(cont==7){
                s = s + binary.PasarDecimal(generalitat) + '.';
                generalitat="";
                cont=-1;
            }
            cont++;
            cont2++;
        }while(cont2<32);

        System.out.println("Resultados de la ip:");
        System.out.println("Ip de red: " + cac);
        System.out.println("Broadcast: " + broadcast);
        System.out.println("Primer host disponible: " + nico);
        System.out.println("último host disponible: " + s);
    }

    public static String PasarDecimal(String num){
        int decimal1 = Integer.parseInt(num,2);
        String decimal = String.valueOf(decimal1);

        return decimal;
    }

    public static String[] PasarArray(int[] array){
        String[] newarray = new String[array.length];
        for(int i=0;i< array.length;i++){
            newarray[i]=String.valueOf(array[i]);
        }

        return newarray;
    }

    public static void main(String[] args){
        int cac[]={134,89,5,47};
        int mascara = 29;
        int recurso;
        String mascara2;

        binary.PasarHexadecimal(cac);
        recurso = binary.PasarMascaraOne(mascara);
        System.out.println();
        String red[] = binary.PasarBinario(cac);
        System.out.println();
        mascara2 = binary.PasarMascara(mascara);
        System.out.println();
        binary.CalcularRed(red,mascara2,recurso);
    }
}
