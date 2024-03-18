package Control;

import Model.Field;
import View.DrawField;

import javax.management.DescriptorRead;

public class Minesweeper {
    private Field field;
    private UserInput input;
    private DrawField draw;
    public Minesweeper()
    {
        UserInput input = new UserInput();
        difficulty = input.
        if (difficulty.equals("difficult"))
        {
            DrawField draw = new DrawField(16, 30, 99);
        }
        else if(difficulty.equals("medium"))
        {
            DrawField draw = new DrawField(16,16,40);
        }
        else if(difficulty.equals("easy"))
        {
            DrawField draw = new DrawField(10,10,10);
        }
        else
        {
            System.out.println("We do not have this level of difficulty");
        }

    }
}
