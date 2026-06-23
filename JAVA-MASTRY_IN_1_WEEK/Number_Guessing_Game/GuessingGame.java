import java.util.Random;   // Import Random class for generating random numbers
import java.util.Scanner;  // Import Scanner for reading user input

/**
 * 🎯 Number Guessing Game
 * 
 * This project teaches:
 * - Random number generation
 * - While loops
 * - If-else conditionals
 * - User input handling
 * - Methods and variables
 */
public class GuessingGame {
    
    // VARIABLES: Store game state
    // These are "instance variables" - they belong to the object
    private Scanner scanner;    // For reading user input
    private Random random;     // For generating random numbers
    private int targetNumber;  // The number user needs to guess
    private int attempts;      // How many guesses user made
    private int maxAttempts;   // Maximum allowed attempts
    private int minRange;      // Minimum random number
    private int maxRange;      // Maximum random number
    
    // CONSTRUCTOR: Initializes the game
    // Called when we create a new GuessingGame object
    public GuessingGame() {
        scanner = new Scanner(System.in);
        random = new Random();
        attempts = 0;
        maxAttempts = 10;      // User gets 10 attempts
        minRange = 1;
        maxRange = 100;
    }
    
    // MAIN METHOD: Entry point of the program
    public static void main(String[] args) {
        
        // Create game object
        GuessingGame game = new GuessingGame();
        
        // Start the game
        game.play();
    }
    
    // METHOD: Main game logic
    public void play() {
        
        // Display welcome message
        displayWelcome();
        
        // Generate a random number between minRange and maxRange
        // random.nextInt(100) gives 0-99, so we add 1 for 1-100
        targetNumber = random.nextInt(maxRange) + 1;
        
        // WHILE LOOP: Keeps running while user hasn't won AND has attempts left
        // This is a "pre-test" loop - checks condition BEFORE running
        while (attempts < maxAttempts) {
            
            // Display current attempt number
            System.out.println("\n🎯 Attempt " + (attempts + 1) + " of " + maxAttempts);
            System.out.print("Enter your guess (" + minRange + "-" + maxRange + "): ");
            
            // Get user's guess
            int guess = scanner.nextInt();
            attempts++;  // Increment attempts counter
            
            // IF-ELSE: Check the guess against target number
            if (guess == targetNumber) {
                // User guessed correctly!
                displayWin();
                break;  // Exit the loop
            } 
            else if (guess < targetNumber) {
                // User's guess is too low
                System.out.println("📈 Too LOW! Try a higher number.");
            } 
            else {
                // User's guess is too high
                System.out.println("📉 Too HIGH! Try a lower number.");
            }
        }
        
        // Check if user ran out of attempts
        if (attempts >= maxAttempts && targetNumber != 0) {
            displayLose();
        }
        
        // Ask if user wants to play again
        askPlayAgain();
    }
    
    // METHOD: Display welcome message
    private void displayWelcome() {
        System.out.println("========================================");
        System.out.println("   🎯 NUMBER GUESSING GAME 🎯");
        System.out.println("========================================");
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);
        System.out.println("You have " + maxAttempts + " attempts to guess it!");
        System.out.println("========================================");
    }
    
    // METHOD: Display win message
    private void displayWin() {
        System.out.println("\n🎉🎉🎉 CONGRATULATIONS! 🎉🎉🎉");
        System.out.println("You guessed the number in " + attempts + " attempt(s)!");
        
        // Calculate score based on attempts
        // Fewer attempts = higher score
        int score = (maxAttempts - attempts) * 10;
        System.out.println("📊 Your Score: " + score + " points");
    }
    
    // METHOD: Display lose message
    private void displayLose() {
        System.out.println("\n😢 GAME OVER! 😢");
        System.out.println("The number was: " + targetNumber);
        System.out.println("Better luck next time!");
    }
    
    // METHOD: Ask user to play again
    private void askPlayAgain() {
        System.out.print("\n🔄 Do you want to play again? (yes/no): ");
        String response = scanner.next().toLowerCase();  // Convert to lowercase
        
        // IF-ELSE: Check response
        if (response.equals("yes") || response.equals("y")) {
            // Reset game and play again
            attempts = 0;
            targetNumber = random.nextInt(maxRange) + 1;
            play();  // Recursive call - calling method from itself
        } else {
            System.out.println("👋 Thanks for playing! Goodbye!");
        }
        
        // Close scanner
        scanner.close();
    }
}

/*
 * =============================================================================
 * 📚 CONCEPT SUMMARY
 * =============================================================================
 * 
 * RANDOM CLASS: Generates random numbers
 *   - random.nextInt(100) gives 0-99
 *   - random.nextInt(100) + 1 gives 1-100
 * 
 * WHILE LOOP: Repeats while condition is true
 *   - while (attempts < maxAttempts) { ... }
 *   - Pre-test loop (checks condition first)
 * 
 * IF-ELSE: Conditional execution
 *   - if (condition) { ... } 
 *   - else if (condition) { ... }
 *   - else { ... }
 * 
 * VARIABLES: Store data
 *   - int targetNumber, attempts, maxAttempts
 *   - String response
 * 
 * METHODS: Reusable functions
 *   - play(), displayWelcome(), displayWin(), etc.
 * 
 * SCANNER: Read user input
 *   - scanner.nextInt() for numbers
 *   - scanner.next() for strings
 * 
 * BREAK: Exit loop early
 *   - break; exits the current loop
 * 
 * RECURSIVE CALL: Method calling itself
 *   - play(); called again from askPlayAgain()
 * 
 * STRING METHODS: 
 *   - toLowerCase() converts string to lowercase
 *   - equals() compares two strings
 * 
 * =============================================================================
 */