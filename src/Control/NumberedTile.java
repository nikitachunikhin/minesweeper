package Control;
import enums.CellType;
import Model.Field;

public class NumberedTile extends Tile{
    private int NumberOfAdjacentMines;
    protected CellType type;

    public NumberedTile(int x, int y, int numberOfAdjacentMines) {
        super(x, y);
        NumberOfAdjacentMines = numberOfAdjacentMines;
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
}
