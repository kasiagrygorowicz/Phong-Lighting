public class PhongModel {

    public static double getLight(Point3D observer, Vector normalVector, LightEmitter lightSource, Material material) {
        Vector observerVector = new Vector(observer.getX() - normalVector.getX(), observer.getY() - normalVector.getY(), observer.getZ() - normalVector.getZ());
        Vector lightVector = new Vector(lightSource.getCoordinates().getX() - normalVector.getX(), lightSource.getCoordinates().getY() - normalVector.getY(), lightSource.getCoordinates().getZ() - normalVector.getZ());

        Vector lightVectorNormalized = lightVector.normalize();
        Vector normalizedNormal = normalVector.normalize();
        Vector refNormalized = reflection(lightVectorNormalized, normalizedNormal).normalize();
        Vector observerNormalized = observerVector.normalize();

        return lightSource.getAmbientIntensity() * material.getBackgroundCoefficient() +
               lightSource.getIlluminationIntensity() * material.getDirectionCoefficient() * normalizedNormal.scalarProduct(lightVectorNormalized) +
               lightSource.getIlluminationIntensity() * material.getScatterCoefficient() * Math.pow(refNormalized.scalarProduct(observerNormalized), material.getN());
    }

    private static Vector reflection(Vector lightVecNormalized, Vector normalNormalized) {
        double product = lightVecNormalized.scalarProduct(normalNormalized);

        double x = 2 * product * normalNormalized.getX() - lightVecNormalized.getX();
        double y = 2 * product * normalNormalized.getY() - lightVecNormalized.getY();
        double z = 2 * product * normalNormalized.getZ() - lightVecNormalized.getZ();

        return new Vector(x, y, z);
    }
}
