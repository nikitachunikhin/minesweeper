package Model;

import enums.GameState;
import Control.Tile;

public class Field {
    protected int height;
    protected int width;
    protected int numberOfMines;
    protected int numberOfOpendCells = 0;
    protected GameState state;
    protected Tile[][] field;


    //Constructor
    public Field(int height, int width, int numberOfMines){
        this.height = height;
        this.width = width;
        this.numberOfMines = numberOfMines;
        state = GameState.RUNNING;

    }

    public Tile[][] getField(){


    }

    public void changeGameStatus(GameState newState){
        state = GameState.newState;
    }


    public Tile getTile(int x, int y){

    }

    public int[][] generateMines(int numberOfMines){

    }

    public Tile[][] getNeighbour(int x, int y){

    }


}
