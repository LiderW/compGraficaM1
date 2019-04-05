import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Canvas {

    private JFrame frame;
    private JPanel buttonsPanel;
    private JPanel panel;
    private ArrayList<JButton> buttons;
    private BufferedImage image;
    private ArrayList<Rectangle> gridRectangles;

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 780;

    public Canvas (String title){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };
        panel.setBackground(Color.BLACK);

        buttonsPanel = new JPanel();
        buttonsPanel.setSize(WIDTH, 50);

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.NORTH);
        frame.setTitle(title);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(false);

        buttons = new ArrayList<>();
        gridRectangles = new ArrayList<>();
    }

    public void createButton(String buttonName){
        JButton button = new JButton(buttonName);
        buttons.add(button);
        buttonsPanel.add(button);
    }

    public void draw(Polygon polygon){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        g.drawPolygon(polygon.getXPoints(), polygon.getYPoints(), polygon.getPolygon().length);
        g.dispose();
        panel.repaint();
        if(!frame.isVisible())
            frame.setVisible(true);
    }
    
    public void drawBresenham(ArrayList<Point2D> bresenhamLine){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };

        panel.setBackground(Color.BLACK);

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.NORTH);
        frame.setTitle("test");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(false);

        Graphics g = image.getGraphics();

        /*for(int j = 40; j < HEIGHT; j += 40){
            g.drawLine(0, j, WIDTH, j);
        }

        for(int i = 40; i < WIDTH; i += 40){
            g.drawLine(i, 0, i, HEIGHT);
        }*/

        int rectangleSize = 40;

        for(int i = 0; i < WIDTH; i += 40){
            for(int j = 0; j < HEIGHT; j += 40){
                gridRectangles.add(new Rectangle(i, j, rectangleSize, rectangleSize));
                g.drawRect(i, j, 40, 40);
            }
        }

        int fillSize = rectangleSize / 2;
        for (Point2D point:bresenhamLine){
            for (Rectangle r:gridRectangles) {
                if(r.contains(point.getX(), point.getY()) && r.getX() != point.getX() && r.getY()!= point.getY()) {
                    g.setColor(Color.gray);
                    g.fillRect(r.x + fillSize/2, r.y + fillSize/2, fillSize, fillSize);
                }
            }
            //g.setColor(Color.yellow);
            //g.fillRect((int)point.getX(), (int)point.getY(), 1, 1);
            image.setRGB((int)point.getX(), (int)point.getY(), Color.yellow.getRGB());
        }

        g.drawImage(image, WIDTH, HEIGHT, null);

        g.dispose();
        panel.repaint();
        if(!frame.isVisible())
            frame.setVisible(true);
    }

    public JButton getLastButton(){
        return buttons.get(buttons.size() - 1);
    }

    public void hide(){
        frame.setVisible(false);
    }
}
