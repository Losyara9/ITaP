import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");

        int size = scanner.nextInt();
        int[] arr = new int[size];
        int sum = 0;

        try {
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size + 1; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
            }
            double average = (double) sum / size;
            System.out.println("Average: " + average);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input");
        }
    }
}
