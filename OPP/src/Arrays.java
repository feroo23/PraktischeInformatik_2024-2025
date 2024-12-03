public class Arrays {

    public static void main(String[] args) {
        //Aufgabe c,d
        float[] numbers = new float[8];
        numbers[3] = -7.4f;
        System.out.println("Muss -7,4 ergeben " + numbers[3]);



        //Aufgabe e
        int[] array = new int[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("\nElement an Index " + i + ": " + array[i]);
        }
    }
}


