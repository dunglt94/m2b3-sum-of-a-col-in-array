import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[][];
        int rows;
        int cols;

        do {
            System.out.print("Enter the number of rows: ");
            rows = scanner.nextInt();
            if (rows < 0) System.out.println("Invalid input");
            else if (rows > 5) System.out.println("Rows does not exceed 5");
        } while (rows < 1 || rows > 5);
        do {
            System.out.print("Enter the number of cols: ");
            cols = scanner.nextInt();
            if (cols < 0) System.out.println("Invalid input");
            else if (cols > 5) System.out.println("Cols does not exceed 5");
        } while (cols < 1 || cols > 5);
        arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter the value (row " + (i + 1) + "): ");
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The array: ");
        printArray(arr);
        calColSum(arr, cols);
    }

    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void calColSum(int arr[][], int cols) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int selectedCol;
        do {
            System.out.print("Calculate sum of column: ");
            selectedCol = scanner.nextInt();
            if (selectedCol < 1 || selectedCol > cols) System.out.println("Invalid input");
        } while (selectedCol < 1 || selectedCol > cols);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == selectedCol - 1) {
                    sum += arr[i][j];
                    break;
                }
            }
        }
        System.out.println("The sum of column " + selectedCol + " is: " + sum);
        continueOrEnd(arr, cols);
    }

    public static void continueOrEnd(int arr[][], int cols) {
        Scanner scanner = new Scanner(System.in);
        boolean isInput = false;
        int choice;
        do {
            System.out.println("Do you want to continue? (Y/N):");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    calColSum(arr, cols);
                    isInput = true;
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("No choice");
            }
        } while (!isInput);
    }
}
