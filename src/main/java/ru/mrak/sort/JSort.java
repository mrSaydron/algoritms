package ru.mrak.sort;

import java.lang.Math;
import java.util.Arrays;

import ru.mrak.sort.*;

public class JSort implements Sort{
  int[] heap;
  int size;
  boolean rootLow;
  
  public int[] sort(int[] arr, boolean increace) {
    this.heap = arr;
    this.size = arr.length;
    rootLow = true;
    System.out.println(Arrays.toString(heap));
    norm();
    System.out.println(Arrays.toString(heap));
    rootLow = false;
    norm();
    return new InsertionSortLine().sort(heap,true);
  }
  
  private int getChildIndexLeft(int parentIndex) {
    return rootLow ? 
    	(parentIndex << 1) + 1 : 
    	size - ((size - parentIndex) << 1);
  }
  
  private int getChildIndexRight(int parentIndex) {
    return rootLow ? 
    	(parentIndex << 1) + 2 : 
    	size - ((size - parentIndex) << 1) - 1;
  }
  
  public void norm() {
    if(rootLow) {
      for(int i = size - 1; i >= 0; i--) {
        normParent(i);
      }
    } else {
      for(int i = 0; i < size; i++) {
        normParent(i);
      }
    }
  }
  
  private void normParent(int parentIndex) {
    System.out.println(parentIndex);
    int childIndexLeft = getChildIndexLeft(parentIndex);
    if(childIndexLeft < size && childIndexLeft >= 0) {
      if(chenge(parentIndex, childIndexLeft)) {
        normParent(childIndexLeft);
      }
    }
    int childIndexRight = getChildIndexRight(parentIndex);
    if(childIndexRight < size && childIndexRight >= 0) {
      if(chenge(parentIndex, childIndexRight))
        normParent(childIndexRight);
    }
  }
  
  private boolean chenge(
    int parentIndex, 
    int childIndex) {
    if(rootLow) {
    	if(heap[parentIndex] > heap[childIndex]) {
    		int buf = heap[parentIndex];
      	heap[parentIndex] = heap[childIndex];
      	heap[childIndex] = buf;
  			return true;
  		}
    } else {
      if(heap[parentIndex] < heap[childIndex]) {
    		int buf = heap[parentIndex];
      	heap[parentIndex] = heap[childIndex];
      	heap[childIndex] = buf;
  			return true;
  		}
    }
    return false;
  }
  
  public static void main(String[] args) {
    JSort jSort = new JSort();
    int[] arr = {5,2,7,3,8,1,9};
    jSort.sort(arr, true);
    System.out.println(Arrays.toString(arr));
  }
}
