package ru.mrak.sort;

import java.util.Arrays;

public class InsertionSortLine implements Sort {
  private int[] arr;
  
  public int[] sort(int[] arr, boolean increace) {
    int size = arr.length;
    this.arr = arr;
    for(int i = 1; i < size; i++) {
      int select = i;
      int compare = i - 1;
      while(arr[select] < arr[select - 1]) {
        swap(select);
        select--;
        if(select == 0) break;
      }
    }
    return arr;
  }
  
  private void swap(int index) {
    int buf = arr[index];
    arr[index] = arr[index - 1];
    arr[index - 1] = buf;
  }
  
  public static void main(String[] args) {
    int[] m = {5,3,7,1,9,8,7,2,0};
    new InsertionSortLine().sort(m,true);
    System.out.println(Arrays.toString(m));
  }
}
