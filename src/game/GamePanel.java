package game;

import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    GameObject player;
//    Player player;
    Background background;
    // game.player.PlayerBullet bullet;
    // ArrayList: add(), remove(), size(), get()

    public GamePanel() {
        background = new Background();
        player = new Player();
//        Enemy enemy = new Enemy();
        EnemySummoner es = new EnemySummoner();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }
        // TODO: continue editing
        g.setColor(Color.BLACK);
        g.fillRect(384, 0, 416, 600);
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000 / 60) {
                // run logic
                this.runAll();
                // render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            // Player, Background, Enemy
            if(object.active) {
                object.run();
                // GameObject.run()
                // >> Player.run(), ..
            }
        }
    }
}
