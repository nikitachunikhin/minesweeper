package Control;
import enums.CellType;
import Model.Field;

public class NumberedTile extends Tile{
    private int numberOfAdjacentMines;
    protected CellType type;

    public NumberedTile(int x, int y, int numberOfAdjacentMines) {
        super(x, y);
        this.numberOfAdjacentMines = numberOfAdjacentMines;
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
        return String.valueOf(numberOfAdjacentMines);
    }
    public CellType getType() {
        return type;
    }
}
