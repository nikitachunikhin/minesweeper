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
        int countX = 0;
        int countY = 0;
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                System.out.print(map[y][x].draw());
                System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
