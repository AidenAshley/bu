import java.io.*;
import java.util.Random; 
import java.util.Scanner; 

public class BubbleSort
 {

    public static int[] createRandomArray(int arrayLength)
     {
        Random random = new Random(); 
        int[] array = new int[arrayLength]; 

        for (int i = 0; i < arrayLength; i++) 
        {
            array[i] = random.nextInt(101); 
        }
        return array; 
    }

    public static void writeArrayToFile(int[] array, String filename)
     {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) 
        {
            for (int num : array) 
            {
                writer.write(num + "\n"); 
            }
            System.out.println("Array written to file: " + filename);
        } catch (IOException e) 
        {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int[] readFileToArray(String filename) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            return reader.lines().mapToInt(Integer::parseInt).toArray(); 
        } catch (IOException e) 
        {
            System.out.println("Error reading from file: " + e.getMessage());
            return new int[0]; 
        }
    }

    
    public static void bubbleSort(int[] array) 
    {
        int n = array.length; 
        boolean swapped; 
        for (int i = 0; i < n - 1; i++) 
        {
            swapped = false; 
            for (int j = 0; j < n - 1 - i; j++) 
            {
                if (array[j] > array[j + 1]) 
                {
                    
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; 
                }
            }
            if (!swapped) 
            {
                break; 
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt(); 

        int[] randomArray = createRandomArray(length);

        String filename = "array.txt";

        writeArrayToFile(randomArray, filename);

        int[] readArray = readFileToArray(filename);
        System.out.println("Array read from file:");

        for (int num : readArray) 
        {
            System.out.print(num + " "); 
        }
        System.out.println(); 

        bubbleSort(readArray);
        System.out.println("Sorted array:");

        for (int num : readArray) 
        {
            System.out.print(num + " "); 
        }
        System.out.println(); 

        scanner.close();
    }
}