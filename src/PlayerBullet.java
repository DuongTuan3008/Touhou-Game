import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet { // PlayerBulletType2
    BufferedImage image;
    Vector2D position;
    int i;

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        position = new Vector2D();
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) position.x, (int) position.y, null);
    }

    public void run() {
        // bay tu duoi len
        position.y -= 3*i;
        position.x -= 0.5*i;
        i+=1;
    }
}
