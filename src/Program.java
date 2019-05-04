import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setBackground(Color.LIGHT_GRAY);

        window.add(panel);
        window.pack();
        window.setLocation(370, 100);
        window.setTitle("Game Touhou");
//        window.setSize(800, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = true;
                }if(e.getExtendedKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }if(e.getExtendedKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }if(e.getExtendedKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getExtendedKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = false;
                }if(e.getExtendedKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = false;
                }if(e.getExtendedKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                }if(e.getExtendedKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = false;
                }
            }
        };
        window.addKeyListener(keyHandler);

        window.setVisible(true);

        panel.gameLoop();
    }
}
