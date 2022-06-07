import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Vector {
    private double x;
    private double y;
    private double z;


    public Vector normalize() {
        double v = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return new Vector(x/v, y/v, z/v);
    }


    public double scalarProduct(Vector v)
    {
        double pr = x * v.getX() + y * v.getY() + z * v.getZ();
        return pr < 0 ? -pr : 0;
    }
}
