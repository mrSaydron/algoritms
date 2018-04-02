package ru.mrak.sort;

public class SelectionSort implements Sort {
  public int[] sort(int[] arr, boolean increase) {
  	if(arr == null || arr.length <= 1) return arr;
  	if(arr.length > 100000) {
  		System.out.println("Is too long...");
  		return arr;
  	}
  	for(int i = 0; i < arr.length - 1; i++) { 
  		int selectNumber = i;
  		for(int j = i + 1; j < arr.length; j++) {
  			if(increase) {
  				if(arr[j] < arr[selectNumber]) {
  					selectNumber = j;
  				}
  			} else {
  				if(arr[j] > arr[selectNumber]) {
  					selectNumber = j;
  				}
  			}
  		}
  		int buffer = arr[i];
  		arr[i] = arr[selectNumber];
  		arr[selectNumber] = buffer;
  	}
  	return arr;
  }
}
