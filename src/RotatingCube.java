import java.awt.*;
import java.awt.event.ActionEvent;
import static java.lang.Math.*;
import javax.swing.*;

public class RotatingCube extends JPanel {
    double[][] nodes = {{-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
            {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}};

    int[][] edges = {{0, 1}, {1, 3}, {3, 2}, {2, 0}, {4, 5}, {5, 7}, {7, 6},
            {6, 4}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};

    int type;

    public RotatingCube(int type) {
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.BLACK);

        scale(100);
        //rotateCube(PI / 4, atan(sqrt(2)));

        this.type = type;

        new Timer(17, (ActionEvent e) -> {
            rotateCube(PI / 180, PI / 180);
            repaint();
        }).start();
    }

    final void scale(double s) {
        for (double[] node : nodes) {
            node[0] *= s;
            node[1] *= s;
            node[2] *= s;
        }
    }

    final void rotateCube(double angleX, double angleY) {
        double sinX = sin(angleX);
        double cosX = cos(angleX);

        double sinY = sin(angleY);
        double cosY = cos(angleY);

        for (double[] node : nodes) {
            double x = node[0];
            double y = node[1];
            double z = node[2];

            node[0] = x * cosX - z * sinX;
            node[2] = z * cosX + x * sinX;

            z = node[2];

            node[1] = y * cosY - z * sinY;
            node[2] = z * cosY + y * sinY;
        }
    }

    void drawCube(Graphics2D g) {
        g.translate(getWidth() / 2, getHeight() / 2);
        g.setColor(Color.WHITE);
        if(type == 0) {
            for (int[] edge : edges) {
                double[] xy1 = nodes[edge[0]];
                double[] xy2 = nodes[edge[1]];
                g.drawLine((int) round(xy1[0]), (int) round(xy1[1]),
                        (int) round(xy2[0]), (int) round(xy2[1]));
            }
        } else {
            double[] xy1 = new double[3];
            double[] xy2 = new double[3];
            double[] xz1 = new double[3];
            double[] xz2 = new double[3];
            for (int i = 0; i < edges.length-1; i++) {
                if(i/2 % 2 == 0){
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.gray);
                }
                xy1 = nodes[edges[i][0]];
                xy2 = nodes[edges[i][1]];
                i++;
                xz1 = nodes[edges[i][0]];
                xz2 = nodes[edges[i][1]];

                int x[] = {(int) xy1[0], (int) xy2[0], (int) xz1[0], (int) xz2[0]};
                int y[] = {(int) xy1[1], (int) xy2[1], (int) xz1[1], (int) xz2[1]};

                g.fillPolygon(x, y, x.length);
            }
        }
        g.setColor(Color.GREEN);
        for (double[] node : nodes)
            g.fillOval((int) round(node[0]) - 4, (int) round(node[1]) - 4, 8, 8);
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        drawCube(g);
    }
}