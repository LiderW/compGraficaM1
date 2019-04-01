import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing {

    private JPanel canvas;

    public static void bresenham(Point2D p0, Point2D p1){
        final BufferedImage img = new BufferedImage(1000, 800,
                BufferedImage.TYPE_INT_RGB);

        int x0 = (int)p0.getX();
        int y0 = (int)p0.getY();
        int x1 = (int)p1.getX();
        int y1 = (int)p1.getY();

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx-dy;
        int e2;

        while(true)
        {
            img.setRGB(x0, y0, Color.YELLOW.getRGB());

            if (x0 == x1 && y0 == y1)
                break;

            e2 = 2 * err;
            if (e2 > -dy)
            {
                err = err - dy;
                x0 = x0 + sx;
            }

            if (e2 < dx)
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }
        };


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setTitle("Bresenham");

        Graphics g = img.getGraphics();
        g.drawPolygon(new int[0], new int [0], 0);

        g.dispose();
        canvas.repaint();
    }
    
}
