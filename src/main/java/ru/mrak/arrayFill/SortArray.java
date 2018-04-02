package ru.mrak.arrayFill;

public class SortArray extends ArrayFill {
  public SortArray(int size) {
    arr = new int[size];
    for(int i = 0; i < size; i++)
    	arr[i] = i;
  }
}
