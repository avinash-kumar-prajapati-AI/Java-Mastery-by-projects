import java.util.Scanner;  // Import Scanner class for reading user input

/**
 * 🧮 Simple Calculator
 * 
 * This project teaches:
 * - Class structure
 * - Methods (functions inside class)
 * - Mathematical operators
 * - User input with Scanner
 * - Control flow with switch
 * - Loops with do-while
 */
public class Calculator {
    
    // Scanner: Used to read input from the user (keyboard)
    // It's like a "bridge" between your program and the user
    private Scanner scanner;
    
    // Constructor: Special method called when object is created
    // Initializes the scanner for reading input
    public Calculator() {
        scanner = new Scanner(System.in);
    }
    
    // MAIN METHOD: Entry point of every Java program
    // When you run "java Calculator", this is where execution starts
    public static void main(String[] args) {
        
        // Create a Calculator object (instance)
        // This calls the constructor above
        Calculator calc = new Calculator();
        
        // Call the start method to begin the calculator
        calc.start();
    }
    
    // METHOD: A function inside a class
    // This method runs the main calculator loop
    public void start() {
        
        // VARIABLE: A container to store data
        // choice stores the user's menu selection
        int choice;
        
        // DO-WHILE LOOP: Runs at least once, then checks condition
        // Keeps the calculator running until user chooses to exit
        do {
            // Display the menu
            displayMenu();
            
            // Read user's choice
            choice = scanner.nextInt();
            
            // SWITCH STATEMENT: Checks multiple conditions
            // Like if-else but cleaner for many options
            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("👋 Goodbye! Thanks for using the calculator!");
                    break;
                default:
                    // This runs if user enters anything other than 1-5
                    System.out.println("❌ Invalid choice! Please try again.");
            }
            
            // Add a blank line for readability
            System.out.println();
            
        } while (choice != 5);  // Continue loop while choice is not 5
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
    
    // METHOD: Displays the menu options
    // void means this method doesn't return any value
    private void displayMenu() {
        System.out.println("========== 🧮 SIMPLE CALCULATOR ==========");
        System.out.println("1. ➕ Addition");
        System.out.println("2. ➖ Subtraction");
        System.out.println("3. ✖️  Multiplication");
        System.out.println("4. ➗ Division");
        System.out.println("5. 🚪 Exit");
        System.out.print("Enter your choice (1-5): ");
    }
    
    // METHOD: Performs addition
    private void performAddition() {
        // Get two numbers from user
        double[] numbers = getTwoNumbers("➕ Addition");
        
        // OPERATOR: + adds two numbers
        double result = numbers[0] + numbers[1];
        
        // Print result
        System.out.println("Result: " + numbers[0] + " + " + numbers[1] + " = " + result);
    }
    
    // METHOD: Performs subtraction
    private void performSubtraction() {
        double[] numbers = getTwoNumbers("➖ Subtraction");
        
        // OPERATOR: - subtracts second number from first
        double result = numbers[0] - numbers[1];
        
        System.out.println("Result: " + numbers[0] + " - " + numbers[1] + " = " + result);
    }
    
    // METHOD: Performs multiplication
    private void performMultiplication() {
        double[] numbers = getTwoNumbers("✖️  Multiplication");
        
        // OPERATOR: * multiplies two numbers
        double result = numbers[0] * numbers[1];
        
        System.out.println("Result: " + numbers[0] + " × " + numbers[1] + " = " + result);
    }
    
    // METHOD: Performs division
    private void performDivision() {
        double[] numbers = getTwoNumbers("➗ Division");
        
        // Check if divisor is zero (can't divide by zero!)
        if (numbers[1] == 0) {
            System.out.println("❌ Error: Cannot divide by zero!");
            return;
        }
        
        // OPERATOR: / divides first number by second
        double result = numbers[0] / numbers[1];
        
        System.out.println("Result: " + numbers[0] + " ÷ " + numbers[1] + " = " + result);
    }
    
    // METHOD: Helper to get two numbers from user
    // Returns an array with both numbers
    private double[] getTwoNumbers(String operationName) {
        double[] nums = new double[2];  // Array to store two numbers
        
        System.out.println("\n--- " + operationName + " ---");
        System.out.print("Enter first number: ");
        nums[0] = scanner.nextDouble();  // Read first number
        
        System.out.print("Enter second number: ");
        nums[1] = scanner.nextDouble();  // Read second number
        
        return nums;  // Return the array
    }
}

/*
 * =============================================================================
 * 📚 CONCEPT SUMMARY
 * =============================================================================
 * 
 * CLASS: A blueprint/template for creating objects
 *   - Calculator is a class that defines what a calculator can do
 * 
 * OBJECT: An instance of a class
 *   - Calculator calc = new Calculator(); creates an object
 * 
 * METHOD: A function inside a class
 *   - performAddition(), start(), main() are all methods
 * 
 * CONSTRUCTOR: Special method called when object is created
 *   - public Calculator() is the constructor
 * 
 * VARIABLE: A container for storing data
 *   - int choice, double[] numbers are variables
 * 
 * OPERATOR: Performs operations on values
 *   - + - * / are arithmetic operators
 * 
 * SCANNER: Reads user input from console
 *   - scanner.nextInt(), scanner.nextDouble()
 * 
 * SWITCH: Handles multiple conditions cleanly
 *   - switch(choice) { case 1: ... }
 * 
 * LOOP (do-while): Repeats code until condition is false
 *   - do { ... } while (choice != 5);
 * 
 * ARRAY: A container that holds multiple values
 *   - double[] nums = new double[2];
 * 
 * =============================================================================
 */