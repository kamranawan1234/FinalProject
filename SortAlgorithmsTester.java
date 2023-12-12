/**
 * @author Kamran Awan
 * This class tests the algorithms in the SortAlgorithms class.
 * It tests them using a array with 10k numbers and 200k numbers.
 */
public class SortAlgorithmsTester
{
    /**
     * this method is used to sort the arrays using the sorting algorithms with 10k numbers and then 200k numbers
     */
    public static void sort()
    {
        SortAlgorithms sortAlgorithms = new SortAlgorithms();

        // sorts with 10k numbers
        System.out.println("Sorting with size 10k:");
        sortAlgorithms.sort("Bubble Sort", 10000);
        sortAlgorithms.sort("Selection Sort", 10000);
        sortAlgorithms.sort("Insertion Sort", 10000);
        sortAlgorithms.sort("Merge Sort", 10000);
        sortAlgorithms.sort("Shell Sort", 10000);
        sortAlgorithms.sort("Quick Sort", 10000);
        sortAlgorithms.sort("Heap Sort", 10000);

        // sorts with 200k numbers
        System.out.println("Sorting with size 200k:");
        sortAlgorithms.sort("Bubble Sort", 200000);
        sortAlgorithms.sort("Selection Sort", 200000);
        sortAlgorithms.sort("Insertion Sort", 200000);
        sortAlgorithms.sort("Merge Sort", 200000);
        sortAlgorithms.sort("Shell Sort", 200000);
        sortAlgorithms.sort("Quick Sort", 200000);
        sortAlgorithms.sort("Heap Sort", 200000);
    }

    /**
     * the main method
     */
    public static void main(String[] args)
    {
        sort();
    }
}
