package KNN;

import java.util.ArrayList;

/**
 * The ButtonAction class contains the actions performed by the buttons.
 */
public class ButtonAction {

    private Point unclassifiedPoint;
    private ArrayList<Point> classifiedPoints;

    /**
     * The constructor of ButtonAction.
     */
    public ButtonAction() {

    }

    /**
     * Creates random points that should be analysed. It creates classified points and one unclassified point.
     */
    public void createTestData() {
        ArrayList<Point> points = new ArrayList<>();
        //10 test elements are created.
        for (int i = 0; i < 10; i++) {
            int x;
            int y;
            int theClass;
            if (i < 5) {
                theClass = 0;
            } else {
                theClass = 1;
            }

            //Random grouping of the test points.
            if (theClass == 1) {
                //are located at x = 5 to 7 and y = 5 to 7.
                x = (5 + ((int) (Math.random() * 3)));
                y = (5 + ((int) (Math.random() * 3)));
            } else {
                //are located at x = 0 to 2 and y = 0 to 2.
                x = ((int) (Math.random() * 3));
                y = ((int) (Math.random() * 3));
            }
            points.add(new Point(x, y, theClass));
            classifiedPoints = points;

            System.out.println("Determined point " + i + ": x " + x + " y " + y + " class " + theClass);
        }

        //unclassified random point.
        //The random point is located at x = 0 to 7 and y = 0 to 7.
        int ux = ((int) (Math.random() * 8));
        int uy = ((int) (Math.random() * 8));
        this.unclassifiedPoint = new Point(ux, uy);
        System.out.println("\nUnclassified random point: x " + ux + " y " + uy + "\n");
    }

    /**
     * Gets the values of the unclassified point.
     *
     * @return The unclassified point.
     */
    public Point getUnclassifiedPoint() {
        return unclassifiedPoint;
    }

    /**
     * Gets the list of the classified points.
     *
     * @return The classified points.
     */
    public ArrayList<Point> getClassifiedPoints() {
        return classifiedPoints;
    }

    /**
     * Calculates the result of the k-nearest-neighbour analysis.
     *
     * @param k The count of neighbour that should be analysed.
     */
    public void getKNearestNeighbour(int k) {
        KNearestNeighbour nearest = new KNearestNeighbour(k);
        System.out.println("\nClassified in class: " + nearest.calculateKNearestNeighbour(unclassifiedPoint,
                classifiedPoints));
    }
}
