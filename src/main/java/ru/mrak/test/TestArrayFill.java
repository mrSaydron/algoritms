package ru.mrak.test;

import ru.mrak.arrayFill.*;

import java.util.Arrays;

public class TestArrayFill {
  public static void main(String[] args) {
    ArrayFill arrayFill = new NearlyArray(10, 0.2);
    int[] arr = arrayFill.getArray();
    System.out.println(
      Arrays.toString(arr));
  }
}
