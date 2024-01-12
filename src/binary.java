import java.util.Scanner;

public class binary {

    public static void PasarBinario(int[] array){
        String binario = "";
        int cont=0;
       for(int i=0;i< array.length;i++){
           binario=binario + Integer.toBinaryString(array[i]);
           if (cont<3){
               binario=binario + '.';
           }
           cont++;
       }
        System.out.println(binario);

    }

    public static void PasarHexadecimal(int[] array){
        String hexa = "";
        int cont=0;
        for(int i=0;i< array.length;i++){
            hexa=hexa + Integer.toHexString(array[i]);
            if(cont<3){
                hexa = hexa + '.';
            }
            cont++;
        }
        System.out.println(hexa);
    }

    public static void CalcularRed(int[] array1,int[] array2){

    }

    public static void main(String[] args){
        int cac[]={3,0,1,145};
        binary.PasarBinario(cac);
    }
}

