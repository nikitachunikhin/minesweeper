import Control.Minesweeper;
import Control.UserInput;
import Model.Field;
import Model.GameState;


public class Main {
    private int row;
    private int column;

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        while(minesweeper.getField().getState().equals(GameState.RUNNING)){
            minesweeper.getInput().getUserInput();
            if(minesweeper.getAction().equals("flag") ){
                minesweeper.flagTile();


            }
            else if (minesweeper.getAction().equals("unflag")) {
                minesweeper.unFlagTile();
            }

            else if (minesweeper.getAction().equals("reveal")) {
                minesweeper.revealTile();
            }

        }

    }
}