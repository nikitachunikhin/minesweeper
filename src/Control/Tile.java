package Control;
import Model.Field;
import enums.CellType;
import java.sql.Array;

public class Tile {
    protected boolean revealed;
    protected boolean flagged;
    protected int x;
    protected int y;
    protected CellType type;
    protected int[][] neighbours;
    protected Field field;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        flagged = false;
        revealed = false;
        type = CellType.EMPTY;
        int[][] neighbours = new int[3][3];
    }
    public boolean reveal() {
        if (isRevealed()) {
            return false;
        }
        else {
            revealed = true;
            Tile[][] neighbours = field.getNeighboursTiles(this.getX(), this.getY()); // load in the array of surrounding tiles

            for (Tile[] row : neighbours) {
                for (Tile tile : row) {
                    if (tile != null && tile.getType() == CellType.EMPTY) {
                        tile.reveal();
                    }
                }
            }
            return true;
        }
    }

    public void flag()
    {
        flagged = true;
    }
    public void unFlag()
    {
        flagged = false;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellType getType() {
        return type;
    }
    public void assignNeighbors(int[][] tiles) {
        neighbours = tiles;
    }
    public String draw()
    {
        if (isRevealed())
        {
            return ".";
        }
        else
        {
            return "-";
        }
    }
}
