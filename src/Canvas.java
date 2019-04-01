import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Canvas {

    private JFrame frame;
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
        panel.add(button);
    }

    public void draw(Polygon polygon){
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        if(!frame.isVisible())
            frame.setVisible(true);
        Graphics g = image.getGraphics();
        g.drawPolygon(polygon.getXPoints(), polygon.getYPoints(), polygon.getPolygon().length);
        g.dispose();
        panel.repaint();
    }

    public JButton getLastButton(){
        return buttons.get(buttons.size() - 1);
    }

    public void hide(){
        frame.setVisible(false);
    }
}
