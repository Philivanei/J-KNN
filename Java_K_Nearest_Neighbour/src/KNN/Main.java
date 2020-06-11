package KNN;

public class Main {

    public static void main(String args[]) {

        //Anzahl an Nachbarn, die analysiert werden sollen
        final int k = 5;
        //Anzahl an Klassen, die vorhanden sein sollen (muss noch implementiert werden)
        //Bleibt vorerst 2 zur Vereinfachung nur 2 Klassen
        final int classCount = 2;

        GUI gui = new GUI(k, classCount);
        gui.showUI();

        //TODO: Punkte müssen noch eingezeichnet werden!

    }
}
