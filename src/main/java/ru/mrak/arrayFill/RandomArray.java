package ru.mrak.arrayFill;

import java.lang.Math;

public class RandomArray extends ArrayFill {
  public RandomArray(int size) {
    arr = new int[size];
    for(int i = 0; i < size; i++) {
      arr[i] = (int)(Math.random() * size);
    }
  }
}
