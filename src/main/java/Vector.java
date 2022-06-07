import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector normalize() {
        double vectorLength = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return new Vector(x / vectorLength, y / vectorLength, z / vectorLength);
    }


    public double scalarProduct(Vector v) {
        double product = x * v.getX() + y * v.getY() + z * v.getZ();
        return product < 0 ? Math.abs(product) : 0;
    }
}
