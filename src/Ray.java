public class Ray {
    Point3D origin;
    Vector3D direction;

    public Ray(Point3D origin, Vector3D direction){
        this.origin = new Point3D(origin);
        this.direction = new Vector3D(direction);
    }
}
