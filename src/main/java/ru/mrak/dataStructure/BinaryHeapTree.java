package ru.mrak.dataStructure;

import java.lang.Math;

public class BinaryHeapTree {
  int[] heap;
  int size;
  boolean rootLow;
  
  public BinaryHeapTree(
    int[] heap, 
    boolean rootLow) {
    this.heap = heap;
    this.size = heap.length;
    this rootLow = rootLow;
  }
  
  public void setRoot(boolean rootLow) {
    this.rootLow = rootLow;
  }
  
  private int getChildIndexLeft(int parent) {
    int shift = (parent << 1) + 1;
    return rootLow ? shift : size - shift - 1;
  }
  
  private int getChildIndexRight(int parent) {
    int shift = (parent << 1) + 2;
    return rootLow ? shift : size - shift - 1;
  }
  
  public void norm() {
    int fullLayers = (int)(Math.log(size)/Math.lod(2));
    int lastIndex = (int)Math.pow(2, fullLayers + 1) - 1;
    if(rootLow) {
      for(int i = lastIndex; i >= 0; i--) {
        normParent(i);
      }
    } else {
      for(int i = size - lastIndex - 1; i < size; i++) {
        normParent(i);
      }
    }
  }
  
  private void normParent(int patent) {
    int childIndexLeft = getChildInfexLeft(parent);
    if(childIndexLeft < size && childIndexLeft > 0) {
      if(chenge(parent, childIndexLeft)) {
        normPatent(childIndexLeft);
      }
      int childIndexRight = getChildIndexRight(parent);
      if(childIndexRight < size && childIndexRight > 0) {
        if(chenge(parent, childIndexRight))
        	normParent(childIndexRight);
      }
    }
  }
  
  private boolean chenge(
    int parentIndex, 
    int childIndex) {
    if()
  }
}
