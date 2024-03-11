package Control;
import enums.CellType;
import Model.Field;

public class NumberedTile extends Tile{
    private int NumberOfAdjecentMines;
    protected CellType type;

    public NumberedTile(int x, int y, int numberOfAdjecentMines) {
        super(x, y);
        NumberOfAdjecentMines = numberOfAdjecentMines;
        type = CellType.NUMBERED;
    }
    public boolean reveal() {
        if (isRevealed())
        {
            return false;
        }
        else
        {
            revealed = true; // reveal the tile
            return true;
        }
    }
    public String draw()
    {
        return String.valueOf(NumberOfAdjecentMines);
    }
    public CellType getType() {
        return type;
    }
}
