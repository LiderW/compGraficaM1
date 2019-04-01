import javax.swing.*;
import java.awt.geom.Point2D;
import java.lang.Math;
import java.util.ArrayList;

public class Polygon {

    private Point2D[] points;

    public Polygon(Point2D[] points){
        this.points = points;
    }

    public void translate(int ammountX, int ammountY){
        for(int i = 0; i < points.length; i++)
        {
            points[i].setLocation(points[i].getX() + ammountX, points[i].getY() + ammountY);
        }
    }

    public void scale(float ammount){
        for(int i = 0; i < points.length; i++)
        {
            points[i].setLocation(points[i].getX() * ammount, points[i].getY() * ammount);
        }
    }

    public void rotate(int ammount){
        double grau = Math.toRadians(ammount);
        int originX = (int)points[0].getX();
        int originY = (int)points[0].getY();

        translate(-originX, -originY);

        for(int i = 0; i < points.length; i++)
        {
            int auxX = (int)points[i].getX();
            int auxY = (int)points[i].getY();

            int newX = (int)(auxX * Math.cos(grau) - auxY * Math.sin(grau));
            int newY = (int)(auxY * Math.cos(grau) + auxX * Math.sin(grau));

            points[i].setLocation(newX, newY);
        }

        translate(originX, originY);
    }

    public int[] getXPoints(){
        int [] xPoints = new int[points.length];
        for(int i =0; i < points.length; i++){
            xPoints[i] = (int)points[i].getX();
        }

        return xPoints;
    }

    public int[] getYPoints(){
        int [] yPoints = new int[points.length];
        for(int i =0; i < points.length; i++){
            yPoints[i] = (int)points[i].getY();
        }

        return yPoints;
    }

    public Point2D[] getPolygon(){
        return points;
    }
}