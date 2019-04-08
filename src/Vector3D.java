public class Vector3D {

    public double x, y ,z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector3D vector){
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    public Vector3D addVector3D(Vector3D vector){
        return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector3D subVector3D(Vector3D vector){
        return new Vector3D(x - vector.x, y - vector.y, z - vector.z);
    }

    public double dot(Vector3D vector){
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    public double dot(Point3D point){
        return (x * point.x + y * point.y + z * point.z);
    }

    public void normalize(){
        double magnitude = Math.sqrt(x*x + y*y + z*z);

        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
    }

}
