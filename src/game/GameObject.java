package game;

import game.player.Player;
import game.player.PlayerBullet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject { //Player, BackGround, PlayerBullet...
    // quan ly doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycle(Class<E> cls){
        E object = findInactive(cls);
        if(object != null){
            object.reset();
            return object;
        }try{
            object = cls.getConstructor().newInstance();
            return object;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static <E extends GameObject> E findInactive(Class<E> cls){//Player.class || Background.clas...
        //TODO:
        for(int i = 0; i<objects.size(); i++){
            GameObject object = objects.get(i);
            if(cls.isAssignableFrom(object.getClass())
                    && !object.active){
                return (E)object;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Player deactivedPlayer = findInactive(Player.class);
        PlayerBullet deactivedBullet = findInactive(PlayerBullet.class);
    }
    // dinh nghia doi tuong
    public BufferedImage image;
    public Vector2D position;
    public boolean active;

    public GameObject() {
        objects.add(this);
        System.out.println(objects.size());
        position = new Vector2D();
        active = true;
    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image, (int) position.x, (int) position.y, null);
        }
    }

    public void run() {
    }

    public void deactive(){
        active =false;
    }

    public void reset(){
        active = true;
    }
}
