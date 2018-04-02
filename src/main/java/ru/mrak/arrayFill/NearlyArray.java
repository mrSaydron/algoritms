package ru.mrak.arrayFill;

import java.util.Random;

public class NearlyArray extends ArrayFill {
  public NearlyArray(int size, double diviation) {
    if(diviation > 1) diviation = 1;
    arr = new int[size];
    for(int i = 0; i < size; i++)
    	arr[i] = i;
    Random random = 
      new Random(System.currentTimeMillis());
    for(int i = 0; i < size; i++) {
      int select = random.nextInt((int)(size * diviation)) + i;
      if(select < size) {
        int buf = arr[i];
        arr[i] = arr[select];
        arr[select] = buf;
      }
    }
  }
}

