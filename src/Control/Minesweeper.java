package Control;

import Model.Field;
import Model.GameState;
import View.DrawField;

import javax.management.DescriptorRead;

public class Minesweeper {
    private Field field;
    private UserInput input;
    private DrawField draw;
    public Minesweeper()
    {
        UserInput input = new UserInput();
        String difficulty = input.getDifficultyLevel();

        if (difficulty.equals("hard"))
        {
            this.field = new Field(16, 30, 99);
        }
        else if(difficulty.equals("medium"))
        {
            this.field = new Field(16,16,40);
        }
        else
        {
            this.field = new Field(10,10,10);

        }
        DrawField draw = new DrawField(field);
        draw.drawField();
        while (field.getState().equals(GameState.WON))
        {
            input.getUserInput();
        }
    }
}
