package Model;


import Control.Tile;

public class Field {
    int height;
    int width;
    int numberOfMines;
    int numberOfOpendCells = 0;
    GameState state;
    Tile[][]


    //Constructor
    public Field(int height, int width, int numberOfMines){
        this.height = height;
        this.width = width;
        this.numberOfMines = numberOfMines;
        state = GameState.RUNNING;

    }

    public Tile[][] getField(){


    }

    public void changeGameStatus(Gamestate newState){
        state = GameState.newState;
    }


    public Tile getTile(int x, int y){

    }

    public int[][] generateMines(int numberOfMines){

    }

    public Tile[][] getNeighbour(int x, int y){

    }


}
