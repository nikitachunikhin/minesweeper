package View;

import Model.Field;
import Control.Tile;

public class DrawField {
    private Field field;
    public DrawField(Field field)
    {
        this.field = field;
    }
    public void drawField()
    {
        Tile[][] map = field.getField();
        int countY = 0;
        System.out.print("   ");
        for (int i = 0; i <= field.getWidth()-1; i++) {
            if (i >= 10) {
                System.out.print(i + " ");
            }
            else
            {
                System.out.print(i + "  ");
            }
        }
        System.out.println("");
        for (int y = 0; y < field.getHeight(); y++) {
            if (y >= 10) {
                System.out.print(String.valueOf(countY) + " ");
            }
            else
            {
                System.out.print(String.valueOf(countY) + "  ");
            }
            for (int x = 0; x < field.getWidth(); x++) {
                System.out.print(map[y][x].draw());
                System.out.print("  ");
            }
            System.out.println("");
            countY += 1;
        }
    }
}
