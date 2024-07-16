import java.util.Scanner;

public class StudentMarksStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input assignment name
        System.out.print("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();

        // Array to hold student marks
        int[] marks = new int[30];

        // Input student marks
        for (int i = 0; i < marks.length; i++) {
            marks[i] = getValidMark(scanner, i + 1);
        }

        // Print assignment name and student marks
        System.out.println("\nAssignment: " + assignmentName);
        System.out.println("Student Marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();

        // Compute and print statistics
        int minMark = computeMinMark(marks);
        int maxMark = computeMaxMark(marks);
        double mean = computeMean(marks);
        double standardDeviation = computeStandardDeviation(marks, mean);

        System.out.println("Highest mark: " + maxMark);
        System.out.println("Lowest mark: " + minMark);
        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
    }

    // Function to get valid mark from user
    private static int getValidMark(Scanner scanner, int studentNumber) {
        int mark = -1;
        while (mark < 0 || mark > 30) {
            System.out.print("Enter mark for student " + studentNumber + " (0-30): ");
            if (scanner.hasNextInt()) {
                mark = scanner.nextInt();
                if (mark < 0 || mark > 30) {
                    System.out.println("Error: Invalid mark. Please enter a number between 0 and 30.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
        return mark;
    }

    // Function to compute the minimum mark
    private static int computeMinMark(int[] marks) {
        int min = marks[0];
        for (int mark : marks) {
            if (mark < min) {
                min = mark;
            }
        }
        return min;
    }

    // Function to compute the maximum mark
    private static int computeMaxMark(int[] marks) {
        int max = marks[0];
        for (int mark : marks) {
            if (mark > max) {
                max = mark;
            }
        }
        return max;
    }

    // Function to compute the mean
    private static double computeMean(int[] marks) {
        double sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / marks.length;
    }

    // Function to compute the standard deviation
    private static double computeStandardDeviation(int[] marks, double mean) {
        double sumOfSquares = 0;
        for (int mark : marks) {
            sumOfSquares += Math.pow(mark - mean, 2);
        }
        return Math.sqrt(sumOfSquares / marks.length);
    }
}
