package Control;

import Model.Field;
import View.DrawField;
import enums.CellType;

public class Minesweeper {
    private Field field;
    private UserInput input;
    private DrawField draw;
    public Minesweeper() {
        this.input = new UserInput();
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
    public void revealTile()
    {
        int x = Integer.valueOf(input.getColumn());
        int y = Integer.valueOf(input.getRow());
        Tile accessTile;
        accessTile = field.getField()[x][y];
        if (!(accessTile.isRevealed()))
        {
            accessTile.reveal();
        }
        else
        {
            System.out.println("Tile is already revealed");
        }
        if (accessTile.getType().equals(CellType.BOMB))
        {
            field.changeStateToLoss();
        }
    }
    public void drawField()
    {
        draw.drawField();
    }
    public void flagTile()
    {
        int x = Integer.valueOf(input.getColumn());
        int y = Integer.valueOf(input.getRow());
        Tile accessTile;
        accessTile = field.getField()[x][y];
        if (!(accessTile.isFlagged()) && !(accessTile.isRevealed()))
        {
            accessTile.flag();
        }
        else
        {
            System.out.println("Tile is already flagged or opened");
        }
    }
    public void unFlagTile()
    {
        int x = Integer.valueOf(input.getColumn());
        int y = Integer.valueOf(input.getRow());
        Tile accessTile;
        accessTile = field.getField()[x][y];
        if ((accessTile.isFlagged()) && !(accessTile.isRevealed()))
        {
            accessTile.unFlag();
        }
        else
        {
            System.out.println("Tile is already opened or not flagged yet");
        }
    }
    public String getAction(){
        return input.getAction();
    }

    public int getRow() {
        return input.getRow();
    }

    public int getColumn() {
        return input.getColumn();
    }

    public Field getField() {
        return field;
    }

    public UserInput getInput() {
        return input;
    }
}
