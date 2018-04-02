package ru.mrak.sort;

import ru.mrak.dataStructure.BinaryTree;
import java.util.Arrays;

public class HeapSort implements Sort{
  public int[] sort(int[] arr, boolean increace) {
    BinaryTree tree = new BinaryTree(arr);
    tree.normTree();
    for(int i = arr.length - 1; i >= 0; i--){
      tree.chenge();
    }
    return arr;
  }
  
  public static void main(String[] args) {
    //int[] arr = {5, 7, 2, 8, 6, 6};
    //System.out.println(Arrays.toString(arr));
    //sort(arr, true);
    //System.out.println(Arrays.toString(arr));
  }
}
