public class PhongModel {

    public static double getLight(Point3D observer, Vector normalVector, LightEmitter lightSource, Material material) {
        Vector observerVector = new Vector(observer.getX() - normalVector.getX(), observer.getY() - normalVector.getY(), observer.getZ() - normalVector.getZ());
        Vector lightVector = new Vector(lightSource.getCoordinates().getX() - normalVector.getX(), lightSource.getCoordinates().getY() - normalVector.getY(), lightSource.getCoordinates().getZ() - normalVector.getZ());

        Vector lightVectorNormalized = lightVector.normalize();
        Vector normalVectorNormalized = normalVector.normalize();
        Vector reflectionVectorNormalized = perfectReflectionVector(lightVectorNormalized, normalVectorNormalized).normalize();
        Vector observerVectorNormalized = observerVector.normalize();

        return lightSource.getAmbientIntensity() * material.getBackgroundCoefficientKa() +
               lightSource.getIlluminationIntensity() * material.getScatterCoefficientKd() * normalVectorNormalized.scalarProduct(lightVectorNormalized) +
               lightSource.getIlluminationIntensity() * material.getDirectionCoefficientKs() * Math.pow(reflectionVectorNormalized.scalarProduct(observerVectorNormalized), material.getN());
    }

    private static Vector perfectReflectionVector(Vector lightVecNormalized, Vector normalNormalized) {
        double product = lightVecNormalized.scalarProduct(normalNormalized);

        double x = -(lightVecNormalized.getX() - 2 * product * normalNormalized.getX());
        double y = -(lightVecNormalized.getY() - 2 * product * normalNormalized.getY());
        double z = -(lightVecNormalized.getZ() - 2 * product * normalNormalized.getZ());

        return new Vector(x, y, z);
    }
}
