package ru.mrak.dataStructure;

import java.util.Arrays;

public class BinaryTree {
  private int[] arr;
  private int size;
  
  public BinaryTree(int size) {
    arr = new int[size];
    size = 0;
  }
  
  public BinaryTree(int[] arr) {
    this.arr = arr;
    size = arr.length;
  }
  
  public void add(int number) {
    arr[size] = number;
    size++;
    normChild(size - 1);
  }
  
  public int removeLast() {
    return arr[--size];
  }
  
  public int getSize() {
    return size;
  }
  
  private int getParent(int child) {
    return ((child + 1) >> 1) - 1;
  }
  
  private int getChild(int parent) {
    return (parent << 1) + 1;
  }
  
  private void normChild(int child) {
    if(child == 0) return;
    int parent = getParent(child);
    if(arr[child] > arr[parent]) {
      int buf = arr[child];
      arr[child] = arr[parent];
      arr[parent] = buf;
      normChild(parent);
    }
  }
  
  public void normTree() {
    //normParent(0);
    for(int i = 1; i < size; i++) {
      normChild(i);
    }
  }
  
  private void normParent(int parent) {
    int child = getChild(parent);
    if(child >= size) return;
    if(arr[child] > arr[parent]) {
      int buf = arr[child];
      arr[child] = arr[parent];
      arr[parent] = buf;
      normParent(child);
    }
    child++;
    if(child >= size) return;
    if(arr[child] > arr[parent]) {
      int buf = arr[child];
      arr[child] = arr[parent];
      arr[parent] = buf;
      normParent(child);
    }
  }
  
  public int getRoot() {
    return arr[0];
  }
  
  public int getLast() {
    return arr[size - 1];
  }
  
  public int setRoot(int number) {
    int buf = arr[0];
    arr[0] = number;
    normParent(0);
    return buf;
  }
  
  public int setLast(int number) {
    return arr[size - 1] = number;
  }
  
  public void chenge() {
    size--;
    int buf = arr[0];
    arr[0] = arr[size];
    arr[size] = buf;
    normParent(0);
  }
  
  public String toString() {
    return Arrays.toString(
      Arrays.copyOfRange(arr, 0, size));
  }
  
  
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(100);
    tree.add(5);
    tree.add(3);
    tree.add(8);
    tree.add(9);
    tree.setRoot(1);
    tree.add(9);
    
    System.out.println(tree);
  }
}
