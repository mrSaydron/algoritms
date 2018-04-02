package ru.mrak.sort;

public class InsertionSort implements Sort {
  public int[] sort(int[] arr, boolean increase) {
    if(arr == null || arr.length <= 1) return arr;
    if(arr.length > 100000) {
      System.out.println("Is too long...");
      return arr;
      }
      if(increase ^ (arr[0] < arr[1])) {
        int buffer = arr[0];
        arr[0] = arr[1];
        arr[1] = buffer;
        }
        if(arr.length == 2) return arr;
        for(int i = 2; i < arr.length; i++) {
          int shiftPos = findNearPos(arr, 0, i - 1, arr[i], increase);
          shift(arr, shiftPos, i);
          }
         return arr;
         }
         
         
	private int findNearPos(
	  int[] arr, 
	  int startPos, 
	  int endPos, 
	  int number, 
	  boolean increase) {
	  if(startPos == endPos) {
	    if((number > arr[startPos]) ^ increase) 
	    return startPos;
	    else return startPos + 1;
	    }
	    int comparePos = (startPos + endPos) / 2;
	    if((number > arr[comparePos]) ^ increase)
	    	return findNearPos(
					arr, 
	      	startPos, 
	      	comparePos, 
	      	number, 
	      	increase);
	      else
	      	return findNearPos(
	      	  arr, 
	      	  comparePos + 1, 
	      	  endPos, 
	      	  number, 
	      	  increase);
	      	}
	      	
	private int[] shift(
	  int[] arr, 
	  int startShift, 
	  int endShift) {
	  if(startShift == endShift) return arr;
	  int buffer = arr[endShift];
	  for(int i = startShift; i <= endShift; i++) {
	    int bufferFor = arr[i];
	    arr[i] = buffer;
	    buffer = bufferFor;
	  }
	  return arr;
	  } 
}
