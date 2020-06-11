package KNN;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ButtonAction {

    private Point unclassifiedPoint;
    private ArrayList classifiedPoints;

    public ButtonAction() {

    }

    //TODO: die testdaten generieren manchmal nur 3 punkte einer klasse --> damit kann es in die andere klasse fallen Gewichtung!!!
    public void createTestData(int classCount) {
        //Erzeugen von Testdaten
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            int zx;
            int zy;
            int theClass = ((int) (Math.random() * classCount));
            //Zur Zufallsgruppierung
            if (theClass == 1) {
                //befinden sich im Bereich x = 5 bis 7 und y = 5 bis 7
                zx = (5 + ((int) (Math.random() * 3)));
                zy = (5 + ((int) (Math.random() * 3)));
            } else {
                //befinden sich im Bereich x = 0 bis 2 und y = 0 bis 2
                zx = ((int) (Math.random() * 3));
                zy = ((int) (Math.random() * 3));
            }
            points.add(new Point(zx, zy, theClass));
            classifiedPoints = points;

            System.out.println("Festgelegter Punkt " + i + ": x " + zx + " y " + zy + " klasse " + theClass);
        }

        //Unklassifizierter Zufallspunkt
        //Der Zufallspunkt befindet sich im Bereich x = 0 bis 7 und y = 0 bis 7
        int zzx = ((int) (Math.random() * 8));
        int zzy = ((int) (Math.random() * 8));
        Point unclassifiedPoint = new Point(zzx, zzy);
        this.unclassifiedPoint = unclassifiedPoint;
        System.out.println("\nUnklassifizierter Punkt: x " + zzx + " y " + zzy + "\n");
    }

    public void getKNearestNeighbour(int k) {
        //Ausgabe des Ergebnisses für k Nachbaranalysen
        KNearestNeighbour test = new KNearestNeighbour(k);
        System.out.println("Klassifiziert in Klasse: " + test.calculateKNearestNeighbour(unclassifiedPoint, classifiedPoints));
    }

    public Point getUnclassifiedPoint() {
        return unclassifiedPoint;
    }

    public ArrayList<Point> getClassifiedPoints() {
        return classifiedPoints;
    }
}
