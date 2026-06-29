import java.util.Scanner;

/**
 * 🌡️ Temperature Converter
 * 
 * This project demonstrates OOP principles:
 * - Encapsulation: Private variables + public methods
 * - Constructors: Initialize object state
 * - Instance Variables: Data belonging to each object
 * - Methods: Perform specific tasks
 */
public class TemperatureConverter {
    
    // ENCAPSULATION: Private variable only accessible within this class
    // This is the core concept - data is hidden from outside
    private double celsius;
    
    // Constructor: Called when you create new TemperatureConverter object
    // Initializes the temperature value
    public TemperatureConverter(double celsius) {
        this.celsius = celsius;
    }
    
    // Getter method to retrieve current Celsius value
    public double getCelsius() {
        return celsius;
    }
    
    // Setter method to update Celsius value
    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
    
    // Convert Celsius to Fahrenheit using formula: F = (C × 9/5) + 32
    public double toFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }
    
    // Convert Celsius to Kelvin using formula: K = C + 273.15
    public double toKelvin() {
        return celsius + 273.15;
    }
    
    // Display all temperature values in different scales
    public void displayTemperatures() {
        System.out.println("\n========== 🌡️ TEMPERATURE CONVERTER ==========");
        System.out.printf("Celsius:    %.2f°C%n", celsius);
        System.out.printf("Fahrenheit: %.2f°F%n", toFahrenheit());
        System.out.printf("Kelvin:     %.2f K%n", toKelvin());
        System.out.println("===========================================");
    }
    
    // MAIN METHOD: Entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create Temperature Converter object with initial value
        System.out.print("Enter initial temperature in Celsius: ");
        double initialTemp = scanner.nextDouble();
        
        // Constructor is called here - initializes celsius variable
        TemperatureConverter converter = new TemperatureConverter(initialTemp);
        
        // Menu-driven interface
        int choice;
        do {
            // Display menu options
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Display all temperatures");
            System.out.println("2. Convert Celsius to Fahrenheit");
            System.out.println("3. Convert Celsius to Kelvin");
            System.out.println("4. Update temperature");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            // Handle user choices using switch statement
            switch (choice) {
                case 1:
                    converter.displayTemperatures();
                    break;
                case 2:
                    System.out.printf("Fahrenheit: %.2f°F%n", converter.toFahrenheit());
                    break;
                case 3:
                    System.out.printf("Kelvin: %.2f K%n", converter.toKelvin());
                    break;
                case 4:
                    System.out.print("Enter new temperature in Celsius: ");
                    double newTemp = scanner.nextDouble();
                    converter.setCelsius(newTemp);
                    System.out.println("✅ Temperature updated!");
                    break;
                case 5:
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}

/*
 * =============================================================================
 * 📚 CONCEPT SUMMARY
 * =============================================================================
 * 
 * ENCAPSULATION:
 * - Private variable: private double celsius;
 * - Only methods of this class can access it directly
 * - Outside code MUST use public methods (getCelsius, setCelsius)
 * - This protects data integrity
 * 
 * CONSTRUCTOR:
 * - public TemperatureConverter(double celsius) { ... }
 * - Called automatically when object is created
 * - Initializes instance variables
 * - Like a "setup" method
 * 
 * INSTANCE VARIABLE:
 * - private double celsius;
 * - Each object has its own copy of this variable
 * - Two TemperatureConverter objects = two separate celsius values
 * 
 * GETTER METHOD:
 * - public double getCelsius() { return celsius; }
 * - Allows reading private data safely
 * - Doesn't modify data
 * 
 * SETTER METHOD:
 * - public void setCelsius(double celsius) { ... }
 * - Allows modifying private data safely
 * - Could add validation here (e.g., reject negative values)
 * 
 * OBJECT CREATION:
 * - TemperatureConverter converter = new TemperatureConverter(25);
 * - new keyword creates object instance
 * - Calls constructor with argument 25
 * 
 * METHOD CALLS:
 * - converter.toFahrenheit() calls method on the object
 * - Uses the object's celsius value
 * 
 * THIS KEYWORD:
 * - this.celsius = celsius;
 * - Refers to the object's variable
 * - Distinguishes from method parameter
 * 
 * =============================================================================
 */