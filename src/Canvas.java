import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Canvas {

    private JFrame frame;
    private JPanel buttonsPanel;
    private JPanel panel;
    private ArrayList<JButton> buttons;
    private BufferedImage image;

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
        frame.setTitle(title);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(false);

        buttons = new ArrayList<>();
    }

    public void createButton(String buttonName){
        JButton button = new JButton(buttonName);
        buttons.add(button);
        buttonsPanel.add(button);
    }

    public void draw(Polygon polygon){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        frame.add(buttonsPanel, BorderLayout.NORTH);
        Graphics g = image.getGraphics();
        g.drawPolygon(polygon.getXPoints(), polygon.getYPoints(), polygon.getPolygon().length);
        g.dispose();
        panel.repaint();
        if(!frame.isVisible())
            frame.setVisible(true);
    }
    
    public void drawBresenham(ArrayList<Point2D> bresenhamLine){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (Point2D point:bresenhamLine) {
            image.setRGB((int)point.getX(), (int)point.getY(), Color.YELLOW.getRGB());
        }
        Graphics g = image.getGraphics();
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
