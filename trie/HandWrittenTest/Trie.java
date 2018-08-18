import java.util.LinkedList;

public class Trie{

	char letter;
	LinkedList<Trie> nextLetters;
	boolean isWord;

	public Trie(char ele){
		letter = ele;
		nextLetters = new LinkedList<Trie>();
		isWord = false;
	}

	private Trie findNode(Character letter){
		for(int i=0;i<nextLetters.size();i++){
			if(nextLetters.get(i).letter == letter){
				return nextLetters.get(i);
			}
		}
		return null;
	}

	public void addWord(String word){
		if(word.equals("")){
			this.isWord = true;
		}else{
			char first = word.charAt(0);
			Trie next = this.findNode(first);
			if(next != null){
				next.addWord(word.substring(1));
			}else{
				next = new Trie(first);
				nextLetters.add(next);
				next.addWord(word.substring(1));
			}
		}
	}

	public void removeWord(String word){
		if(!word.equals("")){
			char first = word.charAt(0);
			Trie next = findNode(first);
			if(next != null){
				next.removeWord(word.substring(1));
			}
		}else{
			this.isWord = false;
		}
	}

	public void printDict(String soFar){
		for(int i=0;i<nextLetters.size();i++){
			nextLetters.get(i).printDict(soFar + letter);
		}
		if(isWord){
			System.out.println(soFar + letter);
		}
	}

	public static void main(String[] args){
		Trie root = new Trie('\0');
		root.addWord("hello");
		root.addWord("hey");
		root.addWord("sup");
		root.addWord("supper");

		root.printDict("");

		root.removeWord("sup");

		root.printDict("");
	}
}
