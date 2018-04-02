package ru.mrak.sort;

import java.util.Arrays;

public class QuickSort implements Sort {
private int[] arr;
private boolean increace;

public int[] sort(int[] arr, boolean increace) {
    //QuickSort quickSort = new QuickSort();
    this.arr = arr;
    this.increace = increace;
    qsort(0, arr.length - 1);
    return this.arr;
}

private void qsort(int start, int end) {
  if(start == end) return;
  int left = start;
  int right = end;
    double cNumber = mediana(start, end);
    //System.out.println(start+" "+end+" "+cNumber);
    while(left < right) {
        if(arr[left] < cNumber) {
          left++;
        } else {
          if(arr[right] < cNumber) {
            int buf = arr[left];
            arr[left] = arr[right];
            arr[right] = buf;
            left++;
            right--;
          } else {
            right--;
          }
        }
    }
    if(left != right) {
      qsort(start, right);
      qsort(left, end);
    } else {
      if(arr[left] <= cNumber) {
        qsort(start, left);
        qsort(left + 1, end);
      } else {
        qsort(start, left - 1);
        qsort(left, end);
      }
    }
}

private double mediana(int start, int end) {
//System.out.println("s: " + start + " e: " + end);
if(start == end) return arr[start];
else if((end - start) == 1) 
    return (arr[start] + arr[end]) / 2.0;
else {
  //System.out.println((end + start)/2);
    return (arr[start] + arr[end] + 
    arr[(end + start)/2])/3.0;
}
}

  public static void main(String[] args) {
   int[] arr = {6, 3, 7, 1, 5, 2, 6, 3, 9, 4, 7};
   System.out.println(Arrays.toString(arr));
   new QuickSort().sort(arr, true);
   System.out.println(Arrays.toString(arr));
  }
}

