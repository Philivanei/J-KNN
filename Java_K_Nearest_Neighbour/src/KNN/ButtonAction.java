package KNN;

import java.util.ArrayList;

public class ButtonAction {

    private Point unclassifiedPoint;
    private ArrayList<Point> classifiedPoints;

    public ButtonAction() {

    }

    public void createTestData() {
        ArrayList<Point> points = new ArrayList<>();
        //10 test elements are created
        for (int i = 0; i < 10; i++) {
            int x;
            int y;
            int theClass;
            if (i < 5) {
                theClass = 0;
            } else {
                theClass = 1;
            }

            //Random grouping of the test points
            if (theClass == 1) {
                //are located at x = 5 to 7 and y = 5 to 7
                x = (5 + ((int) (Math.random() * 3)));
                y = (5 + ((int) (Math.random() * 3)));
            } else {
                //are located at x = 0 to 2 and y = 0 to 2
                x = ((int) (Math.random() * 3));
                y = ((int) (Math.random() * 3));
            }
            points.add(new Point(x, y, theClass));
            classifiedPoints = points;

            System.out.println("Determined point " + i + ": x " + x + " y " + y + " class " + theClass);
        }

        //unclassified random point
        //The random point is located at x = 0 to 7 and y = 0 to 7
        int ux = ((int) (Math.random() * 8));
        int uy = ((int) (Math.random() * 8));
        this.unclassifiedPoint = new Point(ux, uy);
        System.out.println("\nUnclassified random point: x " + ux + " y " + uy + "\n");
    }

    public Point getUnclassifiedPoint() {
        return unclassifiedPoint;
    }

    public ArrayList<Point> getClassifiedPoints() {
        return classifiedPoints;
    }

    //Output of the result of k Neighbor analysis
    public void getKNearestNeighbour(int k) {
        KNearestNeighbour nearest = new KNearestNeighbour(k);
        System.out.println("\nClassified in class: " + nearest.calculateKNearestNeighbour(unclassifiedPoint,
                classifiedPoints));
    }
}
