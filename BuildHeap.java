/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buildheap;

public class BuildHeap {

	
	static void heapify(int arr[], int N, int i){
		int enbuyuk = i; // en büyük olarak kök ü baslatıyor
		int sol = 2 * i + 1; // sol = 2*i + 1
		int sag = 2 * i + 2; // sag = 2*i + 2

		// eğer sol çocuk kökten büyükse
		if (sol < N && arr[sol] > arr[enbuyuk])
			enbuyuk = sol;

		// Sağdaki çocuk şimdiye kadarki en büyüğünden daha büyükse
		if (sag < N && arr[sag] > arr[enbuyuk])
			enbuyuk = sag;

		// en büyük kök değilse
		if (enbuyuk != i) {
			int swap = arr[i];
			arr[i] = arr[enbuyuk];
			arr[enbuyuk] = swap;

			
			heapify(arr, N, enbuyuk);
		}
	}

	// Diziden Max-Heap oluşturma işlevi
	static void buildHeap(int arr[], int N)
	{
		// son yaprak olmayan düğüm dizini
		int startIdx = (N / 2) - 1;

		
		for (int i = startIdx; i >= 0; i--) {
			heapify(arr, N, i);
		}
	}

	
	static void printHeap(int arr[], int N)
	{
		System.out.println("Heap İn dizi gösterimi:");

		for (int i = 0; i < N; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	public static void main(String args[])
	{
		
		int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
		int N = arr.length;
	
		buildHeap(arr, N);
		printHeap(arr, N);
	}
}
