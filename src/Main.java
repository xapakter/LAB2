import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int limit_print = 50;
        int[] arraySizes = {10, 1000, 10000, 1000000};
        for (int size : arraySizes) {
            System.out.println("Array size: " + size);
            ArrayList<Integer> inputArray = generateArray(size);
            for (SortingType type : SortingType.values()) {
                System.out.println("Sorting type: " + type);
                printArray(timer(inputArray,type), limit_print);
            }
        }
    }

    private static ArrayList<Integer> timer(ArrayList<Integer> inputArray, SortingType type) {
        Sorter sorter = typesorter(type);
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedArray = sorter.sort(inputArray);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " ms");
        return sortedArray;
    }

    private static ArrayList<Integer> generateArray(int size) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add((int) (Math.random() * size));
        }
        return array;
    }

    private static Sorter typesorter(SortingType type) {
        switch (type) {
            case BUBBLE:
                return new BubbleSorter();
            case SHELL:
                return new ShellSorter();
            case MERGE:
                return new MergeSorter();
            case QUICK:
                return new QuickSorter();
            default:
                throw new IllegalArgumentException("Unsupported sorting type: " + type);
        }
    }

    private static void printArray(ArrayList<Integer> array, int limit) {
        System.out.print("Sorted array: ");
        int printLimit = Math.min(limit, array.size());
        for (int i = 0; i < printLimit; i++) {
            System.out.print(array.get(i));
            if (i < printLimit - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}