package Control;

import Model.Field;
import Model.GameState;
import View.DrawField;

import javax.management.DescriptorRead;
import java.lang.constant.ModuleDesc;

public class Minesweeper {
    private Field field;
    private UserInput input;
    private DrawField draw;
    public Minesweeper()
    {
        UserInput input = new UserInput();
        input.selectDifficultyLevel();
        String difficulty = input.getDifficulty();
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
        field.generateField();
        DrawField draw = new DrawField(field);
        draw.drawField();
    }

    public static void main(String[] args) {
        Minesweeper mc = new Minesweeper();
    }
}
