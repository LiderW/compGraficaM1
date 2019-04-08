public class Normal {

    public Vector3D vector;

    public Normal(double x, double y, double z){
        vector.x = x;
        vector.y = y;
        vector.z = z;
    }

    public Normal(Normal normal){
        vector.x = normal.vector.x;
        vector.y = normal.vector.y;
        vector.z = normal.vector.z;
    }
}
