package ru.mrak.arrayFill;

public class ReversedArray extends ArrayFill{
  public ReversedArray(int size) {
    arr = new int[size];
    for(int i = 0; i < size; i++)
    	arr[i] = size - i - 1;
  }
}
