package View;

import Model.Field;
import Control.Tile;

public class DrawField {
    private Field field;
    public DrawField(int height, int width, int numberOfMines)
    {
        Field field = new Field(height, width, numberOfMines);
    }
    public void drawField(Field field)
    {
        Tile[][] map = field.getField();
        for (int y = 0; y < field.getHeight(); y++) {
            for (int x = 0; x < field.getWidth(); x++) {
                System.out.print(map[y][x].draw());
            }
            System.out.println("");
        }
    }
}
