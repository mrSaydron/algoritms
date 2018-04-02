package ru.mrak.arrayFill;

public abstract class ArrayFill {
  protected int[] arr;
  
  public int[] getArray() {
    int[] newArr = new int[arr.length];
    System.arraycopy(arr, 0, newArr, 0, arr.length);
    return newArr;
  }
}
