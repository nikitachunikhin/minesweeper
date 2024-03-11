package Model;
import Control.Tile;

public class Field {
    protected int height;
    protected int width;
    protected int numberOfMines;
    protected int numberOfOpendCells = 0;
    protected GameState state;
    protected Tile[][] field;

    //Constructor
    public Field(int height, int width, int numberOfMines) {
        this.height = height;
        this.width = width;
        this.numberOfMines = numberOfMines;
        state = GameState.RUNNING;

    }

    public Tile[][] getField() {
        return field;
    }

    public void changeGameStatus(Gamestate newState) {
        state = GameState.newState;
    }


    public Tile getTile(int x, int y) {

    }

    public int[][] generateMines(int numberOfMines) {

    }

    public Tile[][] getNeighboursTiles(int x, int y) {
        Tile[][] surroundingTiles = new Tile[3][3];

        // Offsets for the 8 surrounding cells
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                surroundingTiles[nx][ny] = this.field[nx][ny];
            } else {
                surroundingTiles[nx][ny] = null;
            }
        }
        return surroundingTiles;
    }
}
