package KNN;

import java.util.*;

public class KNearestNeighbour {

    // Die k naechsten Nachbarn
    private int k;

    public KNearestNeighbour(int k) {

        this.k = k;
    }

    public int calculateKNearestNeighbour(Point unclassifiedPoint, ArrayList<Point> points) {

        //TODO: Groesse der Klassenanzahl angeben
        int[] classes = new int[2];
        CalculateDistanceHelper distance = new CalculateDistanceHelper();
        List<PointDistance> pointDistances = new ArrayList<>();

        /* Berechne fuer jeden Punkt die Distanz zum unklassifizierten Punkt und speicher ihn in pointDistances mit
        der berechneten Distanz */
        for (Point p : points) {
            pointDistances.add(new PointDistance(p, distance.getEuclideanDistance(unclassifiedPoint, p)));
        }

        //Sortiere die Liste aufsteigend nach der Distanz der Punkte
        Collections.sort(pointDistances);
        List<PointDistance> resultingPoints = pointDistances.subList(0, k);
        //System.out.println(resultingPoints.get(i).getPoint().getKlasse());

        //Durchlaufe die naechsten k Punkte und zaehle den Klassen Counter hoch
        for (PointDistance pd : resultingPoints) {
            int klasse = pd.getPoint().getKlasse();
            //TODO: Debug Ausgabe entfernen
            System.out.println(klasse);
            if (klasse == 0) {
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