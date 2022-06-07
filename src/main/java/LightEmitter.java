public class LightEmitter {
    private double illuminationIntensity;
    private double ambientIntensity;
    private Point3D coordinates;

    public LightEmitter(double ambientIntensity, Point3D coordinates, double illumination) {
        this.ambientIntensity = ambientIntensity;
        this.coordinates = coordinates;
        this.illuminationIntensity = illumination;
    }

    public Point3D getCoordinates() {
        return coordinates;
    }

    public double getAmbientIntensity() {
        return ambientIntensity;
    }

    public double getIlluminationIntensity() {
        return illuminationIntensity;
    }
}
