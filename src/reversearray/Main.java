package reversearray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    private static int[] readIntegers(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of integers, separated by commas:");
        String input = scanner.nextLine();

        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            values[i] = Integer.parseInt(splits[i].trim());
        }
        return values;
    }

    private static int[] reverseCopy(int[] array){

        int[] reversedArray = new int[array.length];
        int maxIndex = array.length - 1;
        for (int el : array){
            reversedArray[maxIndex--] = el;
        }

        return reversedArray;
    }
}
