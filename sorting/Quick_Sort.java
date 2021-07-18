import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class Quick_Sort {

    static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    static int partition(List<Integer> arr, int low, int high) {

        int pivot = arr.get(high);
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr.get(j) < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(buffer.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(toList());

        int n = arr.size();

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        System.out.println(arr);
    }
}