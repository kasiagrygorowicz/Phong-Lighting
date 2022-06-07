import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener{

    private DrawPanel panel;

    public Main() {

        setSize(1600, 800);
        setPreferredSize(new Dimension(1600, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setLocationRelativeTo(null);
        panel = new DrawPanel();


        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }



    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){


            case KeyEvent.VK_UP -> panel.moveLightSource(LightMovement.UP);
            case KeyEvent.VK_DOWN ->  panel.moveLightSource(LightMovement.DOWN);
            case KeyEvent.VK_RIGHT -> panel.moveLightSource(LightMovement.RIGHT);
            case KeyEvent.VK_LEFT -> panel.moveLightSource(LightMovement.LEFT);
            case KeyEvent.VK_I -> panel.moveLightSource(LightMovement.FORWARDS);
            case KeyEvent.VK_O -> panel.moveLightSource(LightMovement.BACKWARDS);


        }

        panel.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new Main();
    }
}
