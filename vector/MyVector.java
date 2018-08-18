

public class MyVector<T> implements Vector<T>{

	private static final int INITIALCAPACITY = 10;
	private Object[] elements;
	private int size;

	public static void main(String[] args){
		MyVector<String> strings = new MyVector();
		strings.add("ball");
		strings.add("hard");
		System.out.println(strings.toString());
		strings.remove("ball");
		System.out.println(strings);

		MyVector<Integer> numbers = new MyVector();
		for(int i=0;i<300;i++){
			numbers.add(i);
		}
		System.out.println(numbers);
		//for(int i=100;i<290;i++){
		//	numbers.remove(i);
		//}
		numbers.remove(291);
		System.out.println(numbers);
	}

	public MyVector(){
		elements = new Object[INITIALCAPACITY];
		size = 0;
	}

	public MyVector(int initSize) throws Exception{
		if(initSize>0){
			elements = new Object[initSize];
			size = 0;
		}else{
			throw new Exception("IllegalVectorSize");
		}
	}

	public int size(){
		return size;
	}

	public void add(T elem){
		if(!this.full()){
			elements[size] = elem;
			size++;
		}else{
			this.grow();
			elements[size] = elem;
			size++;
		}
	}

	public boolean remove(T elem){
		if(this.contains(elem)){
			int index = this.indexOf(elem);
			for(int i=index; i<size; i++){
				elements[i] = elements[i+1];
			}
			size--;
			return true;
		}else{
			return false;
		}
	}

	public void remove(int loc){
		if(loc<size){
			for(int i=loc; i<size; i++){
				elements[i] = elements[i+1];
				
			}
			size--;
		}

	}

	public T get(int loc){
		return (T)elements[loc];
	}

	private boolean full(){
		if(size<elements.length){
			return false;
		}else{
			return true;
		}
	}

	private void grow(){
		int current = size;
		Object[] temp = new Object[2*size];
		for(int i=0;i<size;i++){
			temp[i] = elements[i];

		}
		elements = temp;
	}

	public boolean contains(T elem){
		if(this.indexOf(elem) == -1){
			return false;
		}else{
			return true;
		}
	}

	public int indexOf(T elem){
		for(int i=0; i<size; i++){
			if(elem.equals((T)elements[i])){
				return i;
			}
		}
		return -1;
	}

	public String toString(){
		String result = "[";
		for(int i=0;i<size;i++){
			result += elements[i] + ", ";
		}
		return result.substring(0,result.length()-2)+"]";
	}
}