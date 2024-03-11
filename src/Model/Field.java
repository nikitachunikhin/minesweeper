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

        // Adjusted logic for assigning neighbors correctly
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = x + dx[i] - 1;
                int ny = y + dy[j] - 1;

                if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                    surroundingTiles[i][j] = this.field[nx][ny];
                } else {
                    surroundingTiles[i][j] = null;
                }
            }
        }
        return surroundingTiles;
    }
}
