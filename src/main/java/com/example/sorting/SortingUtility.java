package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] data) {

        int index = 0;
        while (index < data.length) {
            if ( index == 0 || data[index].compareTo(data[index - 1]) >= 0) {
                index++;
            } else {
                swap(data, index, index - 1);
                index--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {

        boolean swapper = true;
        int start = 0;
        int end = data.length - 1;

        while (swapper) {
            swapper = false;

            for (int i = start; i < end; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapper = true;
                }
            }

            if (!swapper) {
                break;
            }

            swapper = false;
            end--;

            for (int i = end; i > start; i--) {
                if (data[i].compareTo(data[i - 1]) < 0) {
                    swap(data, i, i - 1);
                    swapper = true;
                }
            }

            start++;
        }
    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {

        int n = data.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





