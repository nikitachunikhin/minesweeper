package Control;
import enums.CellType;

import java.sql.Array;

public class Tile {
    protected boolean revealed;
    protected boolean flagged;
    protected int x;
    protected int y;
    protected CellType type;
    protected int[][] neighbours;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        flagged = false;
        revealed = false;
        type = CellType.EMPTY;
        int[][] neighbours = new int[3][3];
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
    public void flag()
    {
        flagged = true;
    }
    public void unflag()
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
}
