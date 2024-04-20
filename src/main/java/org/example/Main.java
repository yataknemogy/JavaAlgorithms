package org.example;

public class Main {

  // Запуск
  public static void main(String[] args) {
    int[] sortArr = {1, 6, 4, 8, 456, 32};
//   Вызов метода нашей сортировки
    bubbleSort(sortArr);
    for (int i = 0; i < sortArr.length; i++) {
      System.out.println(sortArr[i]);
    }
  }

  //  Сортировка пузырьком
  public static void bubbleSort(int[] sortArr) {
    boolean swapped;
    for (int i = 0; i < sortArr.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < sortArr.length - i - 1; j++) {
        if (sortArr[j + 1] < sortArr[j]) {
          swapped = true;
          int swap = sortArr[j];
          sortArr[j] = sortArr[j + 1];
          sortArr[j + 1] = swap;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }

  //  Сортировка выбором
  public static void selectionSort(int[] sortArr) {
    for (int i = 0; i < sortArr.length; i++) {
      int pos = i;
      int min = sortArr[i];
      for (int j = i + 1; j < sortArr.length; j++) {
        if (sortArr[j] < min) {
          pos = j;
          min = sortArr[j];
        }
      }
      sortArr[pos] = sortArr[i];
      sortArr[i] = min;
    }
  }

  //  Быстрая сортировка
  public static void quickSort(int[] sortArr, int low, int high) {
    if (sortArr.length == 0 || low >= high)
      return;
    int middle = low + (high - low) / 2;
    int border = sortArr[middle];
    int i = low, j = high;
    while (i <= j) {
      while (sortArr[i] < border)
        i++;
      while (sortArr[j] > border)
        j--;
      if (i <= j) {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
        i++;
        j--;
      }
    }
  }

  //  Сортировка слиянием
  public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
    if (startIndex >= endIndex - 1) {
      return buffer1;
    }
    int middle = startIndex + (endIndex - startIndex) / 2;
    int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
    int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);
    int index1 = startIndex;
    int index2 = middle;
    int destIndex = startIndex;
    int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
    while (index1 < middle && index2 < endIndex) {
      result[destIndex++] = sorted1[index1] < sorted2[index2]
      ? sorted1[index1++] : sorted2[index2++];
    }
    while (index1 < middle) {
      result[destIndex++] = sorted1[index1++];
    }
    while (index2 < endIndex) {
      result[destIndex++] = sorted2[index2++];
    }
    return result;
  }

  //  Алгоритм линейного поиска
  public static int linearSearch(int arr[], int elementToSearch){
    for (int index = 0; index < arr.length; index++) {
      if (arr[index] == elementToSearch)
        return index;
    }
    return -1;
  }

//  Алгоритм двоичного поиска
  public static int binarySearch(int arr[], int elementToSearch) {
    int firstIndex = 0;
    int lastIndex = arr.length - 1;
    while(firstIndex <= lastIndex) {
      int middleIndex = (firstIndex + lastIndex) / 2;
      if (arr[middleIndex] == elementToSearch) {
        return middleIndex;
      }
      else if (arr[middleIndex] < elementToSearch)
        firstIndex = middleIndex + 1;
      else if (arr[middleIndex] > elementToSearch)
        lastIndex = middleIndex - 1;
    }
    return -1;
  }
}