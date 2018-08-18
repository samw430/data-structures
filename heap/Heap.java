import java.util.Vector;

public class Heap{
	int size;
	Vector<Integer> heap;

	public Heap(){
		size = 0;
		heap = new Vector<Integer>();
	}

	public void add(int value){
		heap.add(value);
		bubbleUp();
		size++;
	}

	public Integer getMin(){
		if(!heap.isEmpty()){
			int value = heap.get(0);
			//System.out.println(value);
			heap.removeElementAt(0);
			size--;
			if(size>0){
				heap.insertElementAt(heap.get(size-1),0);
				heap.removeElementAt(size);
			}
			bubbleDown();
			return value;
		}
		return null;
	}

	private void bubbleUp(){
		int firstIndex = size;
		int secondIndex = size/2;

		while(firstIndex>0){
			int firstValue = heap.get(firstIndex);
			int secondValue = heap.get(secondIndex);
			if(secondValue>firstValue){
				heap.removeElementAt(firstIndex);
				heap.removeElementAt(secondIndex);
				heap.insertElementAt(firstValue,secondIndex);
				heap.insertElementAt(secondValue,firstIndex);
			}
			firstIndex = secondIndex;
			secondIndex = firstIndex/2;
		}
	}

	private void bubbleDown(){
		int firstIndex = 0;
		int secondIndex = 1;

		while(secondIndex<=size-1){
			int firstValue = heap.get(firstIndex);
			int secondValue = heap.get(secondIndex);
			if(secondValue<firstValue){
				heap.removeElementAt(secondIndex);
				heap.removeElementAt(firstIndex);
				heap.insertElementAt(secondValue,firstIndex);
				heap.insertElementAt(firstValue,secondIndex);
			}
			firstIndex = secondIndex;
			secondIndex = firstIndex*2;
		}
	}

	public void printHeap(){
		System.out.println(heap.toString());
	}

	public static void main(String[] args){
		Heap root = new Heap();
		root.add(5);
		root.add(6);
		root.add(4);
		root.add(37);
		root.add(1);
		root.printHeap();
		System.out.println(root.getMin());
		System.out.println(root.getMin());
		System.out.println(root.getMin());
		System.out.println(root.getMin());
		System.out.println(root.getMin());
	}


}