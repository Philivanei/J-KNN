package KNN;

import java.util.*;

public class KNearestNeighbour {

    private int k;

    public KNearestNeighbour(int k) {
        this.k = k;
    }

    public int calculateKNearestNeighbour(Point unclassifiedPoint, ArrayList<Point> points) {

        //TODO: Groesse der Klassenanzahl angeben
        int[] classes = new int[2];
        CalculateDistanceHelper distance = new CalculateDistanceHelper();
        List<PointDistance> pointDistances = new ArrayList<>();

        //Berechne fuer jeden Punkt die Distanz zum unklassifizierten Punkt und speicher ihn in pointDistances mit
        //der berechneten Distanz
        for (Point p : points) {
            pointDistances.add(new PointDistance(p, distance.getEuclideanDistance(unclassifiedPoint, p)));
        }

        //Sortiere die Liste aufsteigend nach der Distanz der Punkte
        Collections.sort(pointDistances);
        List<PointDistance> resultingPoints = pointDistances.subList(0, k);

        //Durchlaufe die naechsten k Punkte und zaehle den Klassen Counter hoch
        System.out.println("Klassen der nächsten k Punkte");
        for (PointDistance pd : resultingPoints) {
            int getClass = pd.getPoint().getClassOfPoint();
            System.out.println("Klasse: " + getClass);
            if (getClass == 0) {
                classes[0]++;
            } else {
                classes[1]++;
            }
        }

        //Ueberpruefe, wie viele Punkte einer Klasse naeher sind
        if (classes[0] > classes[1]) {
            return 0;
        } else {
            return 1;
        }

    }
}