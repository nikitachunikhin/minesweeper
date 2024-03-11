package Model;
import Control.Mine;
import Control.NumberedTile;
import Control.Tile;
import enums.CellType;
import enums.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void generateField() {
        field = new Tile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                field[y][x] = new Tile(x, y);
            }
        }
        List<List<Integer>> mines = generateMines();
        for (List<Integer> mineLoc: mines)
        {
            field[mineLoc.get(1)][mineLoc.get(0)] = new Mine(mineLoc.get(0), mineLoc.get(1));
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int count = 0;
                for (List<Integer> element: getNeighbors(x,y))
                {
                    if (field[element.get(1)][element.get(0)] instanceof Mine)
                    {
                        count += 1;
                    }
                }
                if (count > 0)
                {
                    field[y][x] = new NumberedTile(x, y, count);
                }
            }
        }
    }

    public List<List<Integer>> generateMines() {
        if (numberOfMines > height * width) {
            throw new IllegalArgumentException("Number of mines exceeds the total number of cells.");
        }

        int[][] mines = new int[height][width];
        List<List<Integer>> mineCoordinates = new ArrayList<>();

        Random random = new Random();

        // Generate mines randomly
        for (int i = 0; i < numberOfMines; i++) {
            int x, y;

            do {
                x = random.nextInt(width);
                y = random.nextInt(height);
            } while (mines[y][x] == 1);

            mines[y][x] = 1;  // Marking the cell as a mine
            List<Integer> coordinate = new ArrayList<>();
            coordinate.add(x);
            coordinate.add(y);
            mineCoordinates.add(coordinate);
        }

        return mineCoordinates;
    }

    public List<List<Integer>> getNeighbors(int x, int y) {
        List<List<Integer>> neighbors = new ArrayList<>();

        // Define the relative coordinates of the neighbors
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check if the new coordinates are within the bounds of the grid
            if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(newX);
                neighbor.add(newY);
                neighbors.add(neighbor);
            }
        }

        return neighbors;
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
    public void printField()
    {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
            {
                System.out.print(field[y][x].draw());
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Field fc = new Field(5, 10, 5);
        fc.generateField();
        fc.printField();
    }
}
