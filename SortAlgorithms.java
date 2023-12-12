import java.util.Random;

/**
 * @author Kamran Awan
 * This class is used to sort arrays using sorting algorithms, validate that they work and, calculate the time taken to sort.
 * The sorts in this class include: bubbleSort(), selectionSort(), insertionSort(), mergeSort(), shellSort(), quickSort(), and, heapSort().
 */
public class SortAlgorithms
{
    /**
     * sorts the array using a bubble sort
     */
    public void bubbleSort(int[] array)
    {
        // gets each element in the array other than the last
        for (int i = 0; i < array.length - 1; i++)
        {
            // gets each element past the current in the array
            for (int j = i + 1; j < array.length; j++)
            {
                // checks if the current element is greater than the following element
                if (array[i] > array[j])
                {
                    // swaps the current element with the following element
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * sorts the array using a selection sort
     */
    public void selectionSort(int[] array)
    {
        // gets each element in the array other than the last
        for (int i = 0; i < array.length - 1; i++)
        {
            // initializes smallest as the current element and smallestIndex as it's index
            int smallest = array[i];
            int smallestIndex = i;

            // gets each element past the current in the array
            for (int j = i + 1; j < array.length; j++)
            {
                // checks if the following element is less than the smallest variable
                if (array[j] < smallest)
                {
                    // sets smallest to the following element and smallestIndex to it's index
                    smallest = array[j];
                    smallestIndex = j;
                }
            }

            // swaps the current element with the one with the smallest element
            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
    }

    /**
     * sorts the array using an insertion sort
     */
    public void insertionSort(int[] array)
    {
        // gets each element in the array
        for (int i = 0; i < array.length; i++)
        {
            // initializes temp as the current element and j as it's previous index
            int temp = array[i];
            int j = i - 1;

            // loops while j is greater than or equal to 0 and array[j] is greater than temp
            while (j >= 0 && array[j] > temp)
            {
                // sets array[j + 1] to array[j] and decrements j
                array[j + 1] = array[j];
                j--;
            }

            // sets array[j + 1] to temp
            array[j + 1] = temp;
        }
    }

    /**
     * merges the left and right arrays
     */
    private void merge(int[] array, int[] leftArray, int[] rightArray)
    {
        // initializes i, j, and k as 0
        int i = 0, j = 0, k = 0;

        // loops while i is less than leftArray.length and j is less than rightArray.length
        while (i < leftArray.length && j < rightArray.length)
        {
            // checks if the element leftArray[i] is less than or equal to the element rightArray[j]
            if (leftArray[i] <= rightArray[j])
            {
                // sets the element in array[k++] to the element leftArray[i++]
                array[k++] = leftArray[i++];
            }
            else
            {
                // sets the element in array[k++] to the element leftArray[j++]
                array[k++] = rightArray[j++];
            }
        }

        // loops while i is less than leftArray.length
        while (i < leftArray.length)
        {
            // sets the element in array[k++] to the element leftArray[i++]
            array[k++] = leftArray[i++];
        }

        // loops while j is less than rightArray.length
        while (j < rightArray.length)
        {
            // sets the element in array[k++] to the element rightArray[j++]
            array[k++] = rightArray[j++];
        }
    }

    /**
     * sorts the array using a merge sort
     */
    public void mergeSort(int[] array)
    {
        // returns if the array's length is less than 2
        if (array.length < 2)
        {
            return;
        }

        // initializes leftArray and rightArray
        int[] leftArray = new int[array.length / 2];
        int[] rightArray = new int[array.length - array.length / 2];

        // copies the left-sided elements in the array to the left array
        for (int i = 0; i < array.length / 2; i++)
        {
            leftArray[i] = array[i];
        }

        // copies the right-sided elements in the array to the right array
        for (int i = array.length / 2; i < array.length; i++)
        {
            rightArray[i - array.length / 2] = array[i];
        }

        // sorts leftArray and rightArray
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        // merges leftArray and rightArray
        merge(array, leftArray, rightArray);
    }

    /**
     * sorts the array using a shell sort
     */
    public void shellSort(int[] array)
    {
        // initializes interval as 1
        int interval = 1;

        // repeats while interval is less than or equal to array.length/3
        while (interval <= array.length / 3)
        {
            // increments interval and multiplies it by 3
            interval = interval * 3 + 1;
        }

        // repeats while interval is greater than 0
        while (interval > 0)
        {
            // gets each element in the array after the interval index
            for (int outer = interval; outer < array.length; outer++)
            {
                // initializes valueToInsert as array[outer] and inner as outer
                int valueToInsert = array[outer];
                int inner = outer;

                // repeats while inner is greater than interval - 1 and array[inner-interval] is greater than or equal to valueToInsert
                while (inner > interval - 1 && array[inner - interval] >= valueToInsert)
                {
                    array[inner] = array[inner - interval];
                    inner -= interval;
                }

                // sets array[inner] to valueToInsert
                array[inner] = valueToInsert;
            }

            // decrements interval and divides it by 3
            interval = (interval - 1) / 3;
        }
    }

    /**
     * partitions the array based on the pivots
     */
    private int partition(int[] array, int lowPivot, int highPivot)
    {
        // initializes the pivots
        int pivot = array[highPivot];
        int i = lowPivot - 1;

        // loops from the lowest pivot to the highest
        for (int j = lowPivot; j <= highPivot - 1; j++)
        {
            // checks if the current element is smaller than the pivot
            if (array[j] < pivot)
            {
                // increments the index of the smaller element
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swaps the lowest pivot element with the highest pivot element
        int temp = array[i + 1];
        array[i + 1] = array[highPivot];
        array[highPivot] = temp;

        // returns i + 1
        return (i + 1);
    }

    /**
     * sorts the array using a quick sort
     */
    public void quick(int[] array, int lowPivot, int highPivot)
    {
        // checks if the lowest pivot is less than the highest pivot
        if (lowPivot < highPivot)
        {
            // partitions the array
            int pivot = partition(array, lowPivot, highPivot);

            // sorts the array
            quick(array, lowPivot, pivot - 1);
            quick(array, pivot + 1, highPivot);
        }
    }

    /**
     * sorts the array using a quick sort
     */
    public void quickSort(int[] array)
    {
        quick(array, 0, array.length - 1);
    }

    /**
     * sorts the array using a heap sort
     */
    private void heap(int[] array, int length, int initial)
    {
        // initializes biggest, left, and right
        int biggest = initial;
        int left = 2 * initial + 1;
        int right = 2 * initial + 2;

        // checks if left is less than length and array[left] is greater than array[biggest]
        if (left < length && array[left] > array[biggest])
        {
            // sets biggest equal to left
            biggest = left;
        }

        // checks if right is less than length and array[right] is greater than array[biggest]
        if (right < length && array[right] > array[biggest])
        {
            // sets biggest to right
            biggest = right;
        }

        // checks if biggest is not equal to initial
        if (biggest != initial)
        {
            // swaps array[initial] and array[biggest]
            int temp = array[initial];
            array[initial] = array[biggest];
            array[biggest] = temp;

            // recursive call with the new biggest
            heap(array, length, biggest);
        }
    }

    /**
     * sorts the array using a heap sort
     */
    public void heapSort(int[] array)
    {
        // iterates through the left half of the array
        for (int i = array.length / 2 - 1; i >= 0; i--)
        {
            // adds the current value to the heap
            heap(array, array.length, i);
        }
        // iterates through the right half of the array
        for (int i = array.length - 1; i > 0; i--)
        {
            // swaps the first value in the array with the current value
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // adds the current value to the heap
            heap(array, i, 0);
        }
    }

    /**
     * checks if all the elements in the array are ordered
     */
    private boolean validate(int[] array)
    {
        // gets each element from the array other than the last
        for (int i = 0; i < array.length - 1; i++)
        {
            // checks if the current element is greater than the following element
            if (array[i] > array[i + 1])
            {
                // returns false
                return false;
            }
        }
        // returns ture
        return true;
    }

    /**
     * fills in the array with randomized numbers from 0 to 9
     */
    private void createArray(int[] array)
    {
        // iterates through each element of the array
        for (int i = 0; i < array.length; i++)
        {
            // sets the current element to a randomized integer between 0 to 9
            array[i] = new Random().nextInt(10);
        }
    }

    /**
     * creates the array and sorts it and, then it prints out how long it took to sort the array
     */
    public void sort(String sort, int size)
    {
        // creates an array based on the size
        int[] array = new int[size];
        createArray(array);

        // creates a variable to store the current time
        long previousTime = System.currentTimeMillis();

        // checks which sort to use and then sorts it based off that
        if (sort.equals("Bubble Sort"))
        {
            // sorts the array using a bubble sort
            bubbleSort(array);
        }
        else if (sort.equals("Selection Sort"))
        {
            // sorts the array using a selection sort
            selectionSort(array);
        }
        else if (sort.equals("Insertion Sort"))
        {
            // sorts the array using a insertion sort
            insertionSort(array);
        }
        else if (sort.equals("Merge Sort"))
        {
            // sorts the array using a merge sort
            mergeSort(array);
        }
        else if (sort.equals("Shell Sort"))
        {
            // sorts the array using a shell sort
            shellSort(array);
        }
        else if (sort.equals("Quick Sort"))
        {
            // sorts the array using a quick sort
            quickSort(array);
        }
        else if (sort.equals("Heap Sort"))
        {
            // sorts the array using a heap sort
            heapSort(array);
        }

        // creates a variable to store the current time after the sorting
        long currentTime = System.currentTimeMillis();

        // checks if the array is sorted
        if (validate(array))
        {
            // prints out how long it took to sort the array
            System.out.println(sort + " with size: " + size + " has passed with a time: " + (currentTime - previousTime));
        }
        else
        {
            // prints out that the sorting failed
            System.out.println(sort + " with size: " + size + " has failed");
        }
    }
}