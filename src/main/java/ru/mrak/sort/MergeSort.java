package ru.mrak.sort;

public class MergeSort implements Sort {
  public int[] sort(int[] arr, boolean increase) {
    int[] sArr = arr;
    int[] wArr = new int[arr.length];
    int arrSize = 1;
    int workSize = 2;
    for(int i = (int)Math.round(arr.length / 2.0); i >= 1; i = i > 1 ? (int)Math.round(i / 2.0) : 0) {
      for(int j = 0; j < i; j++) {
        int ferstStart = j * workSize;
        int ferst = 0;
        int secondStart = ferstStart + arrSize;
        int second = 0;
        if(secondStart >= arr.length) second = -1;
        for(int k = j * workSize; k < (j + 1) * workSize && k < arr.length; k++) {
          if(ferst >= 0 && second >= 0) {
            if((sArr[ferstStart + ferst] > sArr[secondStart + second]) ^ increase) {
              wArr[k] = sArr[ferstStart + ferst];
              ferst++;
              if((ferst >= arrSize) || ((ferstStart + ferst) >= arr.length)) ferst = -1;
              } else {
                wArr[k] = sArr[secondStart + second];
                second++;
                if((second >= arrSize) || ((secondStart + second) >= arr.length)) second = -1;
                }
                } else if(ferst >= 0) {
                  wArr[k] = sArr[ferstStart + ferst];
                  ferst++;
                  } else {
                    wArr[k] = sArr[secondStart + second];
                    second++;
                    }
                    }
                    }
                    arrSize *= 2;
                    workSize *= 2;
                    int[] buf = sArr;
                    sArr = wArr;
                    wArr = buf;
                    }
                    return sArr;
                    } 
}
