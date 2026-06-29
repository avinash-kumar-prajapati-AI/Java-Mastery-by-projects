import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManager {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n========== 🎓 STUDENT GRADE MANAGER ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Show Average Grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    showAverageGrade();
                    break;
                case 4:
                    running = false;
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        double[] grades = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            scanner.nextLine();
        }

        students.add(new Student(name, grades));
        System.out.println("✅ Student added successfully.");
    }

    private static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students added yet.");
            return;
        }

        for (Student student : students) {
            System.out.println("\nName: " + student.getName());
            System.out.println("Grades: " + student.getGradesAsString());
            System.out.println("Average: " + student.calculateAverage());
        }
    }

    private static void showAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students added yet.");
            return;
        }

        double total = 0;
        int count = 0;

        for (Student student : students) {
            total += student.calculateAverage();
            count++;
        }

        double classAverage = count == 0 ? 0 : total / count;
        System.out.println("📊 Class Average: " + classAverage);
    }

    private static class Student {
        private String name;
        private double[] grades;

        public Student(String name, double[] grades) {
            this.name = name;
            this.grades = grades;
        }

        public String getName() {
            return name;
        }

        public String getGradesAsString() {
            // Use StringBuilder to efficiently build the grades string, mutable and avoids creating multiple String objects to reduce memory usage and improve performance
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < grades.length; i++) {
                if (i > 0) {
                    builder.append(", ");
                }
                builder.append(grades[i]);
            }
            return builder.toString();
        }

        public double calculateAverage() {
            double total = 0;
            for (double grade : grades) {
                total += grade;
            }
            return grades.length == 0 ? 0 : total / grades.length;
        }
    }
}
