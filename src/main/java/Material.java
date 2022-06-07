import java.awt.*;

public class Material {
    private double backgroundCoefficient;
    private double directionCoefficient;
    private double scatterCoefficient;

    private double n;
    private Color color;

    public Material(double backgroundCoefficient, double directionCoefficient, double scatterCoefficient, double n, Color color) {
        this.backgroundCoefficient = backgroundCoefficient;
        this.directionCoefficient = directionCoefficient;
        this.scatterCoefficient = scatterCoefficient;

        this.n = n;
        this.color = color;
    }

    public double getBackgroundCoefficient() {
        return backgroundCoefficient;
    }

    public double getDirectionCoefficient() {
        return directionCoefficient;
    }

    public double getScatterCoefficient() {
        return scatterCoefficient;
    }

    public double getN() {
        return n;
    }

    public Color getColor() {
        return color;
    }
}
