public class ModuloArrays {

    public static void main(String[] args) {

        // a) Der Modulo operator ist der Mathematische "Rest" Operator

        // b)
        int sum = 12 % 4;
        System.out.println("\n12 % 4 = Rest " + sum);

        // b)
        int sum2 = 13 % 7;
        System.out.println("13 % 7 = Rest " + sum2);

        // b)
        int sum3 = 27 % 5;
        System.out.println("27 % 5 = Rest " + sum3);

        // b)
        int sum4 = 25 % 2;
        System.out.println("25 % 2 = Rest " + sum4);

/*
        c)
        int, float, double

        d)
        das programm printet als immer wie viel Rest übrig bleibt aus und danach
        verringert sich der wert um -2 und geht wieder von vorne
        Solange n größer als 0 ist

 */

//Aufgabe 2
        /*
        (b) Gemeinsamkeiten und Unterschiede zwischen einem Array und einer Liste in Python (bzw. einer ArrayList in Java):

        Gemeinsamkeiten:

        Beide speichern eine Sammlung von Elementen.
        Der Zugriff auf Elemente erfolgt über Indizes.
        Sie unterstützen Iterationen über ihre Elemente.
        Unterschiede:

        Array:
        Hat eine feste Größe, die bei der Deklaration festgelegt wird.
        Speichert nur Elemente eines einzigen Datentyps.
        Effizienter in Bezug auf Speicher und Geschwindigkeit.
        Liste (Python) / ArrayList (Java):
        Flexible Größe: Elemente können hinzugefügt oder entfernt werden.
        Unterstützt unterschiedliche Datentypen (Python-Listen).
        Höherer Speicherbedarf, da Metadaten für Flexibilität benötigt werden.
        Vorteile eines Arrays gegenüber einer Liste:

        Weniger Speicherbedarf.
        Schnellere Zugriffszeit aufgrund der festen Struktur.
        Nachteile eines Arrays gegenüber einer Liste:

        Unflexibel: Die Größe kann nach der Erstellung nicht geändert werden.
        Erfordert häufig manuelles Speichermanagement.

        (a) Erläutere den Begriff des Arrays:
        Ein Array ist eine Datenstruktur, die es ermöglicht, mehrere Elemente desselben Datentyps in einer linearen
        Reihenfolge zu speichern. Die Größe des Arrays wird beim Erstellen festgelegt und ist unveränderlich. Auf die
        Elemente eines Arrays  wird über ihre Indizes zugegriffen, wobei der Index bei 0 beginnt.
         */

        //Aufgabe c,d
        float[] numbers = new float[8];
        numbers[3] = -7.4f;
        System.out.println("\nMuss -7,4 ergeben: " + numbers[3] + "\n");


        //Aufgabe e
        int[] array = new int[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }


        for (int i = 0; i < array.length; i++) {
            System.out.println("\nElement an Index " + i + ": " + array[i]);

        }
/*
        int in = 2147483647;
        byte by = 127;
        double dou = 92233720368547758090555498498498489489458484184164255557665789456219854621489541231654594594189191989848194894981777777777777777777777777777777777777777777777777777777777777777777777777777777777777755555562865858647999999999999999999999999999999994646464646169849846588987564516498415494456987426865189484789.0;
        System.out.println("\n\n" + dou);

 */

        //Augabe 3
        /*
        a)
        Eine foreach-Schleife ist eine Schleife die über alle Elemente einer Sammlung iteriert ohne dass ein Index
        benötigt wird

        b)
         */
        int[] nZahl = new int[10];
        //Int[] nZahl = {1,2,3,4,5,6,7,8,9,10}
        for (int i = 0; i < nZahl.length; i++) {
            nZahl[i] = i + 1;
        }


        System.out.println("\nRest bei Division durch 3:");
        for (int number : nZahl) {
            System.out.println("Zahl: " + number + " -> Rest: " + (number % 3));
        }



    }
}


