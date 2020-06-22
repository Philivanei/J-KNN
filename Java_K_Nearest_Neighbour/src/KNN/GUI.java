package KNN;

import org.math.plot.Plot2DPanel;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private final int k;
    private final double crossSize;
    private final int[] coor;

    public GUI(int k, int[] coor, double crossSize) {

        this.k = k;
        this.crossSize = crossSize;
        this.coor = coor;
    }

    public void showUI() {

        //Create layout of menu
        final int width = 600;
        final int height = 600;

        setTitle("Menu");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        buttons();
    }

    private void buttons() {

        //Create layout of the buttons
        final int x = 200;
        final int[] y = {200, 300};
        final int[] size = {200, 40};
        JButton drawEu = new JButton("Euclidean distance");
        JButton close = new JButton("Close");
        drawEu.setBounds(x, y[0], size[0], size[1]);
        close.setBounds(x, y[1], size[0], size[1]);

        Container cont = getContentPane();
        GroupLayout group = new GroupLayout(cont);
        cont.setLayout(group);

        cont.add(close);
        cont.add(drawEu);

        //Call of the action listener
        buttonExit(close);
        buttonEucl(drawEu);
    }

    private void buttonEucl(JButton button) {
        button.addActionListener(e -> {
            Plot2DPanel plot = new Plot2DPanel();
            DrawPointsHelper draw = new DrawPointsHelper(crossSize);
            ButtonAction buttonAction = new ButtonAction();

            buttonAction.createTestData();
            buttonAction.getKNearestNeighbour(k);

            //Draw coordinate system with points
            drawCoordinateSystem(plot);
            draw.drawUnclassifiedPoint(buttonAction.getUnclassifiedPoint(), plot);
            draw.drawClassifiedPoints(buttonAction.getClassifiedPoints(), plot);
        });
    }

    private void buttonExit(JButton button) {
        button.addActionListener(e -> System.exit(1));
    }

    //Coordinate system of GUI
    private void drawCoordinateSystem(Plot2DPanel plot) {

        final int width = 1000;
        final int height = 1000;

        //Set resolution of the coordinate system
        plot.addLinePlot("", new double[]{coor[0], coor[0]}, new double[]{coor[0], coor[0]});
        plot.addLinePlot("", new double[]{coor[1], coor[1]}, new double[]{coor[1], coor[1]});

        //Layout of coordinate system
        JFrame frame = new JFrame("KNearestNeighbour");
        frame.setContentPane(plot);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
