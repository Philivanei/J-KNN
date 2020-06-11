package KNN;

public class CalculateDistanceHelper {


    public CalculateDistanceHelper() {

    }

    //berechnet die euklidische Distanz anhand von Punkten
    public double getEuclideanDistance(Point unclassifiedPoint, Point classifiedPoint) {
        return getEuclideanDistance(unclassifiedPoint.getX(), unclassifiedPoint.getY(),
                classifiedPoint.getX(), classifiedPoint.getY());
    }

    //berechnet die euklidische Distanz anhand von einzelnen Koordinaten
    public double getEuclideanDistance(int unclassifiedX, int unclassifiedY, int referenceX, int referenceY) {
        return Math.pow(unclassifiedX - referenceX, 2) + Math.pow(unclassifiedY - referenceY, 2);
    }

    //TODO: kann noch eingebaut werden bei Bedarf
    //berechnet die Manhattan Metrik anhand von Punkten
    public double getManhattanMetrik(Point unclassifiedPoint, Point classifiedPoint){
        return getManhattanMetrik(unclassifiedPoint.getX(), unclassifiedPoint.getY(),
                classifiedPoint.getX(), classifiedPoint.getY());
    }

    //berechnet die Manhattan Metrik anhand von einzelnen Koordinaten
    public double getManhattanMetrik(int unclassifiedX, int unclassifiedY, int referenceX, int referenceY) {
        return Math.abs(unclassifiedX - referenceX) + Math.abs(unclassifiedY - referenceY);
    }

}
