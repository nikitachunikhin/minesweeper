package Control;

import enums.CellType;

public class NumberedTile extends Tile{
    private int NumberOfAdjecentMines;
    protected CellType type;

    public NumberedTile(int x, int y, int numberOfAdjecentMines) {
        super(x, y);
        NumberOfAdjecentMines = numberOfAdjecentMines;
        type = CellType.NUMBERED;
    }
    public boolean reveal()
    {
        if (isRevealed())
        {
            return false;
        }
        else
        {
            revealed = true;
            return true;
        }
    }
}
