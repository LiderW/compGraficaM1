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

    public ArrayList<Point2D> bresenham(int p0, int p1){
        ArrayList<Point2D> bresenhamLine = new ArrayList<>();

        int x0 = (int)points[p0].getX();
        int y0 = (int)points[p0].getY();
        int x1 = (int)points[p1].getX();
        int y1 = (int)points[p1].getY();

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx-dy;
        int e2;

        while(true)
        {
            bresenhamLine.add(new Point2D.Double(x0,y0));

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

        return bresenhamLine;
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