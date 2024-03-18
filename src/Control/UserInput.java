package Control;
import java.util.Scanner;
import enums.Difficulty;
public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public String[] getUserInput() {
        System.out.println("Enter your action (reveal/mark) followed by row and column numbers (e.g., reveal 2 3):");
        String input = scanner.nextLine();
        return input.split(" ");
    }

    public void processInput(String inputString){


    }

    public String getDifficultyLevel() {
        System.out.println("Select difficulty level (easy, medium, hard):");
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            try {
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid difficulty. Please select from easy, medium, or hard:");
            }
        }
    }

    public void GameLoop(){
        if(.getState == INITIAL){
            getDifficultyLevel();
        }
        else if(.getState == RUNNING){


        }
    }
}

