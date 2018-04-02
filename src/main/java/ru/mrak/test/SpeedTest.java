package ru.mrak.test;

import ru.mrak.arrayFill.*;

import ru.mrak.sort.*;

public class SpeedTest {
  
  public static void main(String[] args) {
  	ArrayFill[] arrays = {
  	  new RandomArray(10000),
  	  new SortArray(10000),
  	  new ReversedArray(10000),
  	  new NearlyArray(10000, 0.2)
  	};
  	Sort[] sortes = {
  	  //new HeapSort(),
  	  new HeapSortGit(),
  	  new QuickSort(),
  	  //new SelectionSort(),
  	  new InsertionSort(),
  	  new InsertionSortLine(),
  	  new MergeSort(),
  	  new JSort()
  	};
  	for(ArrayFill array: arrays)
  		for(Sort sort: sortes)
  			test(sort, array);
  }
  
  private static void test(Sort sort, ArrayFill arrayFill) {
    System.out.printf(
      "%-17s %-15s",
      sort.getClass().getSimpleName(),
      arrayFill.getClass().getSimpleName() + ": ");
    int[] arr = arrayFill.getArray();
    long start = System.currentTimeMillis();
    sort.sort(arr, true);
    long end = System.currentTimeMillis();
    System.out.println((end - start) + " ms");
  }
}
