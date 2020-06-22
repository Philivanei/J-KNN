package KNN;

import java.util.*;

public class KNearestNeighbour {

    private final int k;

    public KNearestNeighbour(int k) {
        this.k = k;
    }

    public int calculateKNearestNeighbour(Point unclassifiedPoint, ArrayList<Point> points) {

        int[] classes = new int[2];
        CalculateDistanceHelper distance = new CalculateDistanceHelper();
        List<PointDistance> pointDistances = new ArrayList<>();

        //Calculate distance of every point separately to unclassified point and save the point with the calculated
        //distance
        for (Point p : points) {
            pointDistances.add(new PointDistance(p, distance.getEuclideanDistance(unclassifiedPoint, p)));
        }

        //Sorts list ascended by the value of the distance
        Collections.sort(pointDistances);
        List<PointDistance> resultingPoints = pointDistances.subList(0, k);

        //Run through the k-nearest points and count up the class counter
        System.out.println("Classes of the k nearest points:");
        for (PointDistance pd : resultingPoints) {
            int getClass = pd.getPoint().getClassOfPoint();
            System.out.println("Class: " + getClass);
            if (getClass == 0) {
                classes[0]++;
            } else {
                classes[1]++;
            }
        }

        //Validate how many points of which class are nearer
        if (classes[0] > classes[1]) {
            return 0;
        } else {
            return 1;
        }

    }
}