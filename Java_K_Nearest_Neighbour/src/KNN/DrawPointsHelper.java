package KNN;

import org.math.plot.Plot2DPanel;

import java.awt.*;
import java.util.ArrayList;

/**
 * The DrawPointsHelper class draws the random generated points to the GUI.
 */
public class DrawPointsHelper {

    private final double crossSize;

    /**
     * The constructor of the DrawPointsHelper class.
     *
     * @param crossSize The cross size of the points (the are visualized as crosses).
     */
    public DrawPointsHelper(double crossSize) {

        this.crossSize = crossSize;
    }

    /**
     * Visualizes the crosses of the classified generated points.
     *
     * @param points List of random generated classified points.
     * @param plot   The plot that should show the points.
     */
    public void drawClassifiedPoints(ArrayList<Point> points, Plot2DPanel plot) {

        for (Point p : points) {
            if (p.getClassOfPoint() == 0) {
                plot.addLinePlot("", Color.ORANGE, new double[]{p.getX() - crossSize, p.getY() - crossSize},
                        new double[]{p.getX() + crossSize, p.getY() + crossSize});
                plot.addLinePlot("", Color.ORANGE, new double[]{p.getX() + crossSize, p.getY() - crossSize},
                        new double[]{p.getX() - crossSize, p.getY() + crossSize});
            } else {
                plot.addLinePlot("", Color.GREEN, new double[]{p.getX() - crossSize, p.getY() - crossSize},
                        new double[]{p.getX() + crossSize, p.getY() + crossSize});
                plot.addLinePlot("", Color.GREEN, new double[]{p.getX() + crossSize, p.getY() - crossSize},
                        new double[]{p.getX() - crossSize, p.getY() + crossSize});
            }
        }
    }

    /**
     * Visualizes the cross of the unclassified generated point.
     *
     * @param point Values of the unclassified point.
     * @param plot  The plot that should show the point.
     */
    public void drawUnclassifiedPoint(Point point, Plot2DPanel plot) {

        plot.addLinePlot("", Color.RED, new double[]{point.getX() - crossSize,
                point.getY() - crossSize}, new double[]{point.getX() + crossSize, point.getY() + crossSize});
        plot.addLinePlot("", Color.RED, new double[]{point.getX() + crossSize,
                point.getY() - crossSize}, new double[]{point.getX() - crossSize, point.getY() + crossSize});
    }

}
