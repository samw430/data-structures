import java.util.ArrayList;

public class Hash_Map<K,V>{
	
	private static class HashNode<K,V>{
		K key;
		V value;

		HashNode<K,V> next;

		public HashNode(K key, V value){
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	ArrayList<HashNode<K,V>> bins;
	int numberOfBins;

	public Hash_Map(){
		bins = new ArrayList<HashNode<K,V>>();
		numberOfBins = 10;
		for(int i=0;i<numberOfBins;i++){
			bins.add(null);
		}
	}

	public int getHash(K key){
		int jvmHash = key.hashCode();
		return jvmHash%numberOfBins;
	}

	public HashNode<K,V> findNode(K key){
		int hash = getHash(key);
		HashNode<K,V> head = bins.get(hash);
		while(head!=null){
			if(key.equals(head.key)){
				return head;
			}
			head = head.next;
		}
		return null;
	}

	public void add(K key, V value){
		HashNode<K,V> existing = findNode(key);
		if(existing == null){
			int hash = getHash(key);
			HashNode<K,V> currentHead = bins.get(hash);
			HashNode<K,V> newHead = new HashNode<K,V>(key,value);
			bins.remove(hash);
			bins.add(hash,newHead);
			newHead.next = currentHead;
		}
	}

	public void remove(K key){
		int hash = getHash(key);
		HashNode<K,V> head = bins.get(hash);
		HashNode<K,V> follower = null;
		while(head!=null){
			if(key.equals(head.key)){
				if(follower!=null){
					follower.next = head.next;
				}else{
					bins.remove(hash);
					bins.add(hash,null);
				}
			}
			follower = head;
			head = head.next;
		}
	}

	public V get(K key){
		HashNode<K,V> existing = findNode(key);
		if(existing!=null){
			return existing.value;
		}
		return null;
	}

	public static void main(String[] args){
		Hash_Map<String,Integer> map = new Hash_Map<String,Integer>();
		map.add("hey",5);
		map.add("yo", 8);
		map.add("fam", 6);
		System.out.println(map.get("hey"));
		System.out.println(map.get("yo"));
		System.out.println(map.get("fam"));
		map.remove("hey");
		System.out.println(map.get("hey"));
	}
}