import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage playerImage, backGroundImage;
//    double playerX;
//    double playerY;
    Vector2D playerPosition;
    int backGroundY;

    public GamePanel() {
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        playerX = 170;
//        playerY = 400;
        playerPosition = new Vector2D(175, 500);
        backGroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        backGroundY = backGroundImage.getHeight()*(-1)+600;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backGroundImage,0, backGroundY,null);
        g.drawImage(playerImage, (int)playerPosition.x, (int)playerPosition.y, null);
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > (1000 / 60)) {
                // run logic
                this.runAll();
                // render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
    public void runAll(){
        //player run
        if(KeyEventPress.isUpPress) {
            playerPosition.y-=5;
        }if(KeyEventPress.isDownPress) {
            playerPosition.y+=5;
        }if(KeyEventPress.isLeftPress) {
            playerPosition.x-=5;
        }if(KeyEventPress.isRightPress) {
            playerPosition.x+=5;
        }

        playerPosition.x = Mathx.clamp(playerPosition.x,-5, 384-25);
        playerPosition.y = Mathx.clamp(playerPosition.y, 0, 600-48);


        //background run
        if (backGroundY <= 0) {
            backGroundY++;
        }
    }
}
