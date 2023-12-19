public class Calculadora {
    public void pasarMascara(int mascara) {
        int[] array= new int[32];

        for (int i=0; i < mascara; i++) {
            array[i]=1;
        }

        for (int i=0; i < array.length-1; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
