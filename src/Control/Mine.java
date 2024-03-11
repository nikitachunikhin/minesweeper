package Control;
import enums.CellType;

public class Mine extends Tile{
    protected CellType type;
    public Mine(int x, int y) {
        super(x, y);
        type = CellType.BOMB;
    }
    public boolean reveal()
    {
        revealed = true;
        System.out.println("Game over! You open a mine.");
        return true;
    }
}
