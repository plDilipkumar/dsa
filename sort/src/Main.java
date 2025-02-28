import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(arr));

        int[] bubbleSorted = arr.clone();
        bubbleSort(bubbleSorted);
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSorted));

        int[] selectionSorted = arr.clone();
        selectionSort(selectionSorted);
        System.out.println("Selection Sort: " + Arrays.toString(selectionSorted));

        int[] insertionSorted = arr.clone();
        insertionSort(insertionSorted);
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSorted));

        int[] mergeSorted = arr.clone();
        mergeSort(mergeSorted, 0, mergeSorted.length - 1);
        System.out.println("Merge Sort: " + Arrays.toString(mergeSorted));

        int[] quickSorted = arr.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("Quick Sort: " + Arrays.toString(quickSorted));

        int[] heapSorted = arr.clone();
        heapSort(heapSorted);
        System.out.println("Heap Sort: " + Arrays.toString(heapSorted));

        int[] radixSorted = arr.clone();
        radixSort(radixSorted);
        System.out.println("Radix Sort: " + Arrays.toString(radixSorted));

        int[] countingSorted = arr.clone();
        countingSort(countingSorted);
        System.out.println("Counting Sort: " + Arrays.toString(countingSorted));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortForRadix(arr, exp);
    }

    static void countingSortForRadix(int[] arr, int exp) {
        int n = arr.length, output[] = new int[n], count[] = new int[10];
        for (int value : arr) count[(value / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) output[--count[(arr[i] / exp) % 10]] = arr[i];
        System.arraycopy(output, 0, arr, 0, n);
    }

    static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1], output = new int[arr.length];
        for (int value : arr) count[value]++;
        for (int i = 1; i <= max; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) output[--count[arr[i]]] = arr[i];
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
