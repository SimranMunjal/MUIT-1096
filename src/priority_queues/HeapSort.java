package priority_queues;

public class HeapSort {
	
	public static void main(String[] args) {
		
		int arr[] = {4,2,5,7,4,3,5,6,7};
		inPlaceHeapSort(arr);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}

	private static void inPlaceHeapSort(int[] arr) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<arr.length;i++) {
			int childIndex = i;
			int parentIndex = (childIndex-1)/2;
			while(childIndex>0) {
				if(arr[childIndex]<arr[parentIndex]) {
					break;
				}
				else {
					int temp = arr[childIndex];
					arr[childIndex] = arr[parentIndex];
					arr[parentIndex] = temp;
					childIndex = parentIndex;
					parentIndex = (childIndex-1)/2;
				}
			}
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			int max = arr[0];
			arr[0] = arr[i];
			arr[i] = max;
			
			int parentIndex = 0;
			int leftChildIndex = 2*parentIndex+1;
			int rightChildIndex = 2*parentIndex+2;
			while(parentIndex<i) {
				int maxIndex = parentIndex;
				int maxValue = arr[maxIndex];
				if(leftChildIndex<i && arr[leftChildIndex]>maxValue) {
					maxIndex = leftChildIndex;
					maxValue = arr[leftChildIndex];
				}
				if(rightChildIndex<i && arr[rightChildIndex]>maxValue) {
					maxIndex = rightChildIndex;
					maxValue = arr[rightChildIndex];
				}
				if(parentIndex==maxIndex)
					break;
				else {
					arr[maxIndex] = arr[parentIndex];
					arr[parentIndex] = maxValue;
					parentIndex = maxIndex;
					leftChildIndex = 2*parentIndex+1;
					rightChildIndex = 2*parentIndex+2;
				}
			}
		}
	}

}
