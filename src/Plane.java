public class Plane extends ThreeDimensionalObject{

    Point3D point;
    Normal normal;

    public Plane(Point3D point, Normal normal){
        this.point = new Point3D(point);
        this.normal = new Normal(normal);
    }

    @Override
    public double hit(Ray ray) {
        double t = point.subPoint(ray.origin).dot(normal.vector) / ray.direction.dot(normal.vector);

        if(t > 10E-9){
            return t;
        } else {
            return 0.0;
        }
    }
}
