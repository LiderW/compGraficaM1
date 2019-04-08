import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Canvas canvas = new Canvas("Trabalho M1");
        Polygon polygon;

        Scanner scan = new Scanner(System.in);

        Point2D[] points = new Point2D[3];

        for(int i = 0; i < points.length; i++){
            System.out.printf("\nEntre com coordenadas X e Y do ponto %d:\n", i);
            int x = scan.nextInt();
            int y = scan.nextInt();

            points[i] = new Point2D.Double();
            points[i].setLocation(x, y);
        }

        polygon = new Polygon(points);
		canvas.createButton("Translate");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entre com a quantidade em X e Y a ser deslocada:\n");
                int amountX = scan.nextInt();
                int amountY = scan.nextInt();
                polygon.translate(amountX, amountY);
                canvas.draw(polygon);
            }
        });

        canvas.createButton("Scale");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entre com a quantidade a ser escalada:\n");
                float amount = scan.nextFloat();
                polygon.scale(amount);
                canvas.draw(polygon);
            }
        });

        canvas.createButton("Rotate");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entre com a quantidade a ser rotacionada:\n");
                int amount = scan.nextInt();
                polygon.rotate(amount);
                canvas.draw(polygon);
            }
        });

        canvas.createButton("Bresenham");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Entre com 2 pontos:\n");
                int p0 = scan.nextInt();
                int p1 = scan.nextInt();
                canvas.drawBresenham(polygon.bresenham(p0,p1));
            }
        });

        canvas.createButton("3D Cube");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setTitle("Rotating Cube");
                    f.setResizable(false);
                    f.add(new RotatingCube(0), BorderLayout.CENTER);
                    f.pack();
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                });
            }
        });

        canvas.createButton("Bugged 3D Cube");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setTitle("Rotating Cube");
                    f.setResizable(false);
                    f.add(new RotatingCube(1), BorderLayout.CENTER);
                    f.pack();
                    f.setLocationRelativeTo(null);
                    f.setVisible(true);
                });
            }
        });

        canvas.createButton("Test Raytracing");
        canvas.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.raytrace();
            }
        });

        canvas.draw(polygon);
    }
}
