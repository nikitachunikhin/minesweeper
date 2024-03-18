package Control;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;
    private String action; // "reveal" or "flag"
    private int row;
    private int column;
    private String difficulty; // Difficulty level as a string

    public UserInput() {
        scanner = new Scanner(System.in);
        action = "";
        row = -1;
        column = -1;
        difficulty = ""; // Initialize with empty string
    }

    public void selectDifficultyLevel() {
        System.out.println("Select difficulty level (easy, medium, hard):");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("easy") || input.equals("medium") || input.equals("hard")) {
            difficulty = input;
        } else {
            System.out.println("Invalid difficulty selected. Defaulting to medium.");
            getHelp();
        }
    }

    public void getHelp(){
        System.out.println("Help Info//");
    }

    public String[] getUserInput() {
        System.out.println("Enter your action (reveal/mark) followed by row and column numbers (e.g., reveal 2 3):");
        String input = scanner.nextLine();
        processInput(input); // Process input right here
        return new String[]{action, String.valueOf(row), String.valueOf(column)}; // Return processed values
    }

    public void processInput(String inputString) {
        String[] parts = inputString.split(" ");
        if (parts.length == 3) {
            action = parts[0];
            try {
                row = Integer.parseInt(parts[1]);
                column = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid row or column numbers. Please enter numeric values.");
                row = -1;
                column = -1;
            }
        } else {
            System.out.println("Invalid input format. Please follow the format 'action row column'.");
            getHelp();
            action = "";
        }
    }

    // Getters
    public String getAction() {
        return action;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getDifficulty() {
        return difficulty;
    }

    //setter
    public void setAction(String action) {
        this.action = action;
    }

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.selectDifficultyLevel(); // Prompt the user to select difficulty level
        System.out.println("Difficulty Level: " + userInput.getDifficulty());
        userInput.getUserInput();
        System.out.println("Action: " + userInput.getAction() + ", Row: " + userInput.getRow() + ", Column: " + userInput.getColumn());
    }
}
