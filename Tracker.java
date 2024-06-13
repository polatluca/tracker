import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Tracker {

    private static boolean running = true;

    public static void main(String[] args) {
        try {

            Robot robot = new Robot();


            JFrame frame = new JFrame();
            frame.setSize(200, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);


            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        running = false;
                        frame.dispose(); 
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {}
            });


            int centerX = 500;
            int centerY = 500;
            int radius = 100;

            while (running) {
                for (int angle = 0; angle < 360; angle++) {
                    if (!running) break;
                    double radian = Math.toRadians(angle);
                    int x = centerX + (int) (radius * Math.cos(radian));
                    int y = centerY + (int) (radius * Math.sin(radian));
                    robot.mouseMove(x, y);
                    robot.delay(10); 
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
