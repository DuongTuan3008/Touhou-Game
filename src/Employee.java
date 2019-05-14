import game.Vector2D;

import java.util.ArrayList;

public class Employee extends Human {
    public static void main(String[] args) {
        ArrayList<Vector2D> vectors = new ArrayList<>();
        //add(), remove(), size(), get()
        vectors.add(new Vector2D(1, 1));
        vectors.add(new Vector2D(4, 5));
        vectors.add(new Vector2D(2, 6));
        vectors.add(new Vector2D(3, 4));
        vectors.add(new Vector2D(5, 2));

        double maxTotal = 0;
        for (int i = 0; i < vectors.size(); i++) {
            Vector2D vector = vectors.get(i);
            System.out.println(vector.x + " " + vector.y);
            if (vector.x + vector.y > maxTotal) {
                maxTotal = vector.x + vector.y;
                int indexmax = i;
            }
        }
    }
}
