package KNN;

public class CalculateDistanceHelper {

    public CalculateDistanceHelper() {

    }

    //Calculates the euclidean distance with point values
    public double getEuclideanDistance(Point unclassifiedPoint, Point classifiedPoint) {
        return getEuclideanDistance(unclassifiedPoint.getX(), unclassifiedPoint.getY(),
                classifiedPoint.getX(), classifiedPoint.getY());
    }

    //Calculates the euclidean distance with coordinate values
    public double getEuclideanDistance(int unclassifiedX, int unclassifiedY, int referenceX, int referenceY) {
        return Math.pow(unclassifiedX - referenceX, 2) + Math.pow(unclassifiedY - referenceY, 2);
    }

}
