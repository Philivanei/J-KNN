package KNN;

import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;

/**
 * The GUI class draws a user interface and calls all necessary functions for the analysis.
 */
public class GUI extends JFrame {

    private final int k;
    private final double crossSize;
    private final int[] cor;

    /**
     * The constructor of the GUI class.
     *
     * @param k         Count of Neighbors, that should be analysed.
     * @param cor       Resolution of the coordinate system.
     * @param crossSize Size of the crosses in the coordinate system.
     */
    public GUI(int k, int[] cor, double crossSize) {

        this.k = k;
        this.crossSize = crossSize;
        this.cor = cor;
    }

    /**
     * Creates a menu GUI and sets its parameters like the size.
     */
    public void showMenu() {

        //Create layout of menu.
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

    /**
     * Creates buttons on the menu GUI and sets their layout values. The action listener gets called in another method.
     */
    private void buttons() {

        //Create layout of the buttons.
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

        //Call of the action listener.
        buttonExit(close);
        buttonEucl(drawEu);
    }

    /**
     * Calls the action listener of the button and executes the k-nearest-neighbor analysis.
     *
     * @param button Gets the values of the euclidean distance button.
     */
    private void buttonEucl(JButton button) {
        button.addActionListener(e -> {
            Plot2DPanel plot = new Plot2DPanel();
            DrawPointsHelper draw = new DrawPointsHelper(crossSize);
            ButtonAction buttonAction = new ButtonAction();

            buttonAction.createTestData();
            buttonAction.getKNearestNeighbour(k);

            //Draw coordinate system with points.
            drawCoordinateSystem(plot);
            draw.drawUnclassifiedPoint(buttonAction.getUnclassifiedPoint(), plot);
            draw.drawClassifiedPoints(buttonAction.getClassifiedPoints(), plot);
        });
    }

    /**
     * Calls the action listener of the button and can stop the program.
     *
     * @param button Gets the values of the close distance button.
     */
    private void buttonExit(JButton button) {
        button.addActionListener(e -> System.exit(1));
    }

    /**
     * This method draws a coordinate system to see the generated points of the analysis. It will appear in a new
     * Frame.
     *
     * @param plot The plot that should be displayed.
     */
    private void drawCoordinateSystem(Plot2DPanel plot) {

        final int width = 1000;
        final int height = 1000;

        //Set resolution of the coordinate system.
        plot.addLinePlot("", new double[]{cor[0], cor[0]}, new double[]{cor[0], cor[0]});
        plot.addLinePlot("", new double[]{cor[1], cor[1]}, new double[]{cor[1], cor[1]});

        //Layout of coordinate system.
        JFrame frame = new JFrame("KNearestNeighbour");
        frame.setContentPane(plot);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

}
