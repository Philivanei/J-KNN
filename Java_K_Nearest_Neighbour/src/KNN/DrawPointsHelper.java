package KNN;

import org.math.plot.Plot2DPanel;

import java.awt.*;
import java.util.ArrayList;

public class DrawPointsHelper {

    double crossSize;

    public DrawPointsHelper(double crossSize) {

        this.crossSize = crossSize;
    }

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

    public void drawUnclassifiedPoint(Point point, Plot2DPanel plot) {

        plot.addLinePlot("", Color.RED, new double[]{point.getX() - crossSize,
                point.getY() - crossSize}, new double[]{point.getX() + crossSize, point.getY() + crossSize});
        plot.addLinePlot("", Color.RED, new double[]{point.getX() + crossSize,
                point.getY() - crossSize}, new double[]{point.getX() - crossSize, point.getY() + crossSize});
    }

}
