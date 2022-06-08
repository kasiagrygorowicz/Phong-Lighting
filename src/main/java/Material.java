import java.awt.*;

public class Material {
    private double backgroundCoefficient;
    private double scatterCoefficient;
    private double directionCoefficient;

    private double n;
    private Color color;

    public Material(double backgroundCoefficient, double scatterCoefficient, double directionCoefficient, double n, Color color) {
        this.backgroundCoefficient = backgroundCoefficient;
        this.directionCoefficient = directionCoefficient;
        this.scatterCoefficient = scatterCoefficient;
        this.n = n;
        this.color = color;
    }

    public double getBackgroundCoefficientKa() {
        return backgroundCoefficient;
    }

    public double getDirectionCoefficientKs() {
        return directionCoefficient;
    }

    public double getScatterCoefficientKd() {
        return scatterCoefficient;
    }

    public double getN() {
        return n;
    }

    public Color getColor() {
        return color;
    }
}
