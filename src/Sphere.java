import java.awt.*;

public class Sphere extends ThreeDimensionalObject{

    public Point3D center;
    public double radius;
    public Color color;

    public Sphere(Point3D center, double radius, Color color){
        this.center = new Point3D(center);
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double hit(Ray ray){
        double a = ray.direction.dot(ray.direction);
        double b = 2*ray.origin.subPoint(center).dot(ray.direction);
        double c = ray.origin.subPoint(center).dot(ray.origin.subPoint(center)) - radius*radius;
        double delta = b*b - 4*a*c;

        if(delta < 0.0){
            return 0.0;
        } else {
            double t =  (-b - Math.sqrt(delta))/(2*a);

            if(t >10E-9){
                return t;
            } else {
                return 0.0;
            }
        }
    }

}
