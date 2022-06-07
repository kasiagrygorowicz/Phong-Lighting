import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class DrawPanel extends JPanel {

    private Point3D observer;
    private LightEmitter light;
    private ArrayList<Material> materials;
    private int r = 150;

    public DrawPanel() {
        this.materials = new ArrayList<>();
        // brass
        Material material1 = new Material(0.329412, 0.780392, 0.992157, 27.8974, Color.decode("#E1C16E"));
        // copper
        Material material2 = new Material(0.19125, 0.7038, 0.256777, 12.8, Color.decode("#B87333"));
        // something
        Material material3 = new Material(0.3, 0.7, 0.4, 20, Color.BLUE);
        Collections.addAll(materials, material1, material2, material3);

        setSize(1600, 800);
        setPreferredSize(new Dimension(1600, 800));
        setBackground(Color.BLACK);
        this.observer = new Point3D(-50, -50, 220);
        this.light = new LightEmitter(0.7, new Point3D(200, 180, -450), 0.9);
    }

    @Override
    public void paint(Graphics g) {
        int start = 200;
        int step = 400;
        super.paint(g);
        for (Material material : materials) {
            draw(material, start, g);
            start += step;
        }
    }

    private void draw(Material material, int step, Graphics g) {
        for (int i = -r; i <= r; i++) {
            double x = i + 0.5;
            for (int j = -r; j <= r; j++) {
                double y = j + 0.5;
                if (x * x + y * y <= r * r) {
                    double z = Math.sqrt(r * r - x * x - y * y);
                    Vector normalVector = new Vector(2 * x, 2 * y, 2 * z);
                    double lightIntensity = PhongModel.getLight(observer, normalVector, light, material);
                    Color color = material.getColor();
                    g.setColor(new Color(Math.min((int) (color.getRed() * lightIntensity), 255),
                            Math.min((int) (color.getGreen() * lightIntensity), 255),
                            Math.min((int) (color.getBlue() * lightIntensity), 255))
                    );
                    g.drawRect(i + r + step, j + r + 200, 1, 1);
                }
            }
        }
    }


    public void moveLightSource(LightMovement movement) {
        int n = 50;
        switch (movement) {
            case UP -> light.getCoordinates().setY(light.getCoordinates().getY() + n);
            case DOWN -> light.getCoordinates().setY(light.getCoordinates().getY() - n);
            case RIGHT -> light.getCoordinates().setX(light.getCoordinates().getX() + n);
            case LEFT -> light.getCoordinates().setX(light.getCoordinates().getX() - n);
            case FORWARDS -> light.getCoordinates().setZ(light.getCoordinates().getZ() + n);
            case BACKWARDS -> light.getCoordinates().setZ(light.getCoordinates().getZ() - n);
        }
        this.repaint();
    }
}
