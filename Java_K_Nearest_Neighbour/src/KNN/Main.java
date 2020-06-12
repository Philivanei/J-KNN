package KNN;

public class Main {

    public static void main(String args[]) {

        //Anzahl an Nachbarn, die analysiert werden sollen
        final int k = 5;
        //Anzahl an Klassen, die vorhanden sein sollen (muss noch implementiert werden)
        final int classCount = 2;
        //Groesse der angezeigten Kreuze im Koordinatensystem
        final double crossSize = 0.1;
        //Aufloesung des Koordinatensystems
        final int[] coor = {-10, 10};

        GUI gui = new GUI(k, classCount, coor, crossSize);
        gui.showUI();
    }
}
